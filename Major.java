
import java.util.ArrayList;

public class Major {

    // Main variables
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

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public int getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(int averageTime) {
        this.averageTime = averageTime;
    }

    public int getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(int averageSalary) {
        this.averageSalary = averageSalary;
    }

        public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }
    
    public int getMaleStudents() {
        return maleStudents;
    }

    public void setMaleStudents(int maleStudents) {
        this.maleStudents = maleStudents;
    }

    public int getFemaleStudents() {
        return femaleStudents;
    }

    public void setFemaleStudents(int femaleStudents) {
        this.femaleStudents = femaleStudents;
    }

    public double getDifficultyRating() {
        return difficultyRating;
    }

    public void setDifficultyRating(double difficultyRating) {
        this.difficultyRating = difficultyRating;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getGenderRatio() {
        return genderRatio;
    }

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
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getRelatedJobs() {
        return relatedJobs;
    }

    public void setRelatedJobs(ArrayList<String> relatedJobs) {
        this.relatedJobs = relatedJobs;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }    

    private int GCD(int smallerInt, int largerInt) {
        return largerInt == 0 ? smallerInt : GCD(largerInt, smallerInt % largerInt);
    }
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
    private static String nullCheck(ArrayList<String> l) {
        if(l == null) {
            return "null";
        }
        else {
            return l.toString();
        }
    }
}

