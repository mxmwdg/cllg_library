public abstract class Item {
    public String title;
    public int yearOfPublishing;
    public String topic;
    private boolean available;


    public Item(String title,int yearOfPublishing,String topic,boolean available) {
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        this.topic = topic;
        this.available = available;

    }

    public Item(String title) {
        this.title=title;
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

