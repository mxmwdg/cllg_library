
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Date date1 = new Date(21, 8,2016);
        Date date2 = new Date(29, 8,2016);
        Date date3 = new Date(23, 8,2016);
        Item book = new Book(2,"Choco", 1990 ,"hah","ahmad ",99,"Sa33ed ",true);
        Item book2 = new Book(2,"coco", 1990 ,"hah","ahmad ",99,"Sa33ed ",true);
//        System.out.println(Date.TimeElapsedBetweenTwoDates(date2,date1));
//        Item book3 = new Book(2,"boo", 1990 ,"hah","ahmad ",99,"Sa33ed ",true);
//        Item book4 = new Book(2,"joo", 1990 ,"hah","ahmad ",99,"Sa33ed ",true);
        Library l =new Library();


        l.RegisterItem(book);
        l.RegisterItem(book2);

        Member m = new Member("amin");
        Member m1= new Member("Amin");
        l.RegisterMember(m);
//        l.RegisterMember(m1);
        l.ItemLend(m,book,date1);
        l.ItemLend(m,book2,date3);
        l.ItemReturned(m,book,date2);

        /*System.out.println(m.registrationNumber);
        System.out.println(m1.registrationNumber);
        l.RegisterMember(m1);

        l.ItemLend(m,book , date1);
        l.ItemLend(m,book,date2);
        l.ItemLend(m,book , date2);**/
//        l.SignIn();

//        l.ItemLend(m,book3 , date1);
//        l.ItemLend(m,book4 , date1);

    }
}