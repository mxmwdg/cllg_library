
import java.util.ArrayList;


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
            listOfItems.add(item);
    }

    void RegisterMember(Member member){
        listOfMembers.add(member);
    }


    void ItemGotBorrowed(Member member,Item item , Date date){
      MainIf:if(member.BorrowedItems.size()<3) {
          System.out.println("Here you go!");
          boolean Av = item.IsAvaialble();
           if (!Av){
              System.out.println("Sorry This Book Is Unavailable"+ "\n" +" Please Choose Another Book");
              break MainIf;
           }
           else {
               item.available = false;
               System.out.println(item.title + " " + "is Borrowed in " + date.day + '/' + date.month + '/' + date.year + " by "+ member.name);
           }
             member.BorrowItem(item , date);
             //member.BorrowedItems.add(item);
            //Date date = new Date(day,month,year);
        }
        else
            System.out.println("Sorry , You can't borrow more than three items." + "\n" +
                    "You have to return an item first.");



        }

    void ItemGotReturned(){

    }

    //7 day check and penalise if returned too late
    boolean ReturnedLate(){
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
