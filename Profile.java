class Profile{
	private double gpa
	private int numberOfUnits
	private int yearEnrolled
	private int expectedGraduationYear
	private int age
	private Long id
	private String gender
	private Graph schedule
	private List currentEnrolledClasses
	private List completedClasses
	private List awards
	private Long profilePicturId
	private Major declaredMajor
	private String bio
	private String email

	public Profile(){
		this.gpa = 0.0;
		this.numberOfUnits = 0;
		this.yearEnrolled = 0;
		this.expectedGraduationYear = 0;
		this.age = 0;
		this.id = 0;
		this.gender = "";
		this.schedule = null;
		this.currentEnrolledClasses = null;
		this.completedClasses = null;
		this.awards = null;
		this.profilePicturId = 0;
		this.declaredMajor = null;
		this.bio = "";
		this.email = "";


	}

	public Profile(double gpa, int numberOfUnits, int yearEnrolled, 
					int expectedGraduationYear, int age, 
					Long id, String gender, Graph schedule, 
					List currentEnrolledClasses, List completedClasses,
					List awards, Long profilePicturId,
					String bio,String email){
		this.gpa = gpa;
		this.numberOfUnits = numberOfUnits;
		this.yearEnrolled = yearEnrolled;
		this.expectedGraduationYear = expectedGraduationYear;
		this.age = age;
		this.id = id;
		this.gender = gender;
		this.schedule = schedule;
		this.currentEnrolledClasses = currentEnrolledClasses;
		this.completedClasses = completedClasses;
		this.awards = awards;
		this.profilePicturId = profilePicturId;
		this.bio = bio;
		this.email = email;


	}

	public double getGpa(){
		return gpa;
	}

	public void setGpa(double gpa){
		this.gpa = gpa;
	}

	public int getNumberOfUnits(){
		return numberOfUnits;
	}

	public void setNumberOfUnits(int numberOfUnits){
		this.numberOfUnits = numberOfUnits;
	}

	public int getYearEnrolled(){
		return yearEnrolled;
	}

	public void setYearEnrolled(int yearEnrolled){
		this.yearEnrolled = yearEnrolled;
	}

	public int getExpectedGraduationYear(){
		return expectedGraduationYear;
	}

	public void setExpectedGraduationYear(int expectedGraduationYear){
		this.expectedGraduationYear = expectedGraduationYear;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age = age;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public String getGender(){
		return gender;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public Graph getSchedule(){
		return schedule;
	}

	public void setSchedule(Graph schedule){
		this.schedule = schedule;
	}

	public List getCurrentEnrolledClasses(){
		return currentEnrolledClasses;
	}

	public void setCurrentEnrolledClasses(List currentEnrolledClasses){
		this.currentEnrolledClasses = currentEnrolledClasses;
	}

	public List getCompletedClasses(){
		return completedClasses;
	}

	public void setCompletedClasses(List completedClasses){
		this.completedClasses = completedClasses;
	}

	public List getAwards(){
		return awards;
	}

	public void setAwards(List awards){
		this.awards = awards;
	}

	public Long getProfilePicturId(){
		return profilePicturId;
	}

	public void setProfilePicturId(Long profilePicturId){
		this.profilePicturId = profilePicturId;
	}

	public String getBio(){
		return bio;
	}

	public void setBio(String bio){
		this.bio = bio;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}
}

















