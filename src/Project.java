public class Project extends Item {
    int projectYear;
    String[] team;

    public Project(int id,String title,int yearOfPublishing,String tobic,int projectYear,String[] team) {
        super(id,title,yearOfPublishing,tobic);
        this.projectYear=projectYear;
        this.team = team;
    }

    @Override
    void List(){

    }
    @Override
    void Return(){

    }

    @Override
    void borrow() {

    }
}
