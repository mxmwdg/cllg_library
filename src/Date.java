public class Date {
    final int year;
    final int month;
    final int day;
    int convertedDate;

    Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    int TimeElapsedBetweenTwoDates(Date borrowDate, Date returnDate){
        //if(dateOfBorrowing.day > 23 && dateOfBorrowing.day <=31){}
            borrowDate.convertedDate = (borrowDate.year * 12 * 30) + (borrowDate.month * 30) + borrowDate.day;
            returnDate.convertedDate = (returnDate.year * 12 * 30) + (returnDate.month * 30) + returnDate.day;
            return returnDate.convertedDate - borrowDate.convertedDate;
    }
}
