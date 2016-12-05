import java.util.Hashtable;
import java.io.Serializable;

class ProfileDB implements Serializable{
  
    private static final long serialVersionUID = 1902521367567782416L;
    private Hashtable<Integer, Profile> profiles;
    private Hashtable<String, Integer> stringTable;

    public ProfileDB(){
        profiles = new Hashtable<Integer, Profile>();
        stringTable = new Hashtable<String, Integer>();
    }

    public Profile search(Integer id){
        return profiles.get(id);
    }
    
    public Profile search(String name){
        return profiles.get(stringTable.get(name));
    }
    
    public void add(Profile prof){
        profiles.put(prof.getId(), prof);
        stringTable.put(prof.getName(), prof.getId());
    }

    public void remove(Integer id){
        String profileName = profiles.remove(id).getName();
        stringTable.remove(profileName);
    }
    public void remove(String profileName){
        profiles.remove(stringTable.get(profileName));
        stringTable.remove(profileName);
    }
    
    public Hashtable export(){
        return profiles;
    }
    
    public void viewProfile() {
        System.out.println("View Profile is not implemented yet");
    }

    public void manageProfile() {
        System.out.println("Manage Profile is not implemented yet");
    }
  
  
      public void viewProfile() {
        Scanner input = new Scanner(System.in);
        Profile temp = null;
        String name = "";
        int id = 0;
        int option = 0;

       

        while (temp == null) {

            //prompt user for target course
            System.out.print("Enter a name or number: ");

            //search by course ID#
            if (!input.hasNextInt()) {
                name = input.nextLine();
                temp = search(name);

                //if target course does not exist, alert user
                if (temp == null) {
                    System.out.println("Profile not found.");
                    System.out.println("1) Search Again");
                    System.out.println("2) Exit");

                    while (!input.hasNextInt()) {
                        System.out.print("Please enter a number: ");
                        input.next();
                    }
                    option = input.nextInt();

                    //handle invalid user input
                    while (option != 1 && option != 2) {
                        System.out.println("Invalid command please enter 1 or 2: ");
                        option = input.nextInt();
                    }
                    if(option == 2) break;
                }
            }

            //search by course name
            else {
                id = input.nextInt();
                temp = search(id);

                //if target course does not exist, alert user
                if (temp == null) {
                    System.out.println("Profile not found.");
                    System.out.println("1) Search Again");
                    System.out.println("2) Exit");

                    while (!input.hasNextInt()) {
                        System.out.print("Please enter a number: ");
                        input.next();
                    }
                    option = input.nextInt();

                    //handle invalid user input
                    while (option != 1 && option != 2) {
                        System.out.println("Invalid command please enter 1 or 2: ");
                        option = input.nextInt();
                    }
                    if(option == 2) break;
                }
            }
        }

        //once target course is found, display relevant info
        if (temp != null) {
            System.out.println(temp.toString());
        }
    }
  
   public void importData(String filename) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(filename));
            String line;
            String[] parsedData;
            String[] subset;
            Profile temp;

            //Skip first line
            input.readLine();
            line = null;

            while ((line=input.readLine())!=null){
                parsedData = line.split(",");
                temp = new Profile();

                temp.setName(parsedData[0]);
                temp.setAge(Integer.parsedData[1]);
                temp.setGender(parsedData[2]);
                temp.setID(Integer.parsedData[3]);
                temp.setEmail(parsedData[4]);
                temp.setDeclaredMajor(parsedData[5]);
                temp.setNumberOfUnits(Integer.parsedData[6]);
                temp.setGpa(Integer.parsedData[7]);
                temp.setTheYearEnrolled(Integer.parsedData[8]);
                temp.setExpectedGraduationYear(Integer.parsedData[9]);

                subset = parsedData[10].split(";");
                temp.setSchedule(new ArrayList<String>(Arrays.asList(subset)));
                subset = parsedData[11].split(";");
                temp.setCurrentEnrolledClasses(new ArrayList<String>(Arrays.asList(subset)));
                subset = parsedData[12].split(";");
                temp.setCompletedClasses(new ArrayList<String>(Arrays.asList(subset)));
                subset = parsedData[13].split(";");
                temp.setAwards(new ArrayList<String>(Arrays.asList(subset)));

                    }
            //alert user of successful file import
            System.out.println("\nSuccessfully imported sampleProfile.csv!");
        }
        //handle nonexistent file/IO error
        catch (IOException e) {
            System.out.println("Error: File Not Found");
        }

     }
  
}
