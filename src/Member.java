import java.util.ArrayList;

public class Member {
    int registrationNumber;
    String name;
    ArrayList<Item> BorrowedItems = new ArrayList<>();
    ArrayList<Date> DateOfBorrowing = new ArrayList<>();
    ArrayList<Date> DateOfReturning = new ArrayList<>();

    //for the 3 items limit, because they want the date of borrow/return. It makes so you can see each member's history.
    private int numberOfBorrowedItems = 0;


    Member(int registrationNumber, String name){
        this.registrationNumber = registrationNumber;
        this.name = name;
    }
    void BorrowItem(Item item, Date dateOfBorrowing){
        BorrowedItems.add(item);
        DateOfBorrowing.add(dateOfBorrowing);
        numberOfBorrowedItems = numberOfBorrowedItems + 1;

    }

    /**you can make it harder by making multiple borrows/returns at the same time possible**/

    void ReturnItem(Item item, Date dateOfReturning){
        DateOfReturning.add(dateOfReturning);
        numberOfBorrowedItems = numberOfBorrowedItems - 1;
    }

    int getNumberOfBorrowedItems(){
        return numberOfBorrowedItems;
    }

}
