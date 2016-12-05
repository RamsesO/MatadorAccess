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
  
   public void importData(String filename) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(filename));
            String line;
            String[] parsedData;
            String[] subset;
            Course temp;

            //Skip first line
            input.readLine();
            line = null;

            while ((line=input.readLine())!=null){
                parsedData = line.split(",");
                temp = new Profile();

                tmep.setName(parsedData[0]);
                tmep.setAge(Integer.parsedData[1]);
                tmep.setGender(parsedData[2]);
                tmep.setID(Integer.parsedData[3]);
                tmep.setEmail(parsedData[4]);
                tmep.setDeclaredMajor(parsedData[5]);
                tmep.setNumberOfUnits(Integer.parsedData[6]);
                tmep.setGpa(Integer.parsedData[7]);
                tmep.setTheYearEnrolled(Integer.parsedData[8]);
                tmep.setExpectedGraduationYear(Integer.parsedData[9]);

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
