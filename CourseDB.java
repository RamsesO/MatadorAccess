/*----------------------------------------------------------------------------
Module Name: CourseDB (Course Database Object w/ associated functions)
Inputs: Course objects, Assorted variable types representing course attributes
Outputs: Course objects, Hashtables containing Course objects
Submodules: createCourse(), modifyCourse(), deleteCourse(),
            viewCourseStatistics(), importData()

Author: Ryan Vitacion
Date: 11/23/16

Reviewer: Ryan Vitacion
Date: 12/04/16

- Revision History -

Programmer: Ryan Vitacion
Date: 12/04/16
Description of Changes: code formatting/comments
Reviewer: Ryan Vitacion
Date of Review: 12/04/16

Programmer: Ryan Vitacion
Date: 12/04/16
Description of Changes: Add exception handling to delete/modify course
Reviewer: Ryan Vitacion
Date of Review: 12/04/16

Programmer: Ryan Vitacion
Date: 11/30/16
Description of Changes: Add list of courses to viewCourseStatistics()
Reviewer: Ryan Vitacion
Date of Review: 11/30/16

Programmer: Ramses Ordonez
Date: 11/27/16
Description of Changes: Fix course search by name
Reviewer: Ramses Ordonez
Date of Review: 11/27/16

Programmer: Ryan Vitacion
Date: 11/24/16
Description of Changes: Implement create/modify/delete course
Reviewer: Ryan Vitacion
Date of Review: 11/24/16

Programmer: Lemuel Dizon
Date: 11/23/16
Description of Changes: Implement viewCourseStatistics() and importData()
Reviewer: Lemuel Dizon
Date of Review: 11/23/16

Programmer: Ryan Vitacion
Date: 11/21/16
Description of Changes: Add support for serialization
Reviewer: Ryan Vitacion
Date of Review: 11/21/16
----------------------------------------------------------------------------*/

import java.util.*;
import java.io.*;

class CourseDB implements Serializable{

    private static final long serialVersionUID = 1902501367567782416L;
    
    //hashtables to store courses with both integer and string keys
    private Hashtable<String, Integer> stringTable;
    private Hashtable<Integer, Course> courses;

    //constructor
    public CourseDB() {
        this.stringTable = new Hashtable<String, Integer>();
        this.courses = new Hashtable<Integer, Course>();
    }

    //search by course ID#
    public Course search(Integer id) {
        return courses.get(id);
    }
    
    //search by course name
    public Course search(String name) {
        if(stringTable.get(name) == null){
            return null;
        }
        return courses.get(stringTable.get(name));
    }

    //add course object to database
    public void add(Course crs) {
        courses.put(crs.getCourseNum(), crs);
        stringTable.put(crs.getName(), crs.getCourseNum());
    }

    //delete course object from database by ID#
    public void delete(Integer id) {
        stringTable.remove(courses.get(id).getCourseNum());
        courses.remove(id);
    }

    //delete course object from database by name
    public void delete(String name) {
        courses.remove(stringTable.get(name));
        stringTable.remove(name);
    }

    //export hashtable containing stored courses
    public Hashtable<Integer, Course> export() {
        return courses;
    }

    //course management menu
    public void manageCourse() {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        while(choice != 5) {
            System.out.println("\n- Course Management");
            System.out.println("1) Create Course");
            System.out.println("2) Modify Course");
            System.out.println("3) Delete Course");
            System.out.println("4) Import sample CSV file");
            System.out.println("5) Return to previous menu");
            System.out.print("Please select an action: ");
            choice = input.nextInt();
            input.nextLine();
            switch(choice) {

            case 1:
                createCourse();
                break;

            case 2:
                modifyCourse();
                break;

            case 3:
                deleteCourse();
                break;
                
            case 4:
                importData("sampleCourses.csv");
                break;

            case 5:
                break;

            default:
                System.out.println("Invalid selection!");
                break;
            }
        }
    }

    //course creation function
    public void createCourse() {

        try {
            Scanner input = new Scanner(System.in);

            Course newcrs = new Course();
            
            //prompt user to enter each attribute of the new course
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

            //Prompt user for each list attribute of the new course
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

            //push new course into database and alert user of success
            this.add(newcrs);
            System.out.println("\nNew course succesfully registered!");
        }
        
        //handle invalid user input
        catch (Exception e) {
            System.out.println("\nInvalid input!  Please try again...");
        }

    }

