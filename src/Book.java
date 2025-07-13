public class Book extends Item {
    String author;
    int numOfPages;
    String publisher;
    int typeNum = 1000;




    Book( String title , int YearOfPublishing , String topic ,String author, int numOfPages, String publisher){
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
}
