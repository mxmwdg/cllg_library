import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Library l = getLibrary();
        String options ;

         System.out.println("======Welcome to our library!======");

        do{
            System.out.println("============================================");
            System.out.println("Kindly select one of the following options:");
            System.out.println("1.log in");
            System.out.println("2.sign up");
            System.out.println("3.browse our collection");
            System.out.println("4.register an item");
            System.out.println("5.borrow an item");
            System.out.println("6.return a lent item");
            System.out.println("7.search for certain members");
            System.out.println("q. quit");
            System.out.println("============================================");

            options = in.next();
            switch(options){
                case "1" : {l.SignIn();break;}
                case "2" : {l.RegisterMember();break;}
                case "3" : {l.SearchForAnItem();break;}
                case "4" : {l.RegisterItem();break;}
                case "5" : {l.ItemLend();break;}
                case "6" : {l.ItemReturn();break;}
                case "7" : {l.SearchForCertainMembers();break;}
                case "q" : break;
                default:
                    System.out.println("Wrong input!");
             }

        }while(!options.equals("q"));

    }

    private static Library getLibrary() {
        Book book4 = new Book("Mage Errant", 2005 ,"basic science","John Bierce",1049,"American Press");
        Book book2 = new Book("Benefits of Ai", 2019 ,"Ai","Elon Musk",543,"Ai For Publishing");
        Book book3 = new Book("the angel next door", 1990 ,"Software development","Satan",700,"Paradise");
        Book book = new Book("AcLover", 2028 ,"Basic Science"," mustafa alexander",696,"Mdrj 4");

        String[] team1 = {"Amin","Bilal","Mustafa"};
        String[] team2 = {"jfk","Majd"};
        String[] team3 = { "Barry","Grey","Llama"};
        String[] team4 = {"Ned","Smith","Horseman","Halland","Croma","Bojack"};

        Project p1 = new Project("Story of Nice People",2020,"Ai", 2,team1);
        Project p2 = new Project("----Godel Escher Bach GEB",2012,"software development",3,team2);
        Project p3 = new Project("Library automate",2019,"basic science" ,4,team3 );
        Project p4 = new Project("Discovering life",1950,"Software development", 5,team4);

        Member m = new Member("Amin");//20250
        Member m1 = new Member("Bilal");//20251
        Member m2 = new Member("Mustafa");//20252
        Member m3 = new Member("Hamza");//20253
        Member m4 = new Member("Maxim");//20254
        Member m5 = new Member("Kinan");//20255

        Member pMember = new Member(book,"James" ,1,7);

        ArrayList<Member> members = new ArrayList<>();
        ArrayList<Item> items = new ArrayList<>();
        members.add(m);
        members.add(m1);
        members.add(m2);
        members.add(m3);
        members.add(m4);
        members.add(m5);
        members.add(pMember);
        items.add(book);
        items.add(book4);
        items.add(book3);
        items.add(book2);
        items.add(p1);
        items.add(p2);
        items.add(p3);
        items.add(p4);
        return new Library(items,members);
    }
}