    //course modification function
    public void modifyCourse() {

        try {
            
            Scanner input = new Scanner(System.in);
            
            //display a list of all existing courses in the database
            System.out.println("\nCurrently Registered Courses:\n");
            Enumeration<Course> e = courses.elements();
            while (e.hasMoreElements()) {
                Course next = e.nextElement();
                System.out.println(next.getCourseNum() + ": " + next.getName());
            }
            
            //prompt user to enter the target course ID#
            System.out.print("\n- Please enter the ID# of the course you wish to modify: ");
            int target = input.nextInt();
            input.nextLine();
            
            //return to previous menu if target course does not exist
            if(!courses.containsKey(target)) {
                System.out.println("\nNo such course with given ID# exists!  Please try again.");
                return;
            }
            
            //display menu of modifiable course attributes
            int choice = -1;
            int next;
            while(choice != 0) {
                
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
                System.out.print("\n- Please select an attribute to modify (Enter 0 to quit): ");
                
                choice = input.nextInt();
                input.nextLine();
                
                //for each selection, prompt user to enter new value and apply changes
                switch(choice) {

                //cases 1-12: single-element attributes
                case 1:
                    System.out.print("\nName: ");
                    courses.get(target).setName(input.nextLine());
                    System.out.println("\nAttribute has been successfully modified!");
                    break;

                case 2:
                    System.out.print("\nDepartment: ");
                    courses.get(target).setDepartment(input.nextLine());
                    System.out.println("\nAttribute has been successfully modified!");
                    break;

                case 3:
                    System.out.print("\nCourse ID#: ");
                    courses.get(target).setCourseNum(input.nextInt());
                    input.nextLine();
                    System.out.println("\nAttribute has been successfully modified!");
                    break;

                case 4:
                    System.out.print("\n# of Units: ");
                    courses.get(target).setUnits(input.nextInt());
                    input.nextLine();
                    System.out.println("\nAttribute has been successfully modified!");
                    break;

                case 5:
                    System.out.print("\nPriority: ");
                    courses.get(target).setPriority(input.nextInt());
                    input.nextLine();
                    System.out.println("\nAttribute has been successfully modified!");
                    break;

                case 6:
                    System.out.print("\nAverage Students/Course: ");
                    courses.get(target).setAvgCourseSize(input.nextInt());
                    input.nextLine();
                    System.out.println("\nAttribute has been successfully modified!");
                    break;

                case 7:
                    System.out.print("\nAverage # of Sections: ");
                    courses.get(target).setAvgSections(input.nextInt());
                    input.nextLine();
                    System.out.println("\nAttribute has been successfully modified!");
                    break;

                case 8:
                    System.out.print("Average # of Students in Waitlist: ");
                    courses.get(target).setAvgNumSWL(input.nextInt());
                    input.nextLine();
                    System.out.println("\nAttribute has been successfully modified!");
                    break;

                case 9:
                    System.out.print("\nAverage Pass Rate: ");
                    courses.get(target).setAvgPassRate(input.nextDouble());
                    input.nextLine();
                    System.out.println("\nAttribute has been successfully modified!");
                    break;

                case 10:
                    System.out.print("\nDifficulty Rating: ");
                    courses.get(target).setDiffRating(input.nextDouble());
                    input.nextLine();
                    System.out.println("\nAttribute has been successfully modified!");
                    break;

                case 11:
                    System.out.print("\nMale to Female Gender Ratio: ");
                    courses.get(target).setGenRatioM(input.nextDouble());
                    courses.get(target).setGenRatioF(1.0-courses.get(target).getGenRatioM());
                    input.nextLine();
                    System.out.println("\nAttribute has been successfully modified!");
                    break;

                case 12:
                    System.out.print("\nAverage GPA: ");
                    courses.get(target).setAvgGPA(input.nextDouble());
                    input.nextLine();
                    System.out.println("\nAttribute has been successfully modified!");
                    break;

                //cases 13-17: list attributes
                case 13:
                    System.out.println("\nPlease re-enter all prerequisites for this course:");
                    courses.get(target).getPrerequisites().clear();
                    next = 1;
                    while(next == 1) {
                        System.out.printf("\nName of Prerequisite: ");
                        courses.get(target).getPrerequisites().add(input.nextLine());
                        System.out.printf("Enter another prerequisite? (1=Yes 2=No): ");
                        next = input.nextInt();
                        input.nextLine();
                    }
                    System.out.println("\nAttribute has been successfully modified!");
                    break;

                case 14:
                    System.out.println("\nPlease re-enter all corequisites for this course:");
                    courses.get(target).getCorequisites().clear();
                    next = 1;
                    while(next == 1) {
                        System.out.printf("\nName of Corequisite: ");
                        courses.get(target).getCorequisites().add(input.nextLine());
                        System.out.printf("Enter another corequisite? (1=Yes 2=No): ");
                        next = input.nextInt();
                        input.nextLine();
                    }
                    System.out.println("\nAttribute has been successfully modified!");
                    break;

                case 15:
                    System.out.println("\nPlease re-enter all instructors for this course:");
                    courses.get(target).getInstructors().clear();
                    next = 1;
                    while(next == 1) {
                        System.out.printf("\nName of Instructor: ");
                        courses.get(target).getInstructors().add(input.nextLine());
                        System.out.printf("Enter another instructor? (1=Yes 2=No): ");
                        next = input.nextInt();
                        input.nextLine();
                    }
                    System.out.println("\nAttribute has been successfully modified!");
                    break;

                case 16:
                    System.out.println("\nPlease re-enter all concepts for this course:");
                    courses.get(target).getConcepts().clear();
                    next = 1;
                    while(next == 1) {
                        System.out.printf("\nName of concept: ");
                        courses.get(target).getConcepts().add(input.nextLine());
                        System.out.printf("Enter another Concept? (1=Yes 2=No): ");
                        next = input.nextInt();
                        input.nextLine();
                    }
                    System.out.println("\nAttribute has been successfully modified!");
                    break;

                case 17:
                    System.out.println("\nPlease re-enter all textbooks for this course:");
                    courses.get(target).getBooks().clear();
                    next = 1;
                    while(next == 1) {
                        System.out.printf("\nName of Textbook: ");
                        courses.get(target).getBooks().add(input.nextLine());
                        System.out.printf("Enter another textbook? (1=Yes 2=No): ");
                        next = input.nextInt();
                        input.nextLine();
                    }
                    System.out.println("\nAttribute has been successfully modified!");
                    break;
                }
            }
            
        }
        
        //handle invalid user input
        catch (InputMismatchException e) {
            System.out.println("\nInvalid input!  Please try again...");
        }
    }

