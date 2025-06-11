import java.util.ArrayList;
public class Library {
    ArrayList<Item> listOfItems = new ArrayList<>();
    ArrayList<Member> listOfMembers = new ArrayList<>();

    void RegisterItem(){

    }
    void RegisterMember(){

    }
    void ItemGotBorrowed(){

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
