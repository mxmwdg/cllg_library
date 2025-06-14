public abstract class Item {
    public int id;
    public String title;
    public int yearOfPublishing;
    public String topic;
    boolean available;

    public Item(int id,String title,int yearOfPublishing,String topic,boolean available) {
        this.id = id;
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        this.topic = topic;
        this.available = available;
    }
    abstract void Return();
    abstract void borrow();

    public boolean IsAvailable() { return available;
    }
}