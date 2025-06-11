public class Book extends Item {
    String author;
    int numOfPages;
    String publisher;
    boolean available;
    Book(String author, int numOfPages, String publisher, boolean available){
        this.author = author;
        this.numOfPages = numOfPages;
        this.publisher = publisher;
        this.available = available;

    }

    @Override
    void List(){

    }
    @Override
    void Return(){
    available=true;
    }
}
