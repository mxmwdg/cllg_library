
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Date date1 = new Date(25, 8,2015);
        LocalDate date2 = LocalDate.of(2025 , 6 , 8);
        Item book = new Book("Choco", 1990 ,"basic science","ahmad ",99,"Sa33ed ");
        Item book2 = new Book("coco", 1990 ,"Ai","ahmad ",99,"Sa33ed ");

        Book book3 = new Book("boo", 1990 ,"Ai","ahmad ",99,"Sa33ed ");
        Item book4 = new Book("joo", 1990 ,"Basic Science","ahmad ",99,"Sa33ed ");
        Library l =new Library();

//        String []a ;
//        Item proj = new Project("haz ", 3 ,true , 2020 ,  );
//
        l.RegisterItem(book2);
        l.RegisterItem(book);
//        l.RegisterItem(book3);
//        l.RegisterItem(book4);
        Member m = new Member("Amin");
        Member m1= new Member("Bilal");
        l.RegisterMember(m);
        l.RegisterMember(m1);
//
        LocalDate d = LocalDate.now();
          l.ItemLend(m,book,date2);
          l.ItemReturned(m , book , d);
//        l.ItemLend(m1,book2,date2);
//        l.SearchForAnItem(3);
        System.out.println(l.ReturnedLate(date2));
        /*l.RegisterMember(m);
        System.out.println("please enter your name: ");
        String name = in.next();
        System.out.println("please enter your fucking registration number: ");
        int registrationNumber = in.nextInt();
        Member tempMember = new Member(registrationNumber,name.toLowerCase());*/
        /*System.out.println(m.registrationNumber);
        System.out.println(m1.registrationNumber);
        l.RegisterMember(m1);

        l.ItemLend(m,book , date1);
        l.ItemLend(m,book,date2);
        l.ItemLend(m,book , date2);**/
        //l.SignIn(m);

//        l.ItemLend(m,book3 , date1);
//        l.ItemLend(m,book4 , date1);

    }
}