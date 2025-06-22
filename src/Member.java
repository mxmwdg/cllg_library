import java.time.LocalDate;
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
    private boolean signedIn = false;

    public String getName() {
        return name;
    }

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

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    void BorrowItem(Item item){
        BorrowedItems.add(item);
        BorrowedItemsHistory.add(item);
        LocalDate currantDate = LocalDate.now();
        Date now = new Date(currantDate.getDayOfMonth(),currantDate.getDayOfMonth(),currantDate.getYear());
        DateOfBorrowing.add(now);
    }

    /**you can make it harder by making multiple borrows/returns at the same time possible**/

    void ReturnItem(Item item){
        LocalDate currantDate = LocalDate.now();
        Date now = new Date(currantDate.getDayOfMonth(),currantDate.getDayOfMonth(),currantDate.getYear());
        DateOfReturning.add(now);
        DateOfBorrowing.remove(BorrowedItems.indexOf(item));
        BorrowedItems.remove(item);
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
        return this.registrationNumber == tempMember.registrationNumber && this.name.equalsIgnoreCase(tempMember.name);


    }

}
