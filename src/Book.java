public class Book extends Item {
    String author;
    int numOfPages;
    String publisher;
    boolean available;
    Book(int id,String title,int yearOfPublishing,String topic, boolean available,String author, int numOfPages, String publisher){
        super(id,title,yearOfPublishing,topic,available);
        this.author = author;
        this.numOfPages = numOfPages;
        this.publisher = publisher;
    }

    @Override
    void Return(){

        available=true;
    }

    @Override
    void borrow() {
        available=false;
    }
}
