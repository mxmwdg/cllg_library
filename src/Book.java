public class Book extends Item {
    private String author;
    private int numOfPages;
    private String publisher;

    Book(String title , int YearOfPublishing , String topic , String author, int numOfPages, String publisher){
        super(title,YearOfPublishing,topic,1000);
        this.author = author;
        this.numOfPages = numOfPages;
        this.publisher = publisher;
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
    void getInfo() {
        System.out.println(
                "Book " +
                "\n *author = " + author +
                "\n *numOfPages = " + numOfPages +
                "\n *publisher = " + publisher );
        System.out.print(super.toString());
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }








}
