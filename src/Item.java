public abstract class Item {
    private static int count = 0;
    public String title;
    int id;
    public int yearOfPublishing;
    public String topic;
    private boolean available;


    public Item(String title,int yearOfPublishing,String topic,int typeNum) {
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        this.topic = topic;
        this.available = true;
        count = count + 1;
        if(topic.equalsIgnoreCase("basic science") || topic.equalsIgnoreCase("science"))
            this.id = id + 100 + count + typeNum;
        else if(topic.equalsIgnoreCase("ai")|| topic.equalsIgnoreCase("artificial intelligence"))
            this.id = id + 300 + count + typeNum;
        else if(topic.equalsIgnoreCase("software development")|| topic.equalsIgnoreCase("software"))
            this.id = id + 500 + count + typeNum;
        else if (topic.equalsIgnoreCase("networks"))
            this.id = id + 700 + count + typeNum;
        else
            this.id = id + 900 + count + typeNum;
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

