public class Book extends Item {
    int IdOfBook=1000;
    int count1=0;
    String author;
    int numOfPages;
    String publisher;



    Book(String title){
        super(title);
        IdOfBook=IdOfBook+count1;
        count1=count1+1;
    }

    Book(int idOfBook , String title , int YearOfPublishing , String topic ,String author, int numOfPages, String publisher, boolean available){
        super(title,YearOfPublishing,topic,available);
        this.IdOfBook=IdOfBook;
        this.author = author;
        this.numOfPages = numOfPages;
        this.publisher = publisher;


    }

    Book( String title , int YearOfPublishing , String topic , int numOfPages, String publisher, boolean available){
        super(title,YearOfPublishing,topic,available);
        this.numOfPages = numOfPages;
        this.publisher = publisher;
        this.author = "Anonymous author";

    }

    Book( String title , String topic ,String author, int numOfPages, String publisher, boolean available){
        super(title,2025,topic,available);
        this.author = author;
        this.numOfPages = numOfPages;
        this.publisher = publisher;

    }
    Book( String title , int YearOfPublishing , String topic ,String author, int numOfPages, boolean available){
        super(title,YearOfPublishing,topic,available);
        this.author = author;
        this.numOfPages = numOfPages;
        this.publisher = "Anonymous Publisher";
    }

    Book( String title , int YearOfPublishing , String topic , int numOfPages, boolean available){
        super(title,YearOfPublishing,topic,available);
        this.numOfPages = numOfPages;
        this.publisher = "Anonymous Publisher";
        this.author = "Anonymous author";
    }

    Book(){
        super("NO Name ",2025,"no assigned topic",true);
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
