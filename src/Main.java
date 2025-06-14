import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Date date1 = new Date(25, 8,2015);
        Item book = new Book(2,"Choco", 1990 ,"hah","ahmad ",99,"Sa33ed ",true);
        Item book2 = new Book(2,"coco", 1990 ,"hah","ahmad ",99,"Sa33ed ",true);

        Item book3 = new Book(2,"boo", 1990 ,"hah","ahmad ",99,"Sa33ed ",true);
        Item book4 = new Book(2,"joo", 1990 ,"hah","ahmad ",99,"Sa33ed ",true);
        Library l =new Library();
        Member m = new Member(99,"Amin");
        l.ItemGotBorrowed(m,book , date1);
        l.ItemGotBorrowed(m,book2 , date1);
        l.ItemGotBorrowed(m,book3 , date1);
        l.ItemGotBorrowed(m,book4 , date1);

    }
}