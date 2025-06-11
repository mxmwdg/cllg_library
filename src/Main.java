public class Main {
    public static void main(String[] args) {
        Date date1 = new Date(1,1,2000);
        Date date2 = new Date(1,2,2000);
        System.out.println(date1.TimeElapsedBetweenTwoDates(date1,date2));
    }
}