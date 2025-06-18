public abstract class Item {
    public String title;
    public int yearOfPublishing;
    public String topic;
    private boolean available;


    public Item(String title,int yearOfPublishing,String topic) {
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        this.topic = topic;
        this.available = true;
    }

    public Item(String title) {
        this.title=title;
    }



    abstract void Return();
    abstract void borrow();

    public boolean IsAvailable() {
        return this.available;
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
                ", title='" + title + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                ", topic='" + topic + '\'' +

                ", available=" + available +
                '}';
    }
}

