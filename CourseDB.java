import java.util.Hashtable;
import java.util.Enumeration;
import java.util.Scanner;
import java.io.Serializable;

class CourseDB implements Serializable{
    
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
    
    public void createCourse() {
        
        Scanner input = new Scanner(System.in);
        
        Course newcrs = new Course();
        
        System.out.println("\nPlease enter the following parameters of the new course:\n");
        
        System.out.printf("Name: ");
        newcrs.setName(input.nextLine());
        
        System.out.printf("Department: ");
        newcrs.setDepartment(input.nextLine());
        
        System.out.printf("Course ID#: ");
        newcrs.setCourseNum(input.nextInt());
        
        System.out.printf("# of Units: ");
        newcrs.setUnits(input.nextInt());
        
        System.out.printf("Priority: ");
        newcrs.setPriority(input.nextInt());
        
        System.out.printf("Average Students/Course: ");
        newcrs.setAvgCourseSize(input.nextInt());
        
        System.out.printf("Average # of Sections: ");
        newcrs.setAvgSections(input.nextInt());
        
        System.out.printf("Average # of Students in Waitlist: ");
        newcrs.setAvgNumSWL(input.nextInt());
        
        System.out.printf("Average Pass Rate: ");
        newcrs.setAvgPassRate(input.nextDouble());
        
        System.out.printf("Difficulty Rating: ");
        newcrs.setDiffRating(input.nextDouble());
        
        System.out.printf("Male to Female Gender Ratio: ");
        newcrs.setGenRatioM(input.nextDouble());
        newcrs.setGenRatioF(1.0-(newcrs.getGenRatioM()));
        
        System.out.printf("Average GPA: ");
        newcrs.setAvgGPA(input.nextDouble());
        
        System.out.println("\n- Please enter the prerequisites for this course:");
        int next = 1;
        input.nextLine();
        while(next == 1) {
            System.out.printf("\nName of Prerequisite: ");
            newcrs.getPrerequisites().add(input.nextLine());
            System.out.printf("Enter another prerequisite? (1=Yes 2=No): ");
            next = input.nextInt();
            input.nextLine();
        }
        
        next = 1;
        System.out.println("\n- Please enter the corequisites for this course:");
        while(next == 1) {
            System.out.printf("\nName of Corequisite: ");
            newcrs.getCorequisites().add(input.nextLine());
            System.out.printf("Enter another corequisite? (1=Yes 2=No): ");
            next = input.nextInt();
            input.nextLine();
        }
        
        next = 1;
        System.out.println("\n- Please enter the instructors who teach this course:");
        while(next == 1) {
            System.out.printf("\nName of Instructor: ");
            newcrs.getInstructors().add(input.nextLine());
            System.out.printf("Enter another instructor? (1=Yes 2=No): ");
            next = input.nextInt();
            input.nextLine();
        }
        
        next = 1;
        System.out.println("\n- Please enter the concepts taught in this course:");
        while(next == 1) {
            System.out.printf("\nName of Concept: ");
            newcrs.getConcepts().add(input.nextLine());
            System.out.printf("Enter another concept? (1=Yes 2=No): ");
            next = input.nextInt();
            input.nextLine();
        }
        
        next = 1;
        System.out.println("\n- Please enter the textbooks used in this course:");
        while(next == 1) {
            System.out.printf("\nName of Textbook: ");
            newcrs.getBooks().add(input.nextLine());
            System.out.printf("Enter another textbook? (1=Yes 2=No): ");
            next = input.nextInt();
            input.nextLine();
        }
        
        this.add(newcrs);
        System.out.println("\nNew course succesfully registered!");
        
    }
    
