import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Date date1 = new Date(25, 8,2015);
        Date date2 = new Date(29, 8,2015);
        Item book4 = new Book("Choco", 1990 ,"basic science","ahmad ",99,"Sa33ed ");
        Item book2 = new Book("coco", 1990 ,"Ai","ahmad ",99,"Sa33ed ");

        Item book3 = new Book("boo", 1990 ,"Ai","ahmad ",99,"Sa33ed ");
        Item book = new Book("joo", 1990 ,"Basic Science","ahmad ",99,"Sa33ed ");

        Member member = new Member("Amin");
        Member m1 = new Member("Bilal");
        Member pMember = new Member(date1,book,"JJ" ,1);

        ArrayList<Member> members = new ArrayList<>();
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Project> projects = new ArrayList<>();
        members.add(member);
        members.add(m1);
        members.add(pMember);
        items.add(book);
        items.add(book4);
        items.add(book3);
        items.add(book2);


//        Collections.addAll(items, book2, book , book3, book4);
//        Collections.addAll(members,m , m1,pMember);

        Library l =new Library(items,members);
       l.listOfBooks.add((Book) book);
        l.listOfBooks.add((Book) book2);
        l.listOfBooks.add((Book) book3);
        l.listOfBooks.add((Book) book4);


        l.PenaliseMembers();
//        Item proj = new Project("haz ", 3 ,true , 2020 ,  );

        l.ItemLend();
        System.out.println("hello"); LocalDate date = LocalDate.now();

        l.ItemReturned();
        l.showMembersWithBorrowedBooksAndDate();

        //System.out.println(member.getName() + " has borrowed " + book.title + " in " + book.DatesOfBorrows.get(member.BorrowedItemsHistory.indexOf(book)+1).day);

//  l.ItemReturned();
//        in.close();
//        Date dat1 = new Date(25,6,2025);
//        Date dat2 = new Date(1,7,2025);
//        Date now = new Date(27,6,2025);
//        System.out.println(now.isBetween(dat1,dat2));
      //  l.ItemLend();
   //   l.SearchForCertainMembers(5);
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