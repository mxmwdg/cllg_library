public class Main {
    public static void main(String[] args) {
        Date date1 = new Date(25, 7,2015);
        Date date2 = new Date(12,6,2025);
        System.out.println(date1.TimeElapsedBetweenTwoDates(date1,date2));
    }
}