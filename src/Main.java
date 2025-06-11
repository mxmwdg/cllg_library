public class Main {
    public static void main(String[] args) {
        Date date1 = new Date(1,1,2020);
        Date date2 = new Date(1,1,2025);
        System.out.println(date1.TimeElapsedBetweenTwoDates(date1,date2));
    }
}