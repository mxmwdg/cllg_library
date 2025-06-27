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
    //Added The abs so we don't care about the order
    public static int TimeElapsedBetweenTwoDates(Date borrowDate, Date returnDate){
            return Math.abs(returnDate.convertedDate - borrowDate.convertedDate);
    }
    public boolean isEquals(Date date){
        int entered = this.ConvertDateToDays();
        int date1 = date.ConvertDateToDays();
        return entered == date1;
    }

    public boolean isBetween(Date date ,Date date2) {
        int Entered = this.ConvertDateToDays();
        int Date1 = date.ConvertDateToDays();
        int Date2 = date2.ConvertDateToDays();
        return Entered >= Date1 && Entered <=Date2 ;
    }
    String print(){
        return this.day + "/"+ this.month + "/" + this.year ;
    }
}
