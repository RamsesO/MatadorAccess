import java.util.ArrayList;

public class Major {

	// Main variables
	
		private String majorName; 
		
		private double difficultyRating; 
		
		private int averageTime; 
		
		private ArrayList<String> relatedJobs;
		
		private int averageSalary; 
		
		private int numberOfStudents; 
		
		private int maleStudents; 
		
		private int femaleStudents; 
		
		private String genderRatio; 
		
		public Major(){
			
			this.majorName = ""; 
			
			this.difficultyRating = 0.0; 
			
			this.averageTime = 0; 
			
			this.relatedJobs = null; 
			
			this.averageSalary = 0; 
			
			this.numberOfStudents = 0; 
			
			this.maleStudents = 0;
			
			this.femaleStudents = 0;
			
			this.genderRatio = ""; 
		}
		
		public Major(String majorName, double difficultyRating, int averageTime,
				ArrayList<String> relatedJobs, int averageSalary, int numberOfStudents, 
				int maleStudents, int femaleStudents, String genderRatio){
			
			this.majorName = majorName; 
			
			this.difficultyRating = difficultyRating; 
			
			this.averageTime = averageTime; 
			
			this.relatedJobs = relatedJobs; 
			
			this.averageSalary = averageSalary; 
			
			this.numberOfStudents = numberOfStudents; 
			
			this.maleStudents = maleStudents;
			
			this.femaleStudents = femaleStudents;
			
			this.genderRatio = genderRatio;  		
			
		}
		
		public String getMajorName(){
			
			return majorName;
			
		}
		
		public void setMajorName(String majorName){
			
			this.majorName = majorName; 
			
		}
		
		public double getDifficultyRating(){
			
			return difficultyRating; 
			
		}
		
		public void setDifficultyRating(double difficultyRating){
			
			this.difficultyRating = difficultyRating; 
			
		}
		
		public int getAverageTime(){
			
			return averageTime; 
			
		}
		
		public void setAverageTime(int averageTime){
			
			this.averageTime = averageTime; 
			
		}
		
		public ArrayList<String> getRelatedJobs(){
			
			return relatedJobs; 
			
		}
		
		public void setRelatedJobs(ArrayList<String> relatedJobs){
			
			this.relatedJobs = relatedJobs; 
			
		}
		
		public int getAverageSalary(){
			
			return averageSalary; 
			
		}
		
		public void setAverageSalary(int averageSalary){
			
			this.averageSalary = averageSalary; 
			
		}
		
		public int getMaleStudents(){
			
			return maleStudents;
			
		}
		
		public void setMaleStudents(int maleStudents)
		{
			
			this.maleStudents = maleStudents; 
		
		}
		
		public int getFemaleStudents(){
			
			return femaleStudents;
			
		}
		
		public void setFemaleStudents(int femaleStudents)
		{
			
			this.femaleStudents = femaleStudents; 
		
		}
		
		public int getNumberOfStudents(){
			
			return numberOfStudents; 
			
		}
		
		public void setNumberOfStudents(int numberOfStudents){
			
			if(getMaleStudents() > 0 && getFemaleStudents() > 0 && numberOfStudents == 0){
			
				numberOfStudents = getMaleStudents() + getFemaleStudents(); 
				
			}
			
			this.numberOfStudents = numberOfStudents; 
			
		}
			
		public String getGenderRatio(){
			
			return genderRatio;
			
		}
		
		public void setGenderRatio(int maleStudents, int femaleStudents, String genderRatio){
			
			int gcd = 0; 
			
			if( maleStudents > femaleStudents){
				
				gcd = GCD(femaleStudents, maleStudents); 
			
			}
			else{
				gcd = GCD(maleStudents, femaleStudents); 
			}
			
			maleStudents /= gcd; 
			
			femaleStudents /=gcd; 
			
			genderRatio = maleStudents + " : " + femaleStudents; 		
			
			this.genderRatio = genderRatio;  
			
		}	
		
		private int GCD(int smallerInt, int largerInt){ return largerInt == 0 ? smallerInt : GCD(largerInt, smallerInt%largerInt);}		
	
}
