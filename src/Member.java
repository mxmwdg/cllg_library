import java.util.ArrayList;

public class Member {
    int registrationNumber = 20250;
    String name;
    static int count = 0;
    ArrayList<Item> BorrowedItems = new ArrayList<>();
    ArrayList<Item> BorrowedItemsHistory = new ArrayList<>();
    ArrayList<Date> DateOfBorrowing = new ArrayList<>();
    ArrayList<Date> DateOfReturning = new ArrayList<>();
    //for the 3 items limit, because they want the date of borrow/return. It makes so you can see each member's history.
    private int numberOfBorrowedItems = 0;
    private boolean signedIn = false;


    Member(String name){
        registrationNumber = registrationNumber + count;
        count = count + 1;
        this.name = name;
    }
    Member(int registrationNumber, String name ){
        this.registrationNumber = registrationNumber;
        this.name = name;
    }
    void BorrowItem(Item item, Date dateOfBorrowing ){
        BorrowedItems.add(item);
        BorrowedItemsHistory.add(item);
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
    void setSignedIn(boolean signedIn){
        this.signedIn = signedIn;
    }

    public boolean isSignedIn() {
        return signedIn;
    }

    boolean equals(Member tempMember){
        if(this.registrationNumber == tempMember.registrationNumber && this.name.toLowerCase().equals(tempMember.name.toLowerCase())){
            return true;
        }
        else{
            return false;
        }


    }

}
