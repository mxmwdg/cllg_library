import java.util.Arrays;

public class Project extends Item {
    int projectYear;
    String[] team = {"no name members"};


    Project( String title, int yearOfPublishing, String topic, int projectYear, String[] team) {
        super(title, yearOfPublishing, topic,2000);
        this.team = team;
        this.projectYear = projectYear;
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
        public int getId(){
        return this.id;
        }
        @Override
        void getInfo () {
            System.out.println("Project " +
                    "\n title = " + title +
                    "\n *projectYear = " + projectYear +
                    "\n *team = " + Arrays.toString(team) );
            System.out.println(super.toString());
        }
    }
