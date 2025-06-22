import java.time.LocalDate;
import java.util.ArrayList;

public class Member {
    int registrationNumber = 20250;
    String name;
    static int count = 0;
    ArrayList<Item> BorrowedItems = new ArrayList<>();
    ArrayList<Item> BorrowedItemsHistory = new ArrayList<>();
    ArrayList<LocalDate> DateOfBorrowing = new ArrayList<>();
    ArrayList<LocalDate> DateOfReturning = new ArrayList<>();
    //for the 3 items limit, because they want the date of borrow/return. It makes so you can see each member's history.
    private boolean signedIn = false;
    private boolean isLate;


    Member(String name){
        registrationNumber = registrationNumber + count;
        count = count + 1;
        this.name = name;
    }
    Member(int registrationNumber, String name ){
        this.registrationNumber = registrationNumber;
        this.name = name;
    }
    Member(){
        registrationNumber = registrationNumber + count;
        count = count + 1;
        this.name = "Samer <3";
    }


    void BorrowItem(Item item, LocalDate dateOfBorrowing ){
        BorrowedItems.add(item);
        BorrowedItemsHistory.add(item);
        DateOfBorrowing.add(dateOfBorrowing);
    }

    /**you can make it harder by making multiple borrows/returns at the same time possible**/

    void ReturnItem(Item item, LocalDate dateOfReturning){
        DateOfReturning.add(dateOfReturning);
    }

    int getNumberOfBorrowedItems(){
        return BorrowedItems.size();
    }
    void setSignedIn(boolean signedIn){
        this.signedIn = signedIn;
    }

    public boolean isSignedIn() {
        return signedIn;
    }

    boolean equals(Member tempMember){
        return this.registrationNumber == tempMember.registrationNumber && this.name.toLowerCase().equals(tempMember.name.toLowerCase());


    }

}
