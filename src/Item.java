public abstract class Item {
    public int id;
    public String title;
    public int yearOfPublishing;
    public String topic;
    private boolean available;


    public Item(int id,String title,int yearOfPublishing,String topic,boolean available) {
        this.id = id;
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        this.topic = topic;
        this.available = available;

    }
    abstract void Return();
    abstract void borrow();

    public boolean IsAvailable() {
        if (this.available)
            return true;
        else
           return false;
    }
    public void setAvailable(boolean t){
        this.available = t;
    }
    public void setAvailable(){
        this.available = true;
    }

    abstract String getInfo();


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                ", topic='" + topic + '\'' +
                ", available=" + available +
                '}';
    }
}

