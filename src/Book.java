public class Book extends Item {
    String author;
    int numOfPages;
    String publisher;
    boolean available;

    Book(int id , String title , int YearOfPublishing , String topic ,String author, int numOfPages, String publisher, boolean available){
        super(id,title,YearOfPublishing,topic,available);
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
