import javax.tools.JavaCompiler;
import java.util.ArrayList;
import java.util.Date;

public class Library {
    ArrayList<Item> listOfItems = new ArrayList<>();
    ArrayList<Member> listOfMembers = new ArrayList<>();
    public Library() {
    }

    public Library(ArrayList<Item> listOfItems , ArrayList<Member> list0fmembers ){
        this.listOfItems = listOfItems;
        this.listOfMembers=list0fmembers;
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

    void RegisterMember(Member member){
        if (listOfMembers.contains(member)){
            System.out.println("! Mr ." + member.name + " is already registered in our system ");
        }
        else{
            listOfMembers.add(member);
        System.out.println(member.name + " is registered successfully !");
        }
    }


    void ItemGotBorrowed(Member member,Item item , Date dateOfBorrowing) {
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
            if (member.BorrowedItems.size() < 3) {
                System.out.println("Here you go!");
                if (!item.IsAvailable()) {
                    System.out.println("!! Sorry This Book Is Unavailable" + "\n" + " Please Choose Another Book");
                    break MainIf;
                } else {
                    item.setAvailable(false);
                    System.out.println(item.title + " " + "is Borrowed in " + dateOfBorrowing.day + '/' + dateOfBorrowing.month + '/' + dateOfBorrowing.year + " by " + member.name  + " !");
                }
                member.BorrowItem(item, dateOfBorrowing);
                //member.BorrowedItems.add(item);
                //Date date = new Date(day,month,year);
            } else
                System.out.println("!! Sorry , You can't borrow more than three items." + "\n" +
                        "You have to return an item first.");


        }
    }
    void ItemGotReturned(Member member ,Item item , Date dateOfReturning ){
        ReturningBlock:{  if(item.IsAvailable()){
            System.out.println("! The "+ item.title + " is already in the library");
            break ReturningBlock;
        }
        member.ReturnItem(item ,dateOfReturning);
        item.setAvailable(true);
        System.out.println(item.title + " is returned successfully in "+ dateOfReturning.day + '/' + dateOfReturning.month + '/' + dateOfReturning.year + " by "+ member.name + " !");
    }
    }

    //7 day check and penalise if returned too late
    boolean ReturnedLate(){
//     if(Date.TimeElapsedBetweenTwoDates())
        return false;
    }

    //3 items borrowed limiter
    void CheckAbilityToBorrow(){

    }

    void SearchForAnItem(int optionNumber){}

    void SearchForCertainMembers(int optionNumber){
        //imo we make the main class describe the search method, and we ask for user input to decide what to do.
    }



}
