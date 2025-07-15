import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Library {
    protected ArrayList<Item> listOfItems;
    protected ArrayList<Project> listOfProjects = new ArrayList<>();
    protected ArrayList<Book> listOfBooks = new ArrayList<>();
    protected ArrayList<Member> listOfMembers;
    protected ArrayList<Member> listOfPenalisedMembers = new ArrayList<>();
    Scanner in = new Scanner(System.in);
    private int mId ;

    public Library(ArrayList<Item> listOfItems, ArrayList<Member> list0fMembers ) {
        this.listOfItems = listOfItems;
        this.listOfMembers = list0fMembers;
        for(Item item : listOfItems){
            if(item instanceof Book){
                listOfBooks.add((Book) item);
            }
            else if(item instanceof Project){
                listOfProjects.add((Project) item);
            }
        }
        PenaliseMembers();
    }

    void RegisterItem() {
        if(mId == 0){
            System.out.println("you have to sign up or log in first:");
            System.out.println("1.sign up (you don't have an account)   2.log in (you already have an account");
            int v = in.nextInt();
            if(v == 2){
                mId = getMid();
                if(mId == 0) return;
            }
            else if (v == 1) {
                RegisterMember();
            }
            else
                System.out.println("! wrong input");
            return;
        }
        System.out.println("What type of item do you want to register ? \n 1.for Book \n 2.for Project");
        int n =in.nextInt();

        if(n==1) {

            RegisterBook();

            }

        else if(n==2){

              RegisterProject();

            }
        else
            System.out.println("Wrong Number ");
        }

    void RegisterBook() {

            System.out.println("Enter title :");
            String t = in.next();
            System.out.println("Enter year of publishing :");
            int y=in.nextInt();
            System.out.println("Enter topic :");
            String to=in.next();
            System.out.println("Enter author name :");
            String a=in.next();
            System.out.println("Enter number of pages :");
            int n=in.nextInt();
            System.out.println("Enter publisher :");
            String p=in.next();
            Book book = new Book(t,y,to,a,n,p) ;


            listOfBooks.add(book);
            listOfItems.add(book);
            System.out.println(book.title + " is registered successfully !");

     }

    void RegisterProject() {
        String[] team = new String[6];
        System.out.println("Enter title :");
        String t=in.next();
        System.out.println("Enter year of publishing :");
        int y=in.nextInt();
        System.out.println("Enter topic :");
        String to=in.next();
        System.out.println("Enter project year (1-5) :");
        int p=in.nextInt();
        System.out.println("please enter how many people worked on this project (6 people is the limit)");
        int num = in.nextInt();
        if(num < 6 && num > 0){
        System.out.println("please enter each students name");
        for(int i = 0; i < num  ; i++ ){
            System.out.print("enter: ");
            String name = in.next();
            team[i] = name;
        }}
        else {
            System.out.println("wrong input, the limit is 6 students");
            for (int i = 0; i < 6; i++) {
                System.out.print("enter: ");
                String name = in.next();
                team[i] = name;
            }
        }
        Project project = new Project(t,y,to,p,team);
        listOfProjects.add(project);
        listOfItems.add(project);
        System.out.println(project.title + " is registered successfully !");
    }

    void RegisterMember(){
        in.reset();
        System.out.println("**************Registration**************");
        System.out.println("To register please enter your name: ");
        String name = in.next();

        Member member = new Member(name);
        listOfMembers.add(member);
        System.out.println(member.getName() + " is registered successfully !");
        System.out.println("Your registration number is: " + member.getRegistrationNumber());
        System.out.println("You can now borrow three items at a time");
        member.setSignedIn();
        setMid(member.getRegistrationNumber());
    }

    void SignIn() {
        PenaliseMembers();
        System.out.println("enter your name: ");
        String name = in.next();
        System.out.println("enter your id: ");
        int mId = in.nextInt();
        Member currantUser = new Member(mId,name);
        for(Member pMember : listOfPenalisedMembers){
            if(pMember.equals(currantUser)){
                System.out.println("you have violated our terms and conditions!!");
                System.out.println("you have been have been removed from the library and all the books you've borrowed will be returned");
                pMember.removeAll();
                setMid(0);
            }
        }
        for (Member member : listOfMembers) {
            if (member.equals(currantUser)) {
                System.out.println("Hello Mr." + currantUser.getName().toUpperCase());
                member.setSignedIn();
                currantUser.setSignedIn();
                setMid(mId);
            }
        }
        if (!currantUser.isSignedIn()) {
            System.out.println("wrong sign in information, please register if you aren't a member <3 ");

        }

    }

    //we will force the member to signIn/register when they want to borrow so this method should be changed
    void ItemLend() {
        if(mId == 0){
        System.out.println("you have to sign up or log in first:");
        System.out.println("1.sign up (you don't have an account)   2.log in (you already have an account");
        int v = in.nextInt();
        if(v == 2){
            RegisterMember();
             mId = getMid();
             if(mId == 0) return;
        }
        else if (v == 1) {
             SignIn();
             mId = getMid();
        }
        else
            System.out.println("! wrong input");
        return;
        }
        LocalDate now = LocalDate.now();

        for(Member member : listOfMembers){
            if (member.getRegistrationNumber() == mId) {
                if (MemberIsAbleToBorrow(member)) {
                System.out.println("\nHere are all the available items: ");
                ShowAllAvailableItems();
                System.out.println("\nEnter the ID of the item you want to borrow : ");
                int enteredId = in.nextInt();
                System.out.println("Here you go!");

                for (Item item : listOfItems) {
                    if (item.getId() == enteredId && item.IsAvailable()) {
                        item.borrow();
                        member.BorrowItem(item);
                        System.out.println(item.title + " " + "is Borrowed in " + now + " by " + member.getName() + " !");
                        System.out.println("!Note : The borrowing time allowed is only 7 days ");
                    }
                    else
                        System.out.println("You entered a wrong Id "+ "\n Or the item you are trying to borrow is not available");
                    }
                }
                else {
                    System.out.println("!! Sorry , You can't borrow more than three items." + "\n" +
                                "You have to return an item first.");
                    }
                }
        }
    }

    //check if the member has the book in the first place, or he could return a book he doesn't have.
    void ItemReturn( ) {
        LocalDate now = LocalDate.now();
        if(mId == 0)
            System.out.println("Please log in first <3");


        for (Member member : listOfMembers) {
            if(mId == member.getRegistrationNumber()){
                for(Item item : member.BorrowedItems){
                    item.getInfo();
                }
                System.out.println("Enter the id of the item you want to return: ");
                int enteredId = in.nextInt();
                for(Item item : member.BorrowedItems){
                    if(item.getId() == enteredId){
                        member.ReturnItem(item);
                        item.Return();
                        System.out.println(item.title + " is returned successfully in " + now + " by " + member.getName() + " !");
                        break;

                    }
                    else
                        System.out.println("You entered wrong Id "+ "\n Or the item you are trying to return is not borrowed by this member ");
                }break;
            }
        }
    }

    void SearchForAnItem() {
        int optionNumber = showItemOptions();
        switch (optionNumber) {
            //every book
            case 1: {
                for (Book book : listOfBooks) {
                    book.getInfo();
                }
                break;
            }
            //every project selected by year
            case 2: {
                System.out.println("Select the year of the projects you want to view: ");
                int year = in.nextInt();
                for (Project project : listOfProjects) {
                    if (project.projectYear == year) {
                        project.getInfo();
                    }
                }
                break;
            }
            //every item selected by topics
            case 3: {
                System.out.println("Select the the topic of the items you want to view : ");
                System.out.println("1.basic science  2.AI  3.software development  4.networks");
                int c = in.nextInt();
                SearchForItemsByTopics(c);
                break;
            }
            //every available project by topic
            case 4: {
                System.out.println("Select the the topic of the available projects you want to view : ");
                System.out.println("1.basic science  2.AI  3.software development  4.networks");
                int c = in.nextInt();
                SearchForProjectsByTopic(c);
                break;
            }
            //every unavailable book / every lent book
            case 5:{
                for(Book book :listOfBooks){
                    if(!book.IsAvailable()){
                        book.getInfo();
                    }
                }
                break;
            }
            //search for a certain book or project by id or title or topic
            case 6:{
                System.out.println("select preferred method of search:");
                System.out.println("1.id  2.title 3.topic");
                int c = in.nextInt();
                switch (c){
                    case 1: {
                        System.out.println("enter the id:");
                        int n = in.nextInt();
                        listOfItems.forEach(m -> {
                            if(m.id == n )
                                m.getInfo();
                        });
                        break;
                    }
                    case 2: {
                        System.out.println("Enter the title:");
                        in.nextLine();

                        String s = in.nextLine();
                        for(Item item : listOfItems) {
                            if(s.equalsIgnoreCase(item.title)) {
                                item.getInfo();
                            }
                        }
                        in.reset();
                        break;
                    }
                    case 3: {
                        System.out.println("Select the the topic of the items you want to view : ");
                        System.out.println("1.basic science  2.AI  3.software development  4.networks");
                        int choice = in.nextInt();
                        SearchForItemsByTopics(choice);
                        break;
                    }
                    default:
                        System.out.println("wrong input");
                        break;
                }
                break;
            }
            // Show every item
            case 7 :{
                this.ShowAllItems();
                break;
            }
            default:
                System.out.println("wrong input");
                break;

        }
    }

    void SearchForCertainMembers() {
        int optionNumber = showMemberOptions();
        switch (optionNumber) {
            //every member and their borrowed items.
            case 1: {
                for (Member member : listOfMembers) {
                    System.out.println("Member: " + member.getName() + " has borrowed the following titles: ");
                    for (Item borrowedItem : member.BorrowedItems) {
                        System.out.println(borrowedItem.title);
                        break;
                    }
                }
            }
            case 2: {
                for(Member member : listOfMembers){
                    member.BorrowedItems.forEach(item -> {
                        if (item.topic.equalsIgnoreCase("ai") || item.topic.equalsIgnoreCase("artificial intelligence"))
                            System.out.println(member.getName() + " Has an Ai Book");

                    });
                }
                break;
            }

        //Show All Penalised Members
            case 3: {
                PenaliseMembers();
                System.out.println("The penalised members are : ");
                for(Member member : listOfPenalisedMembers){
                    System.out.println(member.getName());
                }
              break;

            }
            case 4 :{
                System.out.println("Please Enter The Start Date :");
               int x=  in.nextInt();
               int x2=  in.nextInt();
               int x3=  in.nextInt();

                System.out.println("Please Enter End Date :");
                int y=  in.nextInt();
                int y2=  in.nextInt();
                int y3=  in.nextInt();

               Date date1 = new Date(x,x2,x3);
               Date date2 = new Date(y,y2,y3);
               listOfBooks.forEach(Book::getInfo);

                System.out.println("Enter the ID of the item you want to search for ");
                int bookId = in.nextInt();
                for(Book book : listOfBooks){
                if(book.getId() == bookId){
                    for (Member member :listOfMembers ){
                        if(member.BorrowedItemsHistory.isEmpty()){
                            System.out.println(member.getName() + " hasn't borrowed any item");
                            continue;
                        }
                        for (Date date : member.DatesOfBorrows) {
                            if (date.isBetween(date1, date2)) {
                                System.out.println(member.getName() + " has borrowed " + book.title + " in entered duration ");
                            }
                        }

                    }
                    }
                }
                break;
            }
            case 5 : {
                showMembersWithBorrowedBooksAndDate();
                break;
            }
            default:
                System.out.println("wrong input");
                break;

        }
        }

    void showMembersWithBorrowedBooksAndDate() {
            listOfBooks.forEach(Book::getInfo);

            System.out.println("Enter the ID of the item you want to search for : ");
            int bookId = in.nextInt();
            for (Item item : listOfItems) {
                if(item instanceof Book){
                if (item.getId() == bookId) {
                    for (Member member : listOfMembers) {
                        if (member.BorrowedItemsHistory.isEmpty() || !member.BorrowedItemsHistory.contains(item)) {
                            System.out.println(member.getName() + " hasn't borrowed "+item.title);
                            continue;
                        }
                        if(member.DatesOfReturns.size()==member.BorrowedItemsHistory.size()) {

                            System.out.println(member.getName() + " has borrowed " + item.title + " in " + member.DatesOfBorrows.get(member.BorrowedItemsHistory.indexOf(item)).print() + " to " + member.DatesOfReturns.get(member.BorrowedItemsHistory.indexOf(item)).print());
                        }
                        else
                            System.out.println(member.getName() + " has borrowed " + item.title + " in " + member.DatesOfBorrows.get(member.BorrowedItemsHistory.indexOf(item)).print() +" till now "  );


                    }
                }
            }
            }
        }

    //7 day check and penalise if returned too late
    boolean ReturnedLate(Date borrowDate) {
        LocalDate currantDate = LocalDate.now();
        Date now = new Date(currantDate.getDayOfMonth(),currantDate.getDayOfMonth(),currantDate.getYear());
        return Date.TimeElapsedBetweenTwoDates(borrowDate, now) > 7;
    }
    //3 items borrowed limiter
    boolean MemberIsAbleToBorrow(Member member) {
        return member.getNumberOfBorrowedItems() < 3 && member.isSignedIn()&& !listOfPenalisedMembers.contains((member));
    }
    //put members who are late in the penalised list
    private void PenaliseMembers(){
        for(int i = 0 ; i < listOfMembers.size() ; i++){
            for(Date borrowDate : listOfMembers.get(i).DateOfBorrowing){
                if(ReturnedLate(borrowDate)){
                    listOfPenalisedMembers.add(listOfMembers.get(i));
                    listOfMembers.remove(i);
                    break;
                }
            }
        }
    }
    private int showItemOptions(){
        System.out.println("1.Every book");
        System.out.println("2.Every project selected by year");
        System.out.println("3.Every item selected by topics");
        System.out.println("4.Every available project by topic");
        System.out.println("5.Every unavailable book / every lent book");
        System.out.println("6.Search for a certain book or project by id or title or topic");
        System.out.println("7.Show every item");
        int choice = in.nextInt();
        if (choice > 0 && choice < 8)
            return choice;
        else return 0;
    }
    private int showMemberOptions() {
        System.out.println("1.Every member and their borrowed items.");
        System.out.println("2.Show members that borrowed Ai items. ");
        System.out.println("3.Show All Penalised Members. ");
        System.out.println("4.Show all borrowed items in selected duration. ");
        System.out.println("5.Show Members With Borrowed Books And Date. ");

        int choice = in.nextInt();
        if (choice > 0 && choice < 8)
            return choice;
        else return 0;
    }
    void ShowAllItems(){
        listOfItems.forEach(Item::getInfo);
    }
    void ShowAllAvailableItems(){
        listOfItems.forEach(b ->{if(b.IsAvailable())b.getInfo();});
    }
    void SearchForProjectsByTopic(int c){

        switch (c) {
            case 1: {
                for (Project project : listOfProjects) {
                    if (project.id >= 2100 && project.id < 2300 && project.IsAvailable()) {
                        project.getInfo();
                    }
                }
                break;
            }
            case 2: {
                for (Project project : listOfProjects) {
                    if (project.id >= 2300 && project.id < 2500 && project.IsAvailable()) {
                        project.getInfo();
                    }
                }
                break;
            }
            case 3: {
                for (Project project : listOfProjects) {
                    if (project.id >= 2500 && project.id < 2700 && project.IsAvailable()) {
                        project.getInfo();
                    }
                }
                break;
            }
            case 4: {
                for (Project project : listOfProjects) {
                    if (project.id >= 2700 && project.id < 2900 && project.IsAvailable()) {
                        project.getInfo();
                    }
                }
                break;
            }
            case 5: {
                for (Project project : listOfProjects) {
                    if (project.id >= 2900 && project.IsAvailable()) {
                        project.getInfo();
                    }
                }
                break;
            }
            default:
                System.out.println("wrong input");
        }


    }
    void SearchForItemsByTopics(int c){
        {switch (c) {
            case 1: {
                for (Item item : listOfItems) {
                    if (item.id >= 1100 && item.id < 1300 || item.id >= 2100 && item.id < 2300 )  {
                        item.getInfo();
                    }
                }break;
            }
            case 2: {
                for (Item item : listOfItems) {
                    if (item.id >= 1300 && item.id < 1500 || item.id >= 2300 && item.id < 2500 )  {
                        item.getInfo();
                    }
                } break;
            }
            case 3: {
                for (Item item : listOfItems) {
                    if (item.id >= 1500 && item.id < 1700 || item.id >= 2500 && item.id < 2700 )  {
                        item.getInfo();
                    }
                } break;
            }
            case 4: {
                for (Item item : listOfItems) {
                    if (item.id >= 1700 && item.id < 1900 || item.id >= 2700 && item.id < 2900 )  {
                        item.getInfo();
                    }
                } break;
            }
            case 5: {
                for (Item item : listOfItems) {
                    if (item.id >= 1900 && item.id < 2000 || item.id >= 2900)  {
                        item.getInfo();
                    }
                }break;
            }
        }
        }
    }

    void setMid(int mId){
        this.mId = mId;
    }
    int getMid(){
        return mId;
    }
    void logout(){mId = 0;
        System.out.println("You have been logged out.");}
}



