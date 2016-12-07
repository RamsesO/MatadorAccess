/*---------------------------------------------------------------------------
Module Name: ProfileDB (Profile Database Object w/ associated functions)
Inputs: Profile objects, Assorted variable types representing Profile attributes
Outputs: Profile objects, Hashtables containing Profile objects
Submodules: viewProfile(), importData()


Author: Ramses Ordonez
Date: 11/9/16

Reviewer: Ryan Vitacion
Date: 11/27/16


- Revision History -

Programmer: Ramses Ordonez
Date: 11/14/16
Description of Changes: Created ProfileDB Class.
Reviewer:
Date of Review:

Programmer: Ramses Ordonez
Date: 11/16/16
Description of Changes: Added importing and exporting of Profile objects via 
csv.
Reviewer:
Date of Review:


Programmer: Ramses Ordonez
Date: 11/21/16
Description of Changes: Removed importing and exporting of Profile objects via
csv. Added importing and exporting of serialized Databases.
Reviewer:
Date of Review:
---------------------------------------------------------------------------*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

class ProfileDB implements Serializable{
  
    private static final long serialVersionUID = 1902521367567782416L;
    
    //Hashtables to store Profiles with both integer and string keys
    private Hashtable<Integer, Profile> profiles;
    private Hashtable<String, Integer> stringTable;
  
    //constructor
    public ProfileDB(){
        profiles = new Hashtable<Integer, Profile>();
        stringTable = new Hashtable<String, Integer>();
    }

    //search by Profile ID#
    public Profile search(Integer id){
        return profiles.get(id);
    }
    
    //search by Profile name
    public Profile search(String name){
        return profiles.get(stringTable.get(name));
    }
    
    //add Profile object to database
    public void add(Profile prof){
        profiles.put(prof.getId(), prof);
        stringTable.put(prof.getName(), prof.getId());
    }

    //delete Profile object from database by Profile ID#
    public void remove(Integer id){
        String profileName = profiles.remove(id).getName();
        stringTable.remove(profileName);
    }
  
    //delete Profile object from database by Profile name
    public void remove(String profileName){
        profiles.remove(stringTable.get(profileName));
        stringTable.remove(profileName);
    }
    
    //export Hashtable containing stored Profile objects
    public Hashtable<Integer, Profile> export(){
        return profiles;
    }
  
	/*----------------------------------------------------------------------------
	Submodule Name: View Profile - viewProfile()
	Purpose: User is able to search for a Profile (if it exists) and have the 
	Profile displayed to them through the System.
	Input: None
	Output: None
	----------------------------------------------------------------------------*/
    public void viewProfile() {
		Scanner input = new Scanner(System.in);
		Profile temp = null;
		String name = "";
		int id = 0;
		int option = 0;

		//display list of existing profiles in database
        System.out.println("\nCurrently Registered Profiles:\n");
        Enumeration<Profile> e = profiles.elements();
        while (e.hasMoreElements()) {
            Profile next = e.nextElement();
            System.out.println(next.getId() + ": " + next.getName());
        }
        System.out.println();
		
		while (temp == null) {

			//prompt user for target profile
			System.out.print("Enter a name or number: ");

			//search by profile ID#
			if (!input.hasNextInt()) {
				name = input.nextLine();
				temp = search(name);

				//if target profile does not exist, alert user
				if (temp == null) {
					System.out.println("Profile not found.");
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

			//search by profile name
			else {
				id = input.nextInt();
				temp = search(id);

				//if target profile does not exist, alert user
				if (temp == null) {
					System.out.println("Profile not found.");
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
			System.out.println("\n"+temp.toString());
		}
	}

    public void manageProfile() {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        while(choice != 2) {
            System.out.println("\n- Profile Management");
            System.out.println("1) Import sample CSV file");
            System.out.println("2) Return to previous menu");
            System.out.print("Please select an action: ");
            choice = input.nextInt();
            input.nextLine();
            switch(choice) {

                case 1:
                    this.importData("sampleProfiles.csv");
                    break;

                case 2:
                    break;
    
                default:
                    System.out.println("Invalid selection!");
                    break;
            }
        }
    }
    
	/*----------------------------------------------------------------------------
	Submodule Name: import Profile .csv file - importData()
	Purpose: Reads all Profile objects from a .csv file and adds them to the database
	Input: String filename - Name of .csv file
	Output: None
	----------------------------------------------------------------------------*/
   public void importData(String filename) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(filename));
            String line;
            String[] parsedData;
            String[] subset;
            Profile temp;

            //Skip first line
            input.readLine();
            line = null;

            while ((line=input.readLine())!=null){
                parsedData = line.split(",");
                temp = new Profile();

                temp.setName(parsedData[0]);
                temp.setAge(Integer.parseInt(parsedData[1]));
                temp.setGender(parsedData[2]);
                temp.setId(Integer.parseInt(parsedData[3]));
                temp.setEmail(parsedData[4]);
                temp.setDeclaredMajor(parsedData[5]);
                temp.setNumberOfUnits(Integer.parseInt(parsedData[6]));
                temp.setGpa(Double.parseDouble(parsedData[7]));
                temp.setYearEnrolled(Integer.parseInt(parsedData[8]));
                temp.setExpectedGraduationYear(Integer.parseInt(parsedData[9]));

                subset = parsedData[10].split(";");
                temp.setSchedule(new ArrayList<String>(Arrays.asList(subset)));
                subset = parsedData[11].split(";");
                temp.setCurrentEnrolledClasses(new ArrayList<String>(Arrays.asList(subset)));
                subset = parsedData[12].split(";");
                temp.setCompletedClasses(new ArrayList<String>(Arrays.asList(subset)));
                subset = parsedData[13].split(";");
                temp.setAwards(new ArrayList<String>(Arrays.asList(subset)));
                
                this.add(temp);
              //alert user of successful file import
                System.out.println("\nSuccessfully imported sampleProfile.csv!");
            }
        }
        //handle nonexistent file/IO error
        catch (IOException e) {
            System.out.println("Error: File Not Found");
        }

     }
  
}
