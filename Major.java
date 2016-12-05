/*---------------------------------------------------------------------------
Module Name: Major (Creates Major object with various functions )
Inputs: ArrayLists; Assorted variable types representing Major attributes
Outputs: Assorted types: strings, integers, doubles, ArrayLists
Submodules: N/A

Author: Hamoun Mojib
Date: 11/9/16

Reviewer: Ryan Vitacion
Date: 11/27/16

- Revision History -
Programmer: Ryan Vitacion
Date: 11/27/16
Description of Changes: Made class serializable
Reviewer:
Date of Review:

Programmer: Hamoun Mojib
Date: 12/4/16
Description of Changes: Comments
Reviewer:
---------------------------------------------------------------------------*/
import java.io.*;
import java.util.*;

public class Major implements Serializable {

    // Main variables to use in Major object
    private int majorId;
    private int averageTime;
    private int averageSalary;
    private int numberOfStudents;
    private int maleStudents;
    private int femaleStudents;
    private double difficultyRating;
    private String majorName;
    private String genderRatio;
    private String description;
    private ArrayList<String> relatedJobs;
    private ArrayList<String> courses;
    
    //Major object constructor
    public Major() {
        this.majorId = 0;
        this.averageTime = 0;
        this.averageSalary = 0;
        this.numberOfStudents = 0;
        this.maleStudents = 0;
        this.femaleStudents = 0;
        this.difficultyRating = 0;
        this.majorName = "";
        this.genderRatio = "";
        this.description = "";
        this.relatedJobs = null;
        this.courses = null;
    }
    
    //Updates Major object
    public Major(int majorId, int averageTime, int averageSalary,
            int numberOfStudents, int maleStudents, int femaleStudents,
            double difficultyRating, String majorName, String genderRatio,
            String description, ArrayList<String> relatedJobs,
            ArrayList<String> courses) {
        this.majorId = majorId;
        this.averageTime = averageTime;
        this.averageSalary = averageSalary;
        this.numberOfStudents = numberOfStudents;
        this.maleStudents = maleStudents;
        this.femaleStudents = femaleStudents;
        this.difficultyRating = difficultyRating;
        this.majorName = majorName;
        this.genderRatio = genderRatio;
        this.description = description;
        this.relatedJobs = relatedJobs;
        this.courses = courses;
    }
    
    //Getter for Major ID number
    public int getMajorId() {
        return majorId;
    }
    
    //Setter for Major ID number
    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }
    
    //Getter for Major's average time to graduation 
    public int getAverageTime() {
        return averageTime;
    }

    //Setter for Major's average time to graduation
    public void setAverageTime(int averageTime) {
        this.averageTime = averageTime;
    }
    
    //Getter for Major's average salary
    public int getAverageSalary() {
        return averageSalary;
    }
    
    //Setter for Major's average Salary
    public void setAverageSalary(int averageSalary) {
        this.averageSalary = averageSalary;
    }
    
    //Getter for current number of students in major
    public int getNumberOfStudents() {
        return numberOfStudents;
    }
    
    //Setter for number of students in Major
    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }
    
    //Getter for number of Male students in Major
    public int getMaleStudents() {
        return maleStudents;
    }
    
    //Setter for number of Male students in Major
    public void setMaleStudents(int maleStudents) {
        this.maleStudents = maleStudents;
    }
    
    //Getter for number of Female students in Major
    public int getFemaleStudents() {
        return femaleStudents;
    }
    
    //Setter for number of Female students in Major
    public void setFemaleStudents(int femaleStudents) {
        this.femaleStudents = femaleStudents;
    }
    
    //Getter for difficulty rating of Major
    public double getDifficultyRating() {
        return difficultyRating;
    }
    
    //Setter for difficulty rating of Major 
    public void setDifficultyRating(double difficultyRating) {
        this.difficultyRating = difficultyRating;
    }
    
    //Getter for name of Major
    public String getMajorName() {
        return majorName;
    }
    
    //Setter for name of Major
    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
    
    //Getter for gender ratio of Major
    public String getGenderRatio() {
        return genderRatio;
    }
    
    //Setter for gender ratio of Major
    public void setGenderRatio(int maleStudents, int femaleStudents) {
        int gcd = 0;
        if (maleStudents > femaleStudents) {
            gcd = GCD(femaleStudents, maleStudents);
        } 
        else {
            gcd = GCD(maleStudents, femaleStudents);
        }
        maleStudents /= gcd;
        femaleStudents /= gcd;
        String genderRatio = maleStudents + " : " + femaleStudents;
        this.genderRatio = genderRatio;

    }
    
    //Getter for Description of Major
    public String getDescription() {
        return description;
    }
    
    //Setter for Description of Major
    public void setDescription(String description) {
        this.description = description;
    }
    
    //Getter for related jobs with degree in Major
    public ArrayList<String> getRelatedJobs() {
        return relatedJobs;
    }
    
    //Setter for related jobs with degree in Major
    public void setRelatedJobs(ArrayList<String> relatedJobs) {
        this.relatedJobs = relatedJobs;
    }
    
    //Getter for courses in Major
    public ArrayList<String> getCourses() {
        return courses;
    }
    
    //Setter for courses in Major
    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }    
    
    //Supporting function to setGenderRatio. Calculates GCD between two integers
    private int GCD(int smallerInt, int largerInt) {
        return largerInt == 0 ? smallerInt : GCD(largerInt, smallerInt % largerInt);
    }
    
    //toString method for Major object
    @Override
    public String toString() {
    	String str = "Major: " + this.majorName + "\n" +
    			"Major ID: " + this.majorId + "\n" +
    			"Average Salary: " + this.averageSalary + "\n" +
    			"Average Time: " + this.averageTime + "\n" +
    			"Number Of Students: " + this.numberOfStudents + "\n" +
    			"Number of Male Students: " + this.maleStudents + "\n" +
    			"Number of Female Students: " + this.femaleStudents + "\n" +
    			"Gender Ratio: " + this.genderRatio+ "\n" +
    			"Difficulty Rating: " + this.difficultyRating + "\n" +
    			"Related Jobs: " + this.relatedJobs + "\n" +
    			"Courses: " + this.courses + "\n" +
    			"Description: " + this.description + "\n";
    	return str;
    	
    }
}

