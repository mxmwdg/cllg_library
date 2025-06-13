
import java.util.ArrayList;


public class Library {
    ArrayList<Item> listOfItems = new ArrayList<>();
    ArrayList<Member> listOfMembers = new ArrayList<>();

    public Library() {
    }

    public Library(ArrayList<Item> listOfItems , ArrayList<Member> list0fMembers ){
        this.listOfItems = listOfItems;
        this.listOfMembers=list0fMembers;
    }

    void RegisterItem(Item item ) {
            listOfItems.add(item);
    }

    void RegisterMember(Member member){
        listOfMembers.add(member);
    }


    void ItemGotBorrowed(Item item ){
        boolean Av = item.IsAvailable();
        if (!Av)
            System.out.println("Sorry This Book Is Unavailable");
        else {
            item.available = false;
            System.out.println(item.title + " " + "is Borrowed ");
            System.out.println("Please Enter The Date ");
        }
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
