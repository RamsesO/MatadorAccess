import java.util.*;
import java.io.*;

class MajorDB implements Serializable{

    private static final long serialVersionUID = 9184085222891215235L;
    
    private Hashtable<String, Integer> stringTable;
    private Hashtable<Integer, Major> majors;
    
    public MajorDB() {
        this.stringTable = new Hashtable<String, Integer>();
        this.majors = new Hashtable<Integer, Major>();
    }
    
    public Major search(Integer id) {
        return majors.get(id);
    }
    
    public Major search(String name) {
        return majors.get(stringTable.get(name));
    }
    
    public void add(Major mjr) {
        majors.put(mjr.getMajorId(), mjr);
        stringTable.put(mjr.getMajorName(), mjr.getMajorId());
    }
    
    public void delete(Integer id) {
        stringTable.remove(majors.get(id).getMajorId());
        majors.remove(id);
    }
    
    public void delete(String name) {
        majors.remove(stringTable.get(name));
        stringTable.remove(name);
    }
    
    public Hashtable<Integer, Major> export() {
        return majors;
    }
	
    public void viewMajorInformation() {
    	Scanner input = new Scanner(System.in);
    	Major temp = null;
    	String name = "";
    	int id = 0;
    	int option = 0;
    	
        System.out.println("\nCurrently Registered Majors:\n");
        Enumeration<Major> e = majors.elements();
        while (e.hasMoreElements()) {
            Major next = e.nextElement();
            System.out.println(next.getMajorId() + ": " + next.getMajorName());
        }
        System.out.println();
    	
    	while(temp == null) {
    		System.out.print("Enter a name or number: ");
    		if(!input.hasNextInt()) {
    			name = input.nextLine();
    			temp = search(name);
    			if(temp == null) {
    				System.out.println("Major not found");
    				System.out.println("1) Search again");
    				System.out.println("2) Exit");
    				
    				while(!input.hasNextInt()) {
    					System.out.print("Please enter a number: ");
    					input.next();
    				}
    				option = input.nextInt();
    				
    				while(option != 1 && option != 2) {
    					System.out.println("Invalid command please enter 1 or 2: ");
    					option = input.nextInt();
    				}
    				if(option == 2) break;
    			}
    		}
    		else {
    			id = input.nextInt();
    			temp = search(id);
    			
    			if(temp == null) {
    				System.out.println("Major not found");
    				System.out.println("1) Search again");
    				System.out.println("2) Exit");
    				
    				while(!input.hasNextInt()) {
    					System.out.print("Please enter a number: ");
    					input.next();
    				}
    				option = input.nextInt();
    				
    				while(option != 1 && option != 2) {
    					System.out.println("Invalid command please enter 1 or 2: ");
    					option = input.nextInt();
    				}
    				if(option == 2) break;
    			}
    		}
    	}
    	if(temp != null) {
    		System.out.println("\n"+temp.toString());
    	}
        
    }
    
    public void manageMajor() {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        while(choice != 2) {
            System.out.println("\n- Major Management");
            System.out.println("1) Import sample CSV file");
            System.out.println("2) Return to previous menu");
            System.out.print("Please select an action: ");
            choice = input.nextInt();
            input.nextLine();
            switch(choice) {

                case 1:
                    this.importData("sampleMajors.csv");
                    break;

                case 2:
                    break;
    
                default:
                    System.out.println("Invalid selection!");
                    break;
            }
        }
    }
    
    public void importData(String filename) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(filename));
            String line;
            String[] parsedData;
            String[] subset;
            Major temp;
            
            //Skip first line
            input.readLine();
            line = null;
            
            while((line = input.readLine()) != null) {
                parsedData = line.split(",");
                temp = new Major();
                
                temp.setMajorId(Integer.parseInt(parsedData[0]));
                
                temp.setAverageTime(Integer.parseInt(parsedData[1]));
                temp.setAverageSalary(Integer.parseInt(parsedData[2]));
                temp.setNumberOfStudents(Integer.parseInt(parsedData[3]));
                temp.setMaleStudents(Integer.parseInt(parsedData[4]));
                temp.setFemaleStudents(Integer.parseInt(parsedData[5]));
                temp.setDifficultyRating(Double.parseDouble(parsedData[6]));
                temp.setMajorName(parsedData[7]);
                int numberOfMales = Integer.parseInt(parsedData[4]);
                int numberOfFemales = Integer.parseInt(parsedData[5]);
                temp.setGenderRatio(numberOfMales, numberOfFemales);
                temp.setDescription(parsedData[8]);
                subset = parsedData[9].split(";");
                temp.setRelatedJobs(new ArrayList<String>(Arrays.asList(subset)));
                subset = parsedData[10].split(";");
                temp.setCourses(new ArrayList<String>(Arrays.asList(subset)));
                
                this.add(temp);
                System.out.println("\nSuccessfully imported sampleMajors.csv!");
            }
        } 
        catch (IOException e) {
            System.out.println("Error: File Not Found");
        }
    }
    
    
}
