import java.util.ArrayList;
public class Library {
    ArrayList<Item> listOfItems = new ArrayList<>();
    ArrayList<Member> listOfMembers = new ArrayList<>();

    public Library() {
    }

    public Library(ArrayList<Item> listOfItems , ArrayList<Member> listofmembers ){
        this.listOfItems = listOfItems;
        this.listOfMembers=listofmembers;
    }

    void RegisterItem(Item item ) {
        boolean Av = item.IsAvaialble();
        if (!Av)
            System.out.println("Sorry This Book Is Unavailable");

        else
            listOfItems.add(item);
    }

    void RegisterMember(Member member){
        listOfMembers.add(member);
    }
    void ItemGotBorrowed(Item item ){
      item.available = false;
      item.IsAvaialble();

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

}
