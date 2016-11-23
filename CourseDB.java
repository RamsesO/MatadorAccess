import java.util.Hashtable;
import java.io.Serializable;
import java.util.Scanner;

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
    
}
