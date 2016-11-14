//Created by: Lemuel Dizon

import java.util.*;

public class Course {
    
    //Main Stuff
    private String name;
    private String department;
    private int courseNum;
    private int units;
    private int priority;
    private ArrayList<Course> prerequisites;
    private ArrayList<Course> corequistes;
    
    //Statistical Stuff
    private int avgCourseSize; 
    private int avgSections;
    private int avgNumSWL;
    private double avgPassRate;
    private double avgGrade;
    private double diffRating;
    private double genRatioF;
    private double genRatioM;
    private double avgGPA;
    private ArrayList<String> instructors;
    private ArrayList<String> concepts;
    private ArrayList<String> books;
    
    //Constructor for an empty course
    public Course() {
        //Main Stuff
        this.name = "";
        this.department = "";
        this.courseNum = 0;
        this.units = 0;
        this.priority = 0;
        this.prerequisites = null;
        this.corequistes = null;
        
        //Statistical Stuff
        this.avgCourseSize = 0;
        this.avgSections = 0;
        this.avgNumSWL = 0;
        this.avgPassRate = 0.0;
        this.avgGrade = 0.0;
        this.diffRating = 0.0;
        this.genRatioF = 0.0;
        this.genRatioM = 0.0;
        this.avgGPA = 0.0;
        this.instructors = null;
        this.concepts = null;
        this.books = null;
    }
    
    //Constructor with Important stuff as input
    public Course(String name, String department, int courseNum, int units, 
            int priority, ArrayList<Course> prerequisites, ArrayList<Course> corequistes) {
        //Main Stuff
        this.name = name;
        this.department = department;
        this.courseNum = courseNum;
        this.units = units;
        this.priority = priority;
        this.prerequisites = prerequisites;
        this.corequistes = corequistes;
        
        //Statistical Stuff
        this.avgCourseSize = 0;
        this.avgSections = 0;
        this.avgNumSWL = 0;
        this.avgPassRate = 0.0;
        this.avgGrade = 0.0;
        this.diffRating = 0.0;
        this.genRatioF = 0.0;
        this.genRatioM = 0.0;
        this.avgGPA = 0.0;
        this.instructors = null;
        this.concepts = null;
        this.books = null;
    }
    
