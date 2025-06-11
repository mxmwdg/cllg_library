public abstract class Item {
    public int id;
    public String title;
    public int yearOfPublishing;
    public String topic;
    boolean available;

    public Item(int id,String title,int yearOfPublishing,String topic) {
        this.id = id;
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        this.topic = topic;
    }




    abstract void List();
    abstract void Return();
    abstract void borrow();
}