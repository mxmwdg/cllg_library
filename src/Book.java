public class Book extends Item {
    String author;
    int numOfPages;
    String publisher;
    int typeNum = 1000;


    Book(String title){
        super(title);
    }

    Book( String title , int YearOfPublishing , String topic ,String author, int numOfPages, String publisher){
        super(title,YearOfPublishing,topic,1000);
        this.author = author;
        this.numOfPages = numOfPages;
        this.publisher = publisher;
    }

    Book( String title , int YearOfPublishing , String topic , int numOfPages, String publisher){
        super(title,YearOfPublishing,topic,1000);
        this.numOfPages = numOfPages;
        this.publisher = publisher;
        this.author = "Anonymous author";

    }

    Book( String title , String topic ,String author, int numOfPages, String publisher){
        super(title,2025,topic,1000);
        this.author = author;
        this.numOfPages = numOfPages;
        this.publisher = publisher;

    }
    Book( String title , int YearOfPublishing , String topic ,String author, int numOfPages){
        super(title,YearOfPublishing,topic,1000);

        this.author = author;
        this.numOfPages = numOfPages;
        this.publisher = "Anonymous Publisher";
    }

    Book( String title , int YearOfPublishing , String topic , int numOfPages){
        super(title,YearOfPublishing,topic,1000);
        this.numOfPages = numOfPages;
        this.publisher = "Anonymous Publisher";
        this.author = "Anonymous author";
    }

    Book(){
        super("NO Name ",2025,"no assigned topic",1000);
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
     @Override
     public int getId(){
       return super.id;
    }

    @Override
    String getInfo() {
        System.out.println(super.toString());
        return "Book{" +
                "author= '" + author + '\'' +
                ", numOfPages= " + numOfPages +
                ", publisher= '" + publisher + '\'' +
                ", id= '" + id +
                '}' ;
    }
}