    //Constructor with everything as an input
    public Course(String name, String department, int courseNum, int units,
            int priority, ArrayList<Course> prerequisites, ArrayList<Course> corequistes,
            int avgCourseSize, int avgSections, int avgNumSWL, double avgPassRate,
            double avgGrade, double diffRating, double genRatioF, double avgGPA,
            ArrayList<String> instructors, ArrayList<String> concepts, ArrayList<String> books) {
        
        //Main Stuff
        this.name = name;
        this.department = department;
        this.courseNum = courseNum;
        this.units = units;
        this.priority = priority;
        this.prerequisites = prerequisites;
        this.corequistes = corequistes;
        
        //Statistical Stuff
        this.avgCourseSize = avgCourseSize;
        this.avgSections = avgSections;
        this.avgNumSWL = avgNumSWL;
        this.avgPassRate = avgPassRate;
        this.avgGrade = avgGrade;
        this.diffRating = diffRating;
        this.genRatioF = genRatioF;
        this.genRatioM = 1.0 - genRatioF;
        this.avgGPA = avgGPA;
        this.instructors = instructors;
        this.concepts = concepts;
        this.books = books;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(int couseNum) {
        this.courseNum = couseNum;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public ArrayList<Course> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(ArrayList<Course> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public ArrayList<Course> getCorequistes() {
        return corequistes;
    }

    public void setCorequistes(ArrayList<Course> corequistes) {
        this.corequistes = corequistes;
    }

    public int getAvgCourseSize() {
        return avgCourseSize;
    }

    public void setAvgCourseSize(int avgCourseSize) {
        this.avgCourseSize = avgCourseSize;
    }

    public int getAvgSections() {
        return avgSections;
    }

    public void setAvgSections(int avgSections) {
        this.avgSections = avgSections;
    }

    public int getAvgNumSWL() {
        return avgNumSWL;
    }

    public void setAvgNumSWL(int avgNumSWL) {
        this.avgNumSWL = avgNumSWL;
    }

    public double getAvgPassRate() {
        return avgPassRate;
    }

    public void setAvgPassRate(double avgPassRate) {
        this.avgPassRate = avgPassRate;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public double getDiffRating() {
        return diffRating;
    }

    public void setDiffRating(double diffRating) {
        this.diffRating = diffRating;
    }

    public double getGenRatioF() {
        return genRatioF;
    }

    public void setGenRatioF(double genRatioF) {
        this.genRatioF = genRatioF;
    }

    public double getGenRatioM() {
        return genRatioM;
    }

    public void setGenRatioM(double genRatioM) {
        this.genRatioM = genRatioM;
    }

    public double getAvgGPA() {
        return avgGPA;
    }

    public void setAvgGPA(double avgGPA) {
        this.avgGPA = avgGPA;
    }

    public ArrayList<String> getInstructors() {
        return instructors;
    }

    public void setInstructors(ArrayList<String> instructors) {
        this.instructors = instructors;
    }

    public ArrayList<String> getConcepts() {
        return concepts;
    }

    public void setConcepts(ArrayList<String> concepts) {
        this.concepts = concepts;
    }

    public ArrayList<String> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<String> books) {
        this.books = books;
    }
    
    //Special Setters
    public void setMainStuff(String name, String department, int courseNum, int units, 
            int priority, ArrayList<Course> prerequisites, ArrayList<Course> corequistes) {
        this.name = name;
        this.department = department;
        this.courseNum = this.courseNum;
        this.units = units;
        this.priority = priority;
        this.prerequisites = prerequisites;
        this.corequistes = corequistes;
    }
    
    public void setAllStuff(String name, String department, int courseNum, int units,
            int priority, ArrayList<Course> prerequisites, ArrayList<Course> corequistes,
            int avgCourseSize, int avgSections, int avgNumSWL, double avgPassRate,
            double avgGrade, double diffRating, double genRatioF, double avgGPA,
            ArrayList<String> instructors, ArrayList<String> concepts, ArrayList<String> books) {
        //Main Stuff
        this.name = name;
        this.department = department;
        this.courseNum = courseNum;
        this.units = units;
        this.priority = priority;
        this.prerequisites = prerequisites;
        this.corequistes = corequistes;
        
        //Statistical Stuff
        this.avgCourseSize = 0;
        this.avgSections = 0;
        this.avgNumSWL = 0;
        this.avgPassRate = 0.0;
        this.avgGrade = 0.0;
        this.diffRating = 0.0;
        this.genRatioF = 0.0;
        this.genRatioM = 0.0;
        this.avgGPA = 0.0;
        this.instructors = null;
        this.concepts = null;
        this.books = null; 
    }
    
    //Display function
    @Override
    public String toString() {
        String str = "Course: " + name + "(" + courseNum + "), " + department + "Units: " + units + "\n" + 
                "Prerequisites: " + nullCheck(prerequisites) + "\n" +
                "Corequistes: " + nullCheck(corequistes) + "\n \n" +
                "General Statistics: \n" +
                "Average Couse Size: " + avgCourseSize + "\n" +
                "Average Sections Available per Semester: " + avgSections + "\n" +
                "Average Number of Students in Waitlist: " + avgNumSWL + "\n" +
                "Average Pass Rate: " + avgPassRate + "\n" +
                "Average Grade (in percentage): " + avgGrade + "\n" +
                "Difficulty Rating: " + diffRating + "\n" +
                "Percentage of Females: " + genRatioF + "\n" +
                "Percentage of Males: " + genRatioM + "\n" +
                "Average GPA of Students who take this course: " + avgGPA + "\n" +
                "Instructors who teach this course: " + nullCheck(instructors) + "\n" +
                "Concepts covered: " + nullCheck(concepts) + "\n" +
                "Books used: " + nullCheck(books) + "\n";
        return str;
    }
    
    private static String nullCheck(ArrayList l) {
        if(l == null) {
            return "null";
        }
        else {
            return l.toString();
        }
    }

/*    
    public static void main(String[] args) {
        Course comp333 = new Course();
        ArrayList<String> list = new ArrayList<String>();
        list.add("Banana");
        list.add("Banana");
        list.add("Banana");
        
        comp333.setBooks(list);
        System.out.println(comp333.toString());
    }
*/
}