    public void modifyCourse() {
        
        Scanner input = new Scanner(System.in);
        System.out.println("\nCurrently Registered Courses:\n");
        Enumeration<Course> e = courses.elements();
        while (e.hasMoreElements()) {
            Course next = e.nextElement();
            System.out.println(next.getCourseNum() + ": " + next.getName());
        }
        System.out.print("\n- Please enter the ID# of the course you wish to modify: ");
        int target = input.nextInt();
        input.nextLine();
        
        System.out.println("\n 1: Name");
        System.out.println(" 2: Department");
        System.out.println(" 3: Course ID#");
        System.out.println(" 4: # of Units");
        System.out.println(" 5: Priority");
        System.out.println(" 6: Average Students/Course");
        System.out.println(" 7: Average # of Sections");
        System.out.println(" 8: Average # of Students in Waitlist");
        System.out.println(" 9: Average Pass Rate");
        System.out.println("10: Difficulty Rating");
        System.out.println("11: Male to Female Gender Ratio");
        System.out.println("12: Average GPA");
        System.out.println("13: Prerequisites");
        System.out.println("14: Corequisites");
        System.out.println("15: Instructors");
        System.out.println("16: Concepts");
        System.out.println("17: Textbooks");
        
        int choice = -1;
        int next;
        while(choice != 0) {
            System.out.print("\n- Please select an attribute to modify (Enter 0 to quit): ");
            choice = input.nextInt();
            input.nextLine();
            switch(choice) {
        
            case 1:
                System.out.print("\nName: ");
                courses.get(target).setName(input.nextLine());
                System.out.println("\nAttribute has been successfully modified!\n");
                break;
            
            case 2:
                System.out.print("\nDepartment: ");
                courses.get(target).setDepartment(input.nextLine());
                System.out.println("\nAttribute has been successfully modified!\n");
                break;
            
            case 3:
                System.out.print("\nCourse ID#: ");
                courses.get(target).setCourseNum(input.nextInt());
                input.nextLine();
                System.out.println("\nAttribute has been successfully modified!\n");
                break;
            
            case 4:
                System.out.print("\n# of Units: ");
                courses.get(target).setUnits(input.nextInt());
                input.nextLine();
                System.out.println("\nAttribute has been successfully modified!\n");
                break;
                
            case 5:
                System.out.print("\nPriority: ");
                courses.get(target).setPriority(input.nextInt());
                input.nextLine();
                System.out.println("\nAttribute has been successfully modified!\n");
                break;
            
            case 6:
                System.out.print("\nAverage Students/Course: ");
                courses.get(target).setAvgCourseSize(input.nextInt());
                input.nextLine();
                System.out.println("\nAttribute has been successfully modified!\n");
                break;
                
            case 7:
                System.out.print("\nAverage # of Sections: ");
                courses.get(target).setAvgSections(input.nextInt());
                input.nextLine();
                System.out.println("\nAttribute has been successfully modified!\n");
                break;
                
            case 8:
                System.out.print("Average # of Students in Waitlist: ");
                courses.get(target).setAvgNumSWL(input.nextInt());
                input.nextLine();
                System.out.println("\nAttribute has been successfully modified!\n");
                break;
                
            case 9:
                System.out.print("\nAverage Pass Rate: ");
                courses.get(target).setAvgPassRate(input.nextDouble());
                input.nextLine();
                System.out.println("\nAttribute has been successfully modified!\n");
                break;
                
            case 10:
                System.out.print("\nDifficulty Rating: ");
                courses.get(target).setDiffRating(input.nextDouble());
                input.nextLine();
                System.out.println("\nAttribute has been successfully modified!\n");
                break;
                
            case 11:
                System.out.print("\nMale to Female Gender Ratio: ");
                courses.get(target).setGenRatioM(input.nextDouble());
                courses.get(target).setGenRatioF(1.0-courses.get(target).getGenRatioM());
                input.nextLine();
                System.out.println("\nAttribute has been successfully modified!\n");
                break;
                
            case 12:
                System.out.print("\nAverage GPA: ");
                courses.get(target).setAvgGPA(input.nextDouble());
                input.nextLine();
                System.out.println("\nAttribute has been successfully modified!\n");
                break;
                
            case 13:
                System.out.println("\nPlease re-enter all prerequisites for this course:");
                courses.get(target).getPrerequisites().clear();
                next = 1;
                input.nextLine();
                while(next == 1) {
                    System.out.printf("\nName of Prerequisite: ");
                    courses.get(target).getPrerequisites().add(input.nextLine());
                    System.out.printf("Enter another prerequisite? (1=Yes 2=No): ");
                    next = input.nextInt();
                    input.nextLine();
                }
                System.out.println("\nAttribute has been successfully modified!\n");
                break;
               
            case 14:
                System.out.println("\nPlease re-enter all corequisites for this course:");
                courses.get(target).getCorequisites().clear();
                next = 1;
                input.nextLine();
                while(next == 1) {
                    System.out.printf("\nName of Corequisite: ");
                    courses.get(target).getCorequisites().add(input.nextLine());
                    System.out.printf("Enter another corequisite? (1=Yes 2=No): ");
                    next = input.nextInt();
                    input.nextLine();
                }
                System.out.println("\nAttribute has been successfully modified!\n");
                break;
                
            case 15:
                System.out.println("\nPlease re-enter all instructors for this course:");
                courses.get(target).getInstructors().clear();
                next = 1;
                input.nextLine();
                while(next == 1) {
                    System.out.printf("\nName of Instructor: ");
                    courses.get(target).getInstructors().add(input.nextLine());
                    System.out.printf("Enter another instructor? (1=Yes 2=No): ");
                    next = input.nextInt();
                    input.nextLine();
                }
                System.out.println("\nAttribute has been successfully modified!\n");
                break;
                
            case 16:
                System.out.println("\nPlease re-enter all concepts for this course:");
                courses.get(target).getConcepts().clear();
                next = 1;
                input.nextLine();
                while(next == 1) {
                    System.out.printf("\nName of concept: ");
                    courses.get(target).getConcepts().add(input.nextLine());
                    System.out.printf("Enter another Concept? (1=Yes 2=No): ");
                    next = input.nextInt();
                    input.nextLine();
                }
                System.out.println("\nAttribute has been successfully modified!\n");
                break;
                
            case 17:
                System.out.println("\nPlease re-enter all textbooks for this course:");
                courses.get(target).getBooks().clear();
                next = 1;
                input.nextLine();
                while(next == 1) {
                    System.out.printf("\nName of Textbook: ");
                    courses.get(target).getBooks().add(input.nextLine());
                    System.out.printf("Enter another textbook? (1=Yes 2=No): ");
                    next = input.nextInt();
                    input.nextLine();
                }
                System.out.println("\nAttribute has been successfully modified!\n");
                break;
            }
        }
    }
    
    public void deleteCourse() {
        if(courses.isEmpty()) System.out.println("\nNo courses to delete!");
        else {
            Scanner input = new Scanner(System.in);
            System.out.println("\nCurrently Registered Courses:\n");
            Enumeration<Course> e = courses.elements();
            while (e.hasMoreElements()) {
                Course next = e.nextElement();
                System.out.println(next.getCourseNum() + ": " + next.getName());
            }
            System.out.print("\n- Please enter the ID# of the course you wish to delete: ");
            int target = input.nextInt();
            input.nextLine();
            this.delete(target);
            System.out.printf("\nCourse #%d has been successfully deleted.\n", target);
        }
    }
}
