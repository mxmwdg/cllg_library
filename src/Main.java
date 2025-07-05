import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Book book4 = new Book("Choco", 1990 ,"basic science","ahmad ",99,"Sa33ed ");
        Book book2 = new Book("coco", 1990 ,"Ai","ahmad ",99,"Sa33ed ");

        Book book3 = new Book("boo", 1990 ,"Ai","ahmad ",99,"Sa33ed ");
        Book book = new Book("joo", 1990 ,"Basic Science","ahmad ",99,"Sa33ed ");

        Member member = new Member("Amin");
        Member m1 = new Member("Bilal");
        Member pMember = new Member(book,"JJ" ,1,7);

        ArrayList<Member> members = new ArrayList<>();
        ArrayList<Item> items = new ArrayList<>();
        members.add(member);
        members.add(m1);
        members.add(pMember);
        items.add(book);
        items.add(book4);
        items.add(book3);
        items.add(book2);
        Library l =new Library(items,members);

        String options ;

        do{
            System.out.println("***********");
            System.out.println("Welcome to our library!");
            System.out.println("***********");
            System.out.println("Kindly select one of the following options:");
            System.out.println("1.log in");
            System.out.println("2.sign up");
            System.out.println("3.browse our collection");
            System.out.println("4.register an item");
            System.out.println("5.borrow an item");
            System.out.println("6.return a lent item");
            System.out.println("7.search for certain members");
            options = in.next();
            switch(options){
                case "1" : {l.RegisterMember();break;}
                case "2" : {l.SignIn();break;}
                case "3" : {l.SearchForAnItem();break;}
                case "4" : {l.RegisterItem();break;}
                case "5" : {l.ItemLend();break;}
                case "6" : {l.ItemReturn();break;}
                case "7" : {l.SearchForCertainMembers();break;}
                case "q" : break;
             }
        }while(!options.equals("q"));

        /*l.PenaliseMembers();
        l.listOfBooks.add(book);
        l.ItemLend();
        System.out.println("hello"); LocalDate date = LocalDate.now();

        l.ItemReturned();
        l.showMembersWithBorrowedBooksAndDate();
*/
//        Collections.addAll(items, book2, book , book3, book4);
//        Collections.addAll(members,m , m1,pMember);

    }
}