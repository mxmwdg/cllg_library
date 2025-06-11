import java.util.ArrayList;

public class Member {
    int registrationNumber;
    String name;
    ArrayList<Item> BorrowedItems = new ArrayList<>();

    Member(int registrationNumber, String name, ArrayList<Item> BorrowedItems){
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.BorrowedItems = BorrowedItems;
    }
    void BorrowItem(Item item){
        if(BorrowedItems.size()<=3){
            BorrowedItems.add(item);
            //System.out.println("here you go");

        }
        else
            System.out.println("you can't borrow more than three items." + "/n" +
                                "you have to return an item first.");


    }
    //you have to save the date of borrowing/returning

    void ReturnItem(Item item){

    }

}
