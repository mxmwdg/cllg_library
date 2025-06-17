public class Book extends Item {
    String author;
    int numOfPages;
    String publisher;

//If anyone make the id get set by itself , remover all the ID here
    Book(int id , String title , int YearOfPublishing , String topic ,String author, int numOfPages, String publisher, boolean available){
        super(id,title,YearOfPublishing,topic,available);
        this.author = author;
        this.numOfPages = numOfPages;
        this.publisher = publisher;


    }

    Book(int id , String title , int YearOfPublishing , String topic , int numOfPages, String publisher, boolean available){
        super(id,title,YearOfPublishing,topic,available);
        this.numOfPages = numOfPages;
        this.publisher = publisher;
        this.author = "Anonymous author";

    }

    Book(int id , String title , String topic ,String author, int numOfPages, String publisher, boolean available){
        super(id,title,2025,topic,available);
        this.author = author;
        this.numOfPages = numOfPages;
        this.publisher = publisher;

    }
    Book(int id , String title , int YearOfPublishing , String topic ,String author, int numOfPages, boolean available){
        super(id,title,YearOfPublishing,topic,available);
        this.author = author;
        this.numOfPages = numOfPages;
        this.publisher = "Anonymous Publisher";
    }

    Book(int id , String title , int YearOfPublishing , String topic , int numOfPages, boolean available){
        super(id,title,YearOfPublishing,topic,available);
        this.numOfPages = numOfPages;
        this.publisher = "Anonymous Publisher";
        this.author = "Anonymous author";
    }

    Book(){
        super(20,"NO Name ",2025,"no assigned topic",true);
        this.author = "Anonymous author";
        this.numOfPages = 200;
        this.publisher = "Anonymous Publisher";
        this.author = "Anonymous author ";

    }
    Book(String title){
        super(20,title,2025,"no assigned topic",true);
        this.author = "Anonymous author";
        this.numOfPages = 200;
        this.publisher = "Anonymous Publisher";
        this.author = "Anonymous author ";

    }





    @Override
    void Return(){
    super.setAvailable();
    }
    @Override
     void borrow(){
        super.setAvailable(false);
     }
    void info(){

    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", numOfPages=" + numOfPages +
                ", publisher='" + publisher + '\'' +
                '}';
    }

    @Override
    String getInfo() {
        System.out.println(super.toString());
        return "Book{" +
                "author='" + author + '\'' +
                ", numOfPages=" + numOfPages +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
