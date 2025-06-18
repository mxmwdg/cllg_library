
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Date date1 = new Date(25, 8,2015);
        Date date2 = new Date(29, 8,2015);
        Item book = new Book("Choco", 1990 ,"hah","ahmad ",99,"Sa33ed ");
        Item book2 = new Book("coco", 1990 ,"hah","ahmad ",99,"Sa33ed ");

        Book book3 = new Book("boo", 1990 ,"hah","ahmad ",99,"Sa33ed ");
        Item book4 = new Book("joo", 1990 ,"hah","ahmad ",99,"Sa33ed ");
        Library l =new Library();
        String []a ;
//        Item proj = new Project("haz ", 3 ,true , 2020 ,  );

        l.RegisterItem();
        l.RegisterItem();
        Member m = new Member("Amin");
        Member m1= new Member("Bilal");
        l.RegisterMember(m);
        l.RegisterMember(m1);
        m.BorrowItem(book,date1);
        l.ItemLend(m1,book2,date2);


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