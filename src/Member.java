import java.util.ArrayList;

public class Member {
    int registrationNumber;
    String name;
    ArrayList<Item> BorrowedItems = new ArrayList<>();
    ArrayList<Date> DateOfBorrowing = new ArrayList<>();
    ArrayList<Date> DateOfReturning = new ArrayList<>();
    private int numberOfBorrowedItems = 0;


    Member(int registrationNumber, String name){
        this.registrationNumber = registrationNumber;
        this.name = name;
    }
    void BorrowItem(Item item, Date dateOfBorrowing){
       /*, int day, int month,int year
       if(BorrowedItems.size()<=3){
            BorrowedItems.add(item);
            Date date = new Date(day,month,year);
            System.out.println("here you go!");
        }
        else
            System.out.println("you can't borrow more than three items." + "/n" +
                                "you have to return an item first.");*/
        BorrowedItems.add(item);
        DateOfBorrowing.add(dateOfBorrowing);
        numberOfBorrowedItems = numberOfBorrowedItems + 1;

    }
    //you have to save the date of borrowing/returning

    /**you can make more hard by making multiple borrows/returns at the same time possible**/
    void ReturnItem(Item item, Date dateOfReturning){
        DateOfReturning.add(dateOfReturning);
        numberOfBorrowedItems = numberOfBorrowedItems - 1;

        //System.out.println("you have returned: " + item.title);
    }

    int getNumberOfBorrowedItems(){
        return numberOfBorrowedItems;
    }

}
