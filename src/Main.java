import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Date date1 = new Date(25, 8,2015);
        Date date2 = new Date(29, 8,2015);
        Book book4 = new Book("Choco", 1990 ,"basic science","ahmad ",99,"Sa33ed ");
        Book book2 = new Book("coco", 1990 ,"Ai","ahmad ",99,"Sa33ed ");

        Book book3 = new Book("boo", 1990 ,"Ai","ahmad ",99,"Sa33ed ");
        Book book = new Book("joo", 1990 ,"Basic Science","ahmad ",99,"Sa33ed ");

        Member member = new Member("Amin");
        Member m1 = new Member("Bilal");
        Member pMember = new Member(book,"JJ" ,1,7);

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


        Library l =new Library(items,members,books);

        String options ;

        /*do{
            System.out.println("***********");
            System.out.println("Welcome to our library!");
            System.out.println("***********");
            System.out.println("Kindly select one of the following options:");
            options = in.next();
            switch(options){
                case "1" : {}
                case "2" : {}
                case "q" : break;
             }
        }while(true);*/

        l.PenaliseMembers();
        l.listOfBooks.add(book);
        l.ItemLend();
        System.out.println("hello"); LocalDate date = LocalDate.now();

        l.ItemReturned();
        l.showMembersWithBorrowedBooksAndDate();


//        Collections.addAll(items, book2, book , book3, book4);
//        Collections.addAll(members,m , m1,pMember);

    }
}