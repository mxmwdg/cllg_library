import javax.lang.model.type.NullType;
import java.util.Arrays;

public class Project extends Item {
    int IdOfProject = 2000;
    int count2 = 0;
    int projectYear;
    String[] team;


    Project(String title) {
        super(title);
        IdOfProject = IdOfProject + count2;
        count2 = count2 + 1;
    }

    Project(int IdOfProject, String title, int yearOfPublishing, String topic, boolean available, int projectYear, String[] team) {
        super(title, yearOfPublishing, topic, available);
        this.IdOfProject = IdOfProject;
        this.projectYear = projectYear;
    }
    public Project(  String title,int yearOfPublishing, String topic,boolean available, int projectYear, String[]
        team){
            super( title, yearOfPublishing, topic, available);
            this.projectYear = projectYear;
            this.team = team;

        }

    public Project() {
            super( "No Name", 2025, "no topic assigned", true);
            this.projectYear = 3;
            for (String s : this.team)
                s = "null";
        }

    public Project( String title, String topic,boolean available, int projectYear, String[] team){
            super( title, 2025, topic, available);
            this.projectYear = projectYear;
            this.team = team;

        }

    public Project(  String title,int yearOfPublishing, String topic,boolean available, int projectYear){
            super( title, yearOfPublishing, topic, available);
            this.projectYear = projectYear;

            for (String s : this.team)
                s = "null";
        }

    public Project(  String title,int yearOfPublishing, boolean available, int projectYear, String[] team){
            super( title, yearOfPublishing, "No topic assigned", available);
            this.projectYear = projectYear;
            this.team = team;

        }



    public Project(String title, int projectyear){
            super( title, 2025, "no assigned topic", true);
            this.projectYear = projectyear;
            for (String s : this.team)
                s = "null";

        }


        @Override
        void Return () {
            super.setAvailable();
        }

        @Override
        void borrow () {
            super.setAvailable(false);
        }


        @Override
        String getInfo () {
            System.out.println(super.toString());
            return "Project{" +
                    "projectYear=" + projectYear +
                    ", team=" + Arrays.toString(team) +
                    '}';
        }

    }
