import java.io.*;
import java.util.*;

class CourseDB implements Serializable {
    
    private static final long serialVersionUID = 1902501367567782416L;

    private Hashtable<String, Integer> stringTable;
    private Hashtable<Integer, Course> courses;
    
    public CourseDB() {
        this.stringTable = new Hashtable<String, Integer>();
        this.courses = new Hashtable<Integer, Course>();
    }
    
    public Course search(Integer id) {
        return courses.get(id);
    }
    
    public Course search(String name) {
        return courses.get(stringTable.get(name));
    }
    
    public void add(Course crs) {
        courses.put(crs.getCourseNum(), crs);
        stringTable.put(crs.getName(), crs.getCourseNum());
    }
    
    public void delete(Integer id) {
        stringTable.remove(courses.get(id).getCourseNum());
        courses.remove(id);
    }
    
    public void delete(String name) {
        courses.remove(stringTable.get(name));
        stringTable.remove(name);
    }
    
    public Hashtable<Integer, Course> export() {
        return courses;
    }
    
    public void viewCourseStatistics() {
        Scanner input = new Scanner(System.in);
        Course temp = null;
        String name = "";
        int id = 0;
        int option = 0;
        
        while (temp == null) {
            System.out.print("Enter a name or number: ");
            if (!input.hasNextInt()) {
                name = input.nextLine();
                temp = search(name);
                
                if (temp == null) {
                    System.out.println("Course not found.");
                    System.out.println("1) Search Again");
                    System.out.println("2) Exit");
                    
                    while (!input.hasNextInt()) {
                        System.out.print("Please enter a number: ");
                        input.next();
                    }
                    option = input.nextInt();
                    
                    while (option != 1 && option != 2) {
                        System.out.println("Invalid command please enter 1 or 2: ");
                        option = input.nextInt();
                    }
                    if(option == 2) break;
                }
            }
            else {
                id = input.nextInt();
                temp = search(id);
                
                if (temp == null) {
                    System.out.println("Course not found.");
                    System.out.println("1) Search Again");
                    System.out.println("2) Exit");
                    
                    while (!input.hasNextInt()) {
                        System.out.print("Please enter a number: ");
                        input.next();
                    }
                    option = input.nextInt();
                    
                    while (option != 1 && option != 2) {
                        System.out.println("Invalid command please enter 1 or 2: ");
                        option = input.nextInt();
                    }
                    if(option == 2) break;
                }
            }
        }
        if (temp != null) {
            System.out.println(temp.toString());
        }
    }

    public void manageCourse() {
        System.out.println("Manage Course is not implemented yet");
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
            
            while((line = input.readLine()) != null) {
                parsedData = line.split(",");
                temp = new Course();
                
                temp.setName(parsedData[0]);
                temp.setDepartment(parsedData[1]);
                
                temp.setCourseNum(Integer.parseInt(parsedData[2]));
                temp.setUnits(Integer.parseInt(parsedData[3]));
                temp.setPriority(Integer.parseInt(parsedData[4]));
                
                subset = parsedData[5].split(";");
                temp.setPrerequisites(new ArrayList<String>(Arrays.asList(subset)));
                subset = parsedData[6].split(";");
                temp.setCorequistes(new ArrayList<String>(Arrays.asList(subset)));
                
                temp.setAvgCourseSize(Integer.parseInt(parsedData[7]));
                temp.setAvgSections(Integer.parseInt(parsedData[8]));
                temp.setAvgNumSWL(Integer.parseInt(parsedData[9]));
                
                temp.setAvgPassRate(Double.parseDouble(parsedData[10]));
                temp.setAvgGrade(Double.parseDouble(parsedData[11]));
                temp.setDiffRating(Double.parseDouble(parsedData[12]));
                temp.setGenRatioF(Double.parseDouble(parsedData[13]));
                temp.setGenRatioM(Double.parseDouble(parsedData[14]));
                temp.setAvgGPA(Double.parseDouble(parsedData[15]));
                
                subset = parsedData[16].split(";");
                temp.setInstructors(new ArrayList<String>(Arrays.asList(subset)));
                subset = parsedData[17].split(";");
                temp.setConcepts(new ArrayList<String>(Arrays.asList(subset)));
                subset = parsedData[18].split(";");
                temp.setBooks(new ArrayList<String>(Arrays.asList(subset)));
                
                add(temp);
            }
        } 
        catch (IOException e) {
            System.out.println("Error: File Not Found");
        }
    }
    
}
