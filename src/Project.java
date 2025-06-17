public class Project extends Item {
    int projectYear;
    String[] team;
    boolean available;

    public Project(int id,String title,int yearOfPublishing,String topic, boolean available,int projectYear,String[] team) {
        super(id,title,yearOfPublishing,topic,available);
        this.projectYear=projectYear;
        this.team = team;
        this.available = available;
    }


    @Override
    void Return(){
available=true;
    }

    @Override
    void borrow() {
available=false;
    }

    void info(){}
}
