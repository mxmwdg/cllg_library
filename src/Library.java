import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Library {
    ArrayList<Item> listOfItems = new ArrayList<>();
    ArrayList<Project> listOfProjects = new ArrayList<>();
    ArrayList<Book> listOfBooks = new ArrayList<>();
    ArrayList<Member> listOfMembers = new ArrayList<>();
    ArrayList<Member> listOfPenalisedMembers = new ArrayList<>();
    Scanner in = new Scanner(System.in);

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
            System.out.println(item.title + " is registered successfully !");
        }
     }

    void RegisterProject(Project item) {
        if (listOfProjects.contains(item)) {
            System.out.println("! We already have the " + item.title + " in our library ");
        } else {
            listOfProjects.add(item);
            System.out.println(item.title + " is registered successfully !");
        }
    }

    /*void RegisterMember(){
        System.out.println("please enter your name: ");
        String name = in.next();

        Member member = new Member(name);

        if (listOfMembers.contains(member)){
            System.out.println("! Mr ." + member.name + " is already registered in our system ");
        }
        else{
            listOfMembers.add(member);
        System.out.println(member.name + " is registered successfully !");
        System.out.println("Your registration number is: " + member.registrationNumber);
        member.setSignedIn(true);
        }
    }*/

    void RegisterMember(Member member) {
        if (listOfMembers.contains(member)) {
            System.out.println("! Mr ." + member.name + " is already registered in our system ");
        } else {
            listOfMembers.add(member);
            System.out.println(member.name + " is registered successfully !");
            System.out.println("Your registration number is: " + member.registrationNumber);
            member.setSignedIn(true);
        }
    }

    void SignIn(Member currantUser) {
        for (Member member : listOfMembers) {
            if (member.equals(currantUser)) {
                System.out.println("Hello Mr." + currantUser.name.toUpperCase());
                member.setSignedIn(true);
                currantUser.setSignedIn(true);
            }
        }
        if (!currantUser.isSignedIn()) {
            System.out.println("wrong sign in information, please register if you aren't a member <3 ");
        }
    }


    //we will force the member to signIn/register when they want to borrow so this method should be changed
    void ItemLend(Member member, Item item, Date dateOfBorrowing) {
        BorrowingBlock:
        {
            if (!listOfBooks.contains(item) || !listOfProjects.contains(item) && member.isSignedIn()) {
                System.out.println("!! Sorry something went wrong ");
            }
            /* ************listOfMembers.get(memberInt).isSignedIn()****************** */

            if (!member.isSignedIn()) {
                System.out.println("! Mr. " + member.name + " is not registered in our system ");
            }

            if (!listOfBooks.contains(item) && !listOfProjects.contains(item)) {
                System.out.println("! The " + item.title + " is not registered in our system ");
            }
        if ((!listOfBooks.contains(item) && !listOfProjects.contains(item)) || !listOfMembers.contains(member) ) {
                break BorrowingBlock;
            }

            MainIf:
            if (MemberIsAbleToBorrow(member)) {
                System.out.println("Here you go!");
                if (!item.IsAvailable()) {
                    System.out.println("!! Sorry This Book Is Unavailable" + "\n" + " Please Choose Another Book");
                    break MainIf;
                } else {
                    item.borrow();
                    System.out.println(item.title + " " + "is Borrowed in " + dateOfBorrowing.day + '/' + dateOfBorrowing.month + '/' + dateOfBorrowing.year + " by " + member.name + " !");
                    System.out.println("!Note : The borrowing time allowed is only 7 days ");
                    member.BorrowItem(item, dateOfBorrowing);
                }
                //Date date = new Date(day,month,year);
            } else
                System.out.println("!! Sorry , You can't borrow more than three items." + "\n" +
                        "You have to return an item first.");


        }
    }

    //check if the member has the book in the first place, or he could return a book he doesn't have.
    void ItemReturned(Member member, Item item, Date dateOfReturning) {
        ReturningBlock:
        {
            if (item.IsAvailable()) {
                System.out.println("! " + item.title + " is already in the library");
                break ReturningBlock;
            }
            if (member.BorrowedItems.contains(item)) {
                System.out.println("! " + item.title + " is not in your possession");
                break ReturningBlock;
            }

            member.ReturnItem(item, dateOfReturning);
            item.setAvailable();
            System.out.println(item.title + " is returned successfully in " + dateOfReturning.day + '/' + dateOfReturning.month + '/' + dateOfReturning.year + " by " + member.name + " !");
            member.ReturnItem(item, dateOfReturning);
        }
    }

    //7 day check and penalise if returned too late
    boolean ReturnedLate() {
        LocalDate currantDate = LocalDate.now();
        //if(Date.TimeElapsedBetweenTwoDates() > 7)
        return false;
    }

    /*void showAllBooks(){
        System.out.println("Here is all the Books we have in the library :");
        listOfItems.forEach((book) -> { System.out.printf(book.title +" ");});
        System.out.println("\n");
    }

    void showAllMembersWithTheirBorrowedItems(){
        listOfMembers.forEach(m -> {
            System.out.println("Member: " +m.name +"\n"+"Borrowed Items :");
            m.BorrowedItems.forEach(item -> {
                System.out.printf("\t"+item.title + " ");
            });
            System.out.println("\n");
        });

    }*/


    //3 items borrowed limiter
    boolean MemberIsAbleToBorrow(Member member) {
        return member.getNumberOfBorrowedItems() < 3;
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


            }

        }
    }

    void SearchForAnItem(int optionNumber) {
        switch (optionNumber) {
            //every book
            case 1: {
                for (Book book : listOfBooks) {
                    book.getInfo();
                }
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
            }
            //every item selected by topics
            case 3: {
                System.out.println("Select the the topic of the items you want to view : ");
                System.out.println("1.basic science  2.AI  3.software development  4.networks");
                int c = in.nextInt();
                SearchForItemsByTopics(c);
            }
            //every available project by topic
            case 4: {
                System.out.println("Select the the topic of the available projects you want to view : ");
                System.out.println("1.basic science  2.AI  3.software development  4.networks");
                int c = in.nextInt();
                SearchForProjectsByTopic(c);
            }
            //every unavailable book
            case 5:{
                for(Book book :listOfBooks){
                    if(!book.IsAvailable()){
                        book.getInfo();
                    }
                }
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
                        listOfProjects.forEach(m -> {
                            if(m.IdOfProject == n )
                                m.getInfo();
                        });
                        listOfBooks.forEach(b -> {
                            if(b.IdOfBook == n )
                                b.getInfo();
                        });
                    }
                    case 2: {
                        System.out.println("enter the title:");
                        String s = in.next();
                        listOfItems.forEach(item -> {if(item.title.equalsIgnoreCase(s)) item.getInfo();});
                    }
                    case 3: {
                        System.out.println("Select the the topic of the items you want to view : ");
                        System.out.println("1.basic science  2.AI  3.software development  4.networks");
                        int choice = in.nextInt();
                        SearchForItemsByTopics(choice);
                    }
                    default:
                        System.out.println("wrong input");
                }
            }
            default:
                System.out.println("wrong input");
        }
    }

    void SearchForProjectsByTopic(int c){
        {
            switch (c) {
                case 1: {
                    for (Project project : listOfProjects) {
                        if (project.IdOfProject >= 2100 && project.IdOfProject < 2300 && project.IsAvailable()) {
                            project.getInfo();
                        }
                    }
                }
                case 2: {
                    for (Project project : listOfProjects) {
                        if (project.IdOfProject >= 2300 && project.IdOfProject < 2500 && project.IsAvailable()) {
                            project.getInfo();
                        }
                    }
                }
                case 3: {
                    for (Project project : listOfProjects) {
                        if (project.IdOfProject >= 2500 && project.IdOfProject < 2700 && project.IsAvailable()) {
                            project.getInfo();
                        }
                    }
                }
                case 4: {
                    for (Project project : listOfProjects) {
                        if (project.IdOfProject >= 2900 && project.IsAvailable()) {
                            project.getInfo();
                        }
                    }
                }
            }

        }
    }
    void SearchForItemsByTopics(int c){
        {switch (c) {
                case 1: {
                    for (Book book : listOfBooks) {
                        if (book.IdOfBook >= 1100 && book.IdOfBook < 1300) {
                            book.getInfo();
                        }
                    }
                    for (Project project : listOfProjects) {
                        if (project.IdOfProject >= 2100 && project.IdOfProject < 2300) {
                            project.getInfo();
                        }
                    }
                }
                case 2: {
                    for (Book book : listOfBooks) {
                        if (book.IdOfBook >= 1300 && book.IdOfBook < 1500) {
                            book.getInfo();
                        }
                    }
                    for (Project project : listOfProjects) {
                        if (project.IdOfProject >= 2300 && project.IdOfProject < 2500) {
                            project.getInfo();
                        }
                    }
                }
                case 3: {
                    for (Book book : listOfBooks) {
                        if (book.IdOfBook >= 1500 && book.IdOfBook < 1700) {
                            book.getInfo();
                        }
                    }
                    for (Project project : listOfProjects) {
                        if (project.IdOfProject >= 2500 && project.IdOfProject < 2700) {
                            project.getInfo();
                        }
                    }
                }
                case 4: {
                    for (Book book : listOfBooks) {
                        if (book.IdOfBook >= 1900 && book.IdOfBook < 2000) {
                            book.getInfo();
                        }
                    }
                    for (Project project : listOfProjects) {
                        if (project.IdOfProject >= 2900) {
                            project.getInfo();
                        }
                    }
                }
            }
        }
    }

}


