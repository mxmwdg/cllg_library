
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Date date1 = new Date(25, 8,2015);
        Date date2 = new Date(29, 8,2015);
        Item book = new Book(2,"Choco", 1990 ,"hah","ahmad ",99,"Sa33ed ",true);
        Item book2 = new Book(2,"coco", 1990 ,"hah","ahmad ",99,"Sa33ed ",true);

        Item book3 = new Book(2,"boo", 1990 ,"hah","ahmad ",99,"Sa33ed ",true);
        Item book4 = new Book(2,"joo", 1990 ,"hah","ahmad ",99,"Sa33ed ",true);
        Library l =new Library();
        l.RegisterItem(book);

        Member m = new Member("amin");
        Member m1= new Member("Amin");
        l.RegisterMember(m);
        /*System.out.println(m.registrationNumber);
        System.out.println(m1.registrationNumber);
        l.RegisterMember(m1);

        l.ItemLend(m,book , date1);
        l.ItemLend(m,book,date2);
        l.ItemLend(m,book , date2);**/
        l.SignIn();

//        l.ItemLend(m,book3 , date1);
//        l.ItemLend(m,book4 , date1);

    }
}