    public void deleteCourse() {
        
        try {
            
            //check if database is empty, alert user
            if(courses.isEmpty()) System.out.println("\nNo courses to delete!");
            else {
                
                Scanner input = new Scanner(System.in);
                
                //display list of existing courses in database
                System.out.println("\nCurrently Registered Courses:\n");
                Enumeration<Course> e = courses.elements();
                while (e.hasMoreElements()) {
                    Course next = e.nextElement();
                    System.out.println(next.getCourseNum() + ": " + next.getName());
                }
                
                //prompt user for target course
                System.out.print("\n- Please enter the ID# of the course you wish to delete: ");
                int target = input.nextInt();
                input.nextLine();
                
                //if target course does not exist, alert user and return to previous menu
                if(!courses.containsKey(target)) {
                    System.out.println("\nNo such course with given ID# exists!  Please try again.");
                    return;
                }
                
                //prompt user to confirm course deletion
                System.out.printf("\nAre you sure you want to delete course %d? (1=Yes 0=No): ", target);
                if(input.nextInt() != 1) {
                    System.out.println("\nCourse was not deleted.");
                    return;
                }
                input.nextLine();
                
                //delete target course and alert user of success
                this.delete(target);
                System.out.printf("\nCourse #%d has been successfully deleted.\n", target);
            }
            
        }
        
        //handle invalid user input
        catch (InputMismatchException e) {
            System.out.println("\nInvalid input! Please try again...");
        }
    }

    //view course statistics function
    public void viewCourseStatistics() {
        Scanner input = new Scanner(System.in);
        Course temp = null;
        String name = "";
        int id = 0;
        int option = 0;

        //display list of existing courses in database
        System.out.println("\nCurrently Registered Courses:\n");
        Enumeration<Course> e = courses.elements();
        while (e.hasMoreElements()) {
            Course next = e.nextElement();
            System.out.println(next.getCourseNum() + ": " + next.getName());
        }
        System.out.println();
        
        while (temp == null) {
            
            //prompt user for target course
            System.out.print("Enter a name or number: ");
            
            //search by course ID#
            if (!input.hasNextInt()) {
                name = input.nextLine();
                temp = search(name);

                //if target course does not exist, alert user
                if (temp == null) {
                    System.out.println("Course not found.");
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
                    System.out.println("Course not found.");
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

    //.csv file import function
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

            //read each line of .csv file and enter contents into new course
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
                temp.setCorequisites(new ArrayList<String>(Arrays.asList(subset)));

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

                //add new course to database
                add(temp);
            }
            //alert user of successful file import
            System.out.println("\nSuccessfully imported sampleCourses.csv!");
        }
        //handle nonexistent file/IO error
        catch (IOException e) {
            System.out.println("Error: File Not Found");
        }
    }
}
