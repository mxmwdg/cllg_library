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

    Book( String title , int YearOfPublishing , String topic ,String author, int numOfPages, String publisher){
        super(title,YearOfPublishing,topic);
        if(topic.equalsIgnoreCase("basic science") || topic.equalsIgnoreCase("science"))
            this.IdOfBook = IdOfBook + 100 + count1;
        else if(topic.equalsIgnoreCase("ai")|| topic.equalsIgnoreCase("artificial intelligence"))
            this.IdOfBook = IdOfBook + 300 + count1;
        else if(topic.equalsIgnoreCase("software development")|| topic.equalsIgnoreCase("software"))
            this.IdOfBook = IdOfBook + 500 + count1;
        else if (topic.equalsIgnoreCase("networks"))
            this.IdOfBook = IdOfBook + 700 + count1;
        else
            this.IdOfBook = IdOfBook + 900 + count1;
        this.author = author;
        this.numOfPages = numOfPages;
        this.publisher = publisher;


    }

    Book( String title , int YearOfPublishing , String topic , int numOfPages, String publisher){
        super(title,YearOfPublishing,topic);
        if(topic.equalsIgnoreCase("basic science") || topic.equalsIgnoreCase("science"))
            this.IdOfBook = IdOfBook + 100 + count1;
        else if(topic.equalsIgnoreCase("ai")|| topic.equalsIgnoreCase("artificial intelligence"))
            this.IdOfBook = IdOfBook + 300 + count1;
        else if(topic.equalsIgnoreCase("software development")|| topic.equalsIgnoreCase("software"))
            this.IdOfBook = IdOfBook + 500 + count1;
        else if (topic.equalsIgnoreCase("networks"))
            this.IdOfBook = IdOfBook + 700 + count1;
        else
            this.IdOfBook = IdOfBook + 900 + count1;
        this.numOfPages = numOfPages;
        this.publisher = publisher;
        this.author = "Anonymous author";

    }

    Book( String title , String topic ,String author, int numOfPages, String publisher){
        super(title,2025,topic);
        if(topic.equalsIgnoreCase("basic science") || topic.equalsIgnoreCase("science"))
            this.IdOfBook = IdOfBook + 100 + count1;
        else if(topic.equalsIgnoreCase("ai")|| topic.equalsIgnoreCase("artificial intelligence"))
            this.IdOfBook = IdOfBook + 300 + count1;
        else if(topic.equalsIgnoreCase("software development")|| topic.equalsIgnoreCase("software"))
            this.IdOfBook = IdOfBook + 500 + count1;
        else if (topic.equalsIgnoreCase("networks"))
            this.IdOfBook = IdOfBook + 700 + count1;
        else
            this.IdOfBook = IdOfBook + 900 + count1;
        this.author = author;
        this.numOfPages = numOfPages;
        this.publisher = publisher;

    }
    Book( String title , int YearOfPublishing , String topic ,String author, int numOfPages){
        super(title,YearOfPublishing,topic);
        if(topic.equalsIgnoreCase("basic science") || topic.equalsIgnoreCase("science"))
            this.IdOfBook = IdOfBook + 100 + count1;
        else if(topic.equalsIgnoreCase("ai")|| topic.equalsIgnoreCase("artificial intelligence"))
            this.IdOfBook = IdOfBook + 300 + count1;
        else if(topic.equalsIgnoreCase("software development")|| topic.equalsIgnoreCase("software"))
            this.IdOfBook = IdOfBook + 500 + count1;
        else if (topic.equalsIgnoreCase("networks"))
            this.IdOfBook = IdOfBook + 700 + count1;
        else
            this.IdOfBook = IdOfBook + 900 + count1;
        this.author = author;
        this.numOfPages = numOfPages;
        this.publisher = "Anonymous Publisher";
    }

    Book( String title , int YearOfPublishing , String topic , int numOfPages){
        super(title,YearOfPublishing,topic);
        if(topic.equalsIgnoreCase("basic science") || topic.equalsIgnoreCase("science"))
            this.IdOfBook = IdOfBook + 100 + count1;
        else if(topic.equalsIgnoreCase("ai")|| topic.equalsIgnoreCase("artificial intelligence"))
            this.IdOfBook = IdOfBook + 300 + count1;
        else if(topic.equalsIgnoreCase("software development")|| topic.equalsIgnoreCase("software"))
            this.IdOfBook = IdOfBook + 500 + count1;
        else if (topic.equalsIgnoreCase("networks"))
            this.IdOfBook = IdOfBook + 700 + count1;
        else
            this.IdOfBook = IdOfBook + 900 + count1;
        this.numOfPages = numOfPages;
        this.publisher = "Anonymous Publisher";
        this.author = "Anonymous author";
    }

    Book(){
        super("NO Name ",2025,"no assigned topic");
        this.author = "Anonymous author";
        this.numOfPages = 200;
        this.publisher = "Anonymous Publisher";
        this.author = "Anonymous author ";
        this.IdOfBook = IdOfBook + 900 + count1;

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
    String getInfo() {
        System.out.println(super.toString());
        return "Book{" +
                "author='" + author + '\'' +
                ", numOfPages=" + numOfPages +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
