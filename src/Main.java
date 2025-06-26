import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Date date1 = new Date(25, 8,2015);
        Date date2 = new Date(29, 8,2015);
        Item book = new Book("Choco", 1990 ,"basic science","ahmad ",99,"Sa33ed ");
        Item book2 = new Book("coco", 1990 ,"Ai","ahmad ",99,"Sa33ed ");

        Item book3 = new Book("boo", 1990 ,"Ai","ahmad ",99,"Sa33ed ");
        Item book4 = new Book("joo", 1990 ,"Basic Science","ahmad ",99,"Sa33ed ");

        Member m = new Member("Amin");
        Member m1 = new Member("Bilal");

        ArrayList<Member> members = new ArrayList<>();
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Project> projects = new ArrayList<>();

        Collections.addAll(items, book2, book , book3, book4);
        Collections.addAll(members,m , m1);

        Library l =new Library(items,members);
//        String []a ;

//        Item proj = new Project("haz ", 3 ,true , 2020 ,  );

        l.ItemLend();
        l.ItemReturned();
        in.close();
      //  l.ItemLend();
   //     l.SearchForCertainMembers(3);
//        l.RegisterItem(book3);
//        l.RegisterItem(book4);

    //    Member m1= new Member("Bilal");

       // l.RegisterMember(m1);

//        System.out.println(book.id);



      //  l.ItemLend(m1,book,date2);
      //  l.ItemLend(m1,book2,date2);
//        l.SearchForAnItem(3);

//        book.getInfo();

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