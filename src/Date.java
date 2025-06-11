public class Date {
    final int year;
    final int month;
    final int day;
    int convertedDate;

    Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
        this.convertedDate = ConvertDateToDays();
    }

    int ConvertDateToDays(){
        int temp = (this.year * 365) + ((this.month ) * 30) + this.day;
        switch (this.month){
            case 2, 6,7-> temp = temp + 1;
            case 3 -> temp = temp - 1;
            case 8 -> temp = temp + 2;
            case 9,10 -> temp = temp + 3;
            case 11,12 -> temp = temp + 4;
        }
        int temp2 = this.year / 4;
        temp = temp + temp2;

        if(this.year % 4 != 0)
            temp = temp + 1;

        return temp;
    }
    int TimeElapsedBetweenTwoDates(Date borrowDate, Date returnDate){
        //if(dateOfBorrowing.day > 23 && dateOfBorrowing.day <=31){}
           // borrowDate.convertedDate = (borrowDate.year * 12 * 30) + (borrowDate.month * 30) + borrowDate.day;
            //returnDate.convertedDate = (returnDate.year * 12 * 30) + (returnDate.month * 30) + returnDate.day;
            return returnDate.convertedDate - borrowDate.convertedDate;
    }
}
