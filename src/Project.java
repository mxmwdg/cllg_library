public class Project extends Item {
    int IdOfProject=2000;
    int count2=0;
    int projectYear;
    String[] team;
    boolean available;


    Project(String title){
        super(title);
        IdOfProject=IdOfProject+count2;
        count2=count2+1;
    }

    Project(int IdOfProject , String title,int yearOfPublishing,String topic, boolean available, int projectYear,String[] team) {
        super(title,yearOfPublishing,topic,available);
        this.IdOfProject=IdOfProject;
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
