import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicBoolean;

public class Library {
    ArrayList<Item> listOfItems = new ArrayList<>();
    ArrayList<Project> listOfProjects = new ArrayList<>();
    ArrayList<Book> listOfBooks = new ArrayList<>();
    ArrayList<Member> listOfMembers = new ArrayList<>();
    ArrayList<Member> listOfPenalisedMembers = new ArrayList<>();
    Scanner in = new Scanner(System.in);
    int mId ;

    public Library() {
    }

    public Library(ArrayList<Item> listOfItems, ArrayList<Member> list0fMembers) {
        this.listOfItems = listOfItems;
        this.listOfMembers = list0fMembers;
    }

    void RegisterItem(Item item) {
        System.out.println("What type of item do you want to register ? \n 1.for Book \n 2.for Project");
        int n =in.nextInt();

        if(n==1) {

//            Book book = new Book();
//            if (listOfBooks.contains(book)) {
//                System.out.println("! We already have the " + book.title + " in our library ");
//            } else {
//                listOfBooks.add(book);
//                System.out.println(book.title + " is registered successfully !");
            RegisterBook((Book)item);

            }

        else if(n==2){
              RegisterProject((Project)item);
//            Project project = new Project();
//            if (listOfProjects.contains(project)) {
//                System.out.println("! We already have the " + project.title + " in our library ");
//            } else {
//                listOfProjects.add(project);
//                System.out.println(project.title + " is registered successfully !");
//            }

            }
        else
            System.out.println("Wrong Number ");
        }


     void RegisterBook(Book item) {
        if (listOfBooks.contains(item)) {
            System.out.println("! We already have the " + item.title + " in our library ");
        } else {
            listOfBooks.add(item);
            listOfItems.add(item);
            System.out.println(item.title + " is registered successfully !");
        }
     }

    void RegisterProject(Project item) {
        if (listOfProjects.contains(item)) {
            System.out.println("! We already have the " + item.title + " in our library ");
        } else {
            listOfProjects.add(item);
            listOfItems.add(item);
            System.out.println(item.title + " is registered successfully !");
        }
    }

    int RegisterMember(){
        System.out.println("**************Registration**************");
        System.out.println("To register please enter your name: ");
        String name = in.next();

        Member member = new Member(name);
        listOfMembers.add(member);
        System.out.println(member.name + " is registered successfully !");
        System.out.println("Your registration number is: " + member.registrationNumber);
        System.out.println("You can now borrow three items at a time");
        member.setSignedIn(true);
        return member.getRegistrationNumber();
    }

    int SignIn() {
        System.out.println("enter your name: ");
        String name = in.next();
        System.out.println("enter your id: ");
        int mId = in.nextInt();
        Member currantUser = new Member(mId,name);
        for (Member member : listOfMembers) {
            if (member.equals(currantUser)) {
                System.out.println("Hello Mr." + currantUser.name.toUpperCase());
                member.setSignedIn(true);
                currantUser.setSignedIn(true);
                return mId;
            }
        }
        if (!currantUser.isSignedIn()) {
            System.out.println("wrong sign in information, please register if you aren't a member <3 ");

        }
        return 0 ;
    }


    //we will force the member to signIn/register when they want to borrow so this method should be changed
    void ItemLend() {
        if(mId == 0){
        System.out.println("you have to sign up or log in first:");
        System.out.println("1.sign up (you don't have an account)   2.log in (you already have an account");
        int v = in.nextInt();
        if(v == 2){
             mId = SignIn();
             if(mId == 0) return;
        }
        else if (v == 1) {
             mId = RegisterMember();
        }
        else
            System.out.println("! wrong input");
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
                    //boolean f = false;
                    for (Item item : listOfItems) {
                        if (item.getId() == enteredId) {
                            //f = true;
                            //if (item.IsAvailable()) {
                                item.borrow();
                                member.BorrowItem(item);
                                System.out.println(item.title + " " + "is Borrowed in " + now.toString() + " by " + member.name + " !");
                                System.out.println("!Note : The borrowing time allowed is only 7 days ");
                            /*    }
                            else
                                System.out.println("!! Sorry This Book Is Unavailable" + "\n" + " Please Choose Another Book");
                            break;*/
                        }
                    }
                    /*if (!f) {
                        System.out.println("!! Wrong Id input");
                        }*/
                }
                else {
                    System.out.println("!! Sorry , You can't borrow more than three items." + "\n" +
                                "You have to return an item first.");
                    }
                }
        }
    }


    //check if the member has the book in the first place, or he could return a book he doesn't have.
    void ItemReturned( ) {
        LocalDate now = LocalDate.now();
        if(mId == 0)
            mId = SignIn();
        ReturningBlock:
        {
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
                            System.out.println(item.title + " is returned successfully in " + now.toString() + " by " + member.name + " !");
                        break;
                        }
                    }
                break;
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

    void SearchForCertainMembers(int optionNumber) {
        switch (optionNumber) {
            //every member and their borrowed items.
            case 2: {
                for (Member member : listOfMembers) {
                    System.out.println("Member: " + member.name + " has borrowed the following titles: ");
                    for (Item borrowedItem : member.BorrowedItems) {
                        System.out.println(borrowedItem.title);
                        break;
                    }
                }
            }
            case 3: {
                listOfMembers.forEach(member -> {
                    member.BorrowedItems.forEach(item -> {
                        if( item.topic.equalsIgnoreCase("ai") || item.topic.equalsIgnoreCase("artificial intelligence"))
                            System.out.println(member.getName() + " Has an Ai Book");

                    });
                });

            }
            break;
        }

    }
    void ShowAllItems(){
        listOfItems.forEach(Item::getInfo);
    }
    void ShowAllAvailableItems(){
        listOfItems.forEach(b ->{if(b.IsAvailable())b.getInfo();});
    }


    void SearchForAnItem(int optionNumber) {
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
                        System.out.println("enter the title:");
                        String s = in.next();
                        listOfItems.forEach(item -> {if(item.title.equalsIgnoreCase(s)) item.getInfo();});
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
            }
            default:
                System.out.println("wrong input");
                break;

        }
    }

    void SearchForProjectsByTopic(int c){
        {
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
                        if (project.id >= 2900 && project.IsAvailable()) {
                            project.getInfo();
                        }
                    }
                    break;
                }
            }

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
                        if (item.id >= 1900 && item.id < 2000 || item.id >= 2900)  {
                            item.getInfo();
                        }
                    }break;
                }
            }
        }
    }
    void PenaliseMembers(){
        for(Member member : listOfMembers){
            for(Date borrowDate : member.DateOfBorrowing){
                if(ReturnedLate(borrowDate)){
                    listOfPenalisedMembers.add(member);
                    listOfMembers.remove(member);
                    break;
                }
            }
        }
    }
}


