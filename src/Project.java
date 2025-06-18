import java.util.Arrays;

public class Project extends Item {
    int IdOfProject = 2000;
    static int count2 = 0;
    int projectYear;
    String[] team = {"no name members"};


    Project(String title) {
        super(title);
        IdOfProject = IdOfProject + count2;
        count2 = count2 + 1;
    }

    Project( String title, int yearOfPublishing, String topic, int projectYear, String[] team) {
        super(title, yearOfPublishing, topic);
        if(topic.equalsIgnoreCase("basic science") || topic.equalsIgnoreCase("science"))
            this.IdOfProject = IdOfProject + 100 + count2;
        else if(topic.equalsIgnoreCase("ai")|| topic.equalsIgnoreCase("artificial intelligence"))
            this.IdOfProject = IdOfProject + 300 + count2;
        else if(topic.equalsIgnoreCase("software development")|| topic.equalsIgnoreCase("software"))
            this.IdOfProject = IdOfProject + 500 + count2;
        else if (topic.equalsIgnoreCase("networks"))
            this.IdOfProject = IdOfProject + 700 + count2;
        else
            this.IdOfProject = IdOfProject + 900 + count2;
        this.team = team;
        this.projectYear = projectYear;
    }
    public Project() {
            super( "No Name", 2025, "no topic assigned");
            this.projectYear = 3;
            for (String s : this.team)
                s = "null";
        this.IdOfProject = IdOfProject + 900 + count2;

        }

    public int getIdOfProject() {
        return IdOfProject;
    }

    public Project(String title, String topic, int projectYear, String[] team){
            super( title, 2025, topic);
            this.projectYear = projectYear;
            this.team = team;
        if(topic.equalsIgnoreCase("basic science") || topic.equalsIgnoreCase("science"))
            this.IdOfProject = IdOfProject + 100 + count2;
        else if(topic.equalsIgnoreCase("ai")|| topic.equalsIgnoreCase("artificial intelligence"))
            this.IdOfProject = IdOfProject + 300 + count2;
        else if(topic.equalsIgnoreCase("software development")|| topic.equalsIgnoreCase("software"))
            this.IdOfProject = IdOfProject + 500 + count2;
        else if (topic.equalsIgnoreCase("networks"))
            this.IdOfProject = IdOfProject + 700 + count2;
        else
            this.IdOfProject = IdOfProject + 900 + count2;
        }

    public Project(  String title,int yearOfPublishing, String topic, int projectYear){
            super( title, yearOfPublishing, topic);
            this.projectYear = projectYear;

            for (String s : this.team)
                s = "null";
        if(topic.equalsIgnoreCase("basic science") || topic.equalsIgnoreCase("science"))
            this.IdOfProject = IdOfProject + 100 + count2;
        else if(topic.equalsIgnoreCase("ai")|| topic.equalsIgnoreCase("artificial intelligence"))
            this.IdOfProject = IdOfProject + 300 + count2;
        else if(topic.equalsIgnoreCase("software development")|| topic.equalsIgnoreCase("software"))
            this.IdOfProject = IdOfProject + 500 + count2;
        else if (topic.equalsIgnoreCase("networks"))
            this.IdOfProject = IdOfProject + 700 + count2;
        else
            this.IdOfProject = IdOfProject + 900 + count2;
        }

    public Project(  String title,int yearOfPublishing, int projectYear, String[] team){
        super( title, yearOfPublishing, "No topic assigned");
        this.projectYear = projectYear;
        this.team = team;
        this.IdOfProject = IdOfProject + 900 + count2;
        }



    public Project(String title, int projectYear){
            super( title, 2025, "no assigned topic");
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
