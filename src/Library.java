import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    ArrayList<Item> listOfItems = new ArrayList<>();
    ArrayList<Member> listOfMembers = new ArrayList<>();


    Scanner in = new Scanner(System.in);
    public Library() {
    }

    public Library(ArrayList<Item> listOfItems , ArrayList<Member> list0fMembers ){
        this.listOfItems = listOfItems;
        this.listOfMembers=list0fMembers;
    }

    void RegisterItem(Item item ) {
        if (listOfItems.contains(item)){
            System.out.println("! We already have the " + item.title + " in our library ");
        }
        else {
            listOfItems.add(item);
            System.out.println(item.title + " is registered successfully !");
        }
    }

    void RegisterMember(){
        System.out.println("Please enter your name : ");
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
    }
    void RegisterMember(Member member){
    if (listOfMembers.contains(member)){
        System.out.println("! Mr ." + member.name + " is already registered in our system ");
    }
        else{
        listOfMembers.add(member);
        System.out.println(member.name + " is registered successfully !");
        System.out.println("Your registration number is: " + member.registrationNumber);
        member.setSignedIn(true);
    }
}
    void SignIn(){

        System.out.println("Please enter your name: ");
        String name = in.next();
        System.out.println("Please enter your FUCKING registration number: ");
        int registrationNumber = in.nextInt();
        Member tempMember = new Member(registrationNumber,name.toLowerCase());
        for(Member member: listOfMembers) {
            if (member.equals(tempMember)) {
                System.out.println("Hello Mr." + tempMember.name.toUpperCase());
                member.setSignedIn(true);
                tempMember.setSignedIn(true);
            }
        }
        if(!tempMember.isSignedIn()){
            System.out.println("Wrong sign in information, Please register if you aren't a member <3 ");
        }
    }


    void ItemLend(Member member,Item item , Date dateOfBorrowing) {
        BorrowingBlock:{
            if(!listOfItems.contains(item) && !listOfMembers.contains(member)){
                System.out.println("!! Sorry something went wrong " );
            }
            if (!listOfMembers.contains(member)) {
                System.out.println( "! Mr. " + member.name + " is not registered in our system ");
            }
            if(!listOfItems.contains(item)){
                System.out.println( "! The " + item.title + " is not registered in our system ");
            }
            if(!listOfItems.contains(item) || !listOfMembers.contains(member)){
                break BorrowingBlock;
            }

            MainIf:
            if (MemberIsAbleToBorrow(member)) {
                System.out.println("Here you go!");
                if (!item.IsAvailable()) {
                    System.out.println("!! Sorry This Book Is Unavailable" + "\n" + " Please Choose Another Book");
                    break MainIf;
                } else {
                    item.Return();
                    System.out.println(item.title + " " + "is Borrowed in " + dateOfBorrowing.day + '/' + dateOfBorrowing.month + '/' + dateOfBorrowing.year + " by " + member.name  + " !");
                }
                member.BorrowItem(item, dateOfBorrowing);
                item.setAvailable(false);

                //member.BorrowedItems.add(item);
                //Date date = new Date(day,month,year);

            } else
                System.out.println("!! Sorry , You can't borrow more than three items." + "\n" +
                        "You have to return an item first.");


        }
    }
    //check if the member has the book in the first place, or he could return a book he doesn't have.
    void ItemReturned(Member member ,Item item , Date dateOfReturning  ){
        ReturningBlock:{  if(item.IsAvailable()){
            System.out.println("! The "+ item.title + " is already in the library");
            break ReturningBlock;
        }

        member.ReturnItem(item,dateOfReturning);
        item.setAvailable();
        System.out.println(item.title + " is returned successfully in "+ dateOfReturning.day + '/' + dateOfReturning.month + '/' + dateOfReturning.year + " by "+ member.name + " !");
        /// ///NOT DONE YETTT
        member.DateOfBorrowing.trimToSize();
        member.DateOfReturning.trimToSize();
        if(ReturnedLate(member.DateOfBorrowing.get(member.DateOfBorrowing.size()-1),member.DateOfReturning.get(member.DateOfReturning.size()-1) )){
            System.out.println(item.title +" MEOOOWWWWWW");
        }

    }
    }

    //7 day check and penalise if returned too late
    boolean ReturnedLate(Date DateOfBorrowing , Date DateOfReturning) {
        if (Date.TimeElapsedBetweenTwoDates(DateOfBorrowing, DateOfReturning) > 7) {
            return true;
         }
        else {
            return false;
        }
    }

    //3 items borrowed limiter
    boolean MemberIsAbleToBorrow(Member member){
        return member.getNumberOfBorrowedItems() < 3;
    }

    void SearchForAnItem(int optionNumber){}

    void SearchForCertainMembers(int optionNumber){
        //imo we make the main class describe the search method, and we ask for user input to decide what to do.
    }

int justsotheycanletmepush(){
        return 0;
    }

}
