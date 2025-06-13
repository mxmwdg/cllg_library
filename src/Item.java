public abstract class Item {
    int id;
    String title;
    int yearOfPublishing;
    String topic;
    public boolean available = true;

    abstract void List();
    abstract void Return();
    boolean IsAvaialble(){
        if(this.available)
            return true;
        else
            return false;
    }
}