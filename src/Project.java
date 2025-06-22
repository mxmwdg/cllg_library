import java.util.Arrays;

public class Project extends Item {
    int typeNum = 2000;
    private static int count2 = 0;
    int projectYear;
    String[] team = {"no name members"};


    Project(String title) {
        super(title);

        count2 = count2 + 1;
    }

    Project( String title, int yearOfPublishing, String topic, int projectYear, String[] team) {
        super(title, yearOfPublishing, topic,2000);
        this.team = team;
        this.projectYear = projectYear;
    }
    public Project() {
            super( "No Name", 2025, "no topic assigned",2000);
            this.projectYear = 3;
            for (String s : this.team)
                s = "null";
        }



    public Project(String title, String topic, int projectYear, String[] team){
            super( title, 2025, topic ,2000);
            this.projectYear = projectYear;
            this.team = team;
        }

    public Project(  String title,int yearOfPublishing, String topic, int projectYear){
            super( title, yearOfPublishing, topic,2000);
            this.projectYear = projectYear;

            for (String s : this.team)
                s = "null";
        }

    public Project(  String title,int yearOfPublishing, int projectYear, String[] team){
        super( title, yearOfPublishing, "No topic assigned",2000);
        this.projectYear = projectYear;
        this.team = team;
        }



    public Project(String title, int projectYear){
            super( title, 2025, "no assigned topic",2000);
            this.projectYear = projectYear;
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
