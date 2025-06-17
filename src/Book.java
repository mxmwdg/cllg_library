public class Book extends Item {
    int IdOfBook=1000;
    int count1=0;
    String author;
    int numOfPages;
    String publisher;
    boolean available;


    Book(String title){
        super(title);
        IdOfBook=IdOfBook+count1;
        count1=count1+1;
    }


    Book(int IdOfBook,String title , int YearOfPublishing , String topic , String author, int numOfPages, String publisher, boolean available){
        super(title,YearOfPublishing,topic,available);
        this.IdOfBook=IdOfBook;
        this.author = author;
        this.numOfPages = numOfPages;
        this.publisher = publisher;
        this.available = available;

    }



    @Override
    void Return(){
    available=true;
    }
    @Override
     void borrow(){
        available=false;

     }
    void info(){}
}
