
import java.util.ArrayList;

class Profile{
    
    private double gpa;
    private int numberOfUnits;
    private int yearEnrolled;
    private int expectedGraduationYear;
    private int age;
    private int id;
    private long profilePicturId;
    private String name;
    private String gender;
    private String bio;
    private String email;
    private String declaredMajor;
    private ArrayList<String> schedule;
    private ArrayList<String> currentEnrolledClasses;
    private ArrayList<String> completedClasses;
    private ArrayList<String> awards;

    public Profile(){
        this.gpa = 0.0;
        this.numberOfUnits = 0;
        this.yearEnrolled = 0;
        this.expectedGraduationYear = 0;
        this.age = 0;
        this.id = 0;
        this.profilePicturId = 0;
        this.name = "";
        this.gender = "";
        this.bio = "";
        this.email = "";
        this.declaredMajor = "";
        this.schedule = null;
        this.currentEnrolledClasses = null;
        this.completedClasses = null;
        this.awards = null;
    }

    public Profile(double gpa, int numberOfUnits, int yearEnrolled,
            int expectedGraduationYear, int age, int id, long profilePicturId,
            String name, String gender, String bio, String email,
            String declaredMajor, ArrayList<String> schedule,
            ArrayList<String> currentEnrolledClasses,
            ArrayList<String> completedClasses, ArrayList<String> awards) {
        this.gpa = gpa;
        this.numberOfUnits = numberOfUnits;
        this.yearEnrolled = yearEnrolled;
        this.expectedGraduationYear = expectedGraduationYear;
        this.age = age;
        this.id = id;
        this.profilePicturId = profilePicturId;
        this.name = name;
        this.gender = gender;
        this.bio = bio;
        this.email = email;
        this.declaredMajor = declaredMajor;
        this.schedule = schedule;
        this.currentEnrolledClasses = currentEnrolledClasses;
        this.completedClasses = completedClasses;
        this.awards = awards;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public int getYearEnrolled() {
        return yearEnrolled;
    }

    public void setYearEnrolled(int yearEnrolled) {
        this.yearEnrolled = yearEnrolled;
    }

    public int getExpectedGraduationYear() {
        return expectedGraduationYear;
    }

    public void setExpectedGraduationYear(int expectedGraduationYear) {
        this.expectedGraduationYear = expectedGraduationYear;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getProfilePicturId() {
        return profilePicturId;
    }

    public void setProfilePicturId(long profilePicturId) {
        this.profilePicturId = profilePicturId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeclaredMajor() {
        return declaredMajor;
    }

    public void setDeclaredMajor(String declaredMajor) {
        this.declaredMajor = declaredMajor;
    }

    public ArrayList<String> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<String> schedule) {
        this.schedule = schedule;
    }

    public ArrayList<String> getCurrentEnrolledClasses() {
        return currentEnrolledClasses;
    }

    public void setCurrentEnrolledClasses(ArrayList<String> currentEnrolledClasses) {
        this.currentEnrolledClasses = currentEnrolledClasses;
    }

    public ArrayList<String> getCompletedClasses() {
        return completedClasses;
    }

    public void setCompletedClasses(ArrayList<String> completedClasses) {
        this.completedClasses = completedClasses;
    }

    public ArrayList<String> getAwards() {
        return awards;
    }

    public void setAwards(ArrayList<String> awards) {
        this.awards = awards;
    }
    
}