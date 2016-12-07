//Lemuel Dizon

import java.util.Scanner;
import java.io.*;

public class ConsoleUI {

    public static void main(String[] args) {

        //initialize databases
        CourseDB courses = null;
        MajorDB majors = null;;
        ProfileDB profiles = null;
        
        //read all database files and import persistent data
        try (FileInputStream readcourses = new FileInputStream("cdb.dat")) {
            ObjectInputStream importcourses = new ObjectInputStream(readcourses);
            courses = (CourseDB)importcourses.readObject();
            readcourses.close();
            System.out.println("CourseDB loaded!");
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Course database file not found...");
            courses = new CourseDB();
            System.out.println("Succesfully created new course database.\n");
        } catch (IOException e) {
            System.out.println("ERROR: Unable to read course database file.\n");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: Invalid course database type.\n");
        }
        
        try (FileInputStream readmajors = new FileInputStream("mdb.dat")) {
            ObjectInputStream importmajors = new ObjectInputStream(readmajors);
            majors = (MajorDB)importmajors.readObject();
            readmajors.close();
            System.out.println("MajorDB loaded!");
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Major database file not found...");
            majors = new MajorDB();
            System.out.println("Succesfully created new major database.\n");
        } catch (IOException e) {
            System.out.println("ERROR: Unable to read major database file.\n");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: Invalid major database type.\n");
        }
        
        try (FileInputStream readprofiles = new FileInputStream("pdb.dat")) {
            ObjectInputStream importprofiles = new ObjectInputStream(readprofiles);
            profiles = (ProfileDB)importprofiles.readObject();
            readprofiles.close();
            System.out.println("ProfileDB loaded!");
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Profile database file not found...");
            profiles = new ProfileDB();
            System.out.println("Succesfully created new profile database.\n");
        } catch (IOException e) {
            System.out.println("ERROR: Unable to read profile database file.\n");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: Invalid profile database type.\n");
        }
        
        Scanner input = new Scanner(System.in);
        int credential = 0;
        int option = 0;
        boolean exit = false;

        while (exit == false) {
            //Title
            System.out.println();
            System.out.print("MatadorAccess        ");

            switch (credential) {
                case 0:
                    //Guide
                    System.out.println("           No Login Credential");
                    System.out.println("1) View Course Statistics");
                    System.out.println("2) View Major Information");
                    System.out.println("3) Login");
                    System.out.println("4) Exit");

                    //Input
                    System.out.print("Enter a number: ");
                    while (!input.hasNextInt()) {
                        System.out.print("Please enter a number: ");
                        input.next();
                    }
                    option = input.nextInt();

                    switch (option) {
                        case 1:
                            courses.viewCourseStatistics();
                            break;
                        case 2:
                            majors.viewMajorInformation();
                            break;
                        case 3:
                            credential = login(input);
                            break;
                        case 4:
                            System.out.println("You have exited MatadorAccess.");
                            exit = true;
                            break;
                        default:
                            System.out.println("Invalid Command.");
                            break;
                    }

                    break;

                case 1:
                    //Guide
                    System.out.println("      Student Login Credential");
                    System.out.println("1) View Course Statistics");
                    System.out.println("2) View Major Information");
                    System.out.println("3) View Profile");
                    System.out.println("4) Manage Profile");
		    System.out.println("5) Create Course Schedule");
                    System.out.println("6) Logout");
                    System.out.println("7) Exit");

                    //Input
                    System.out.print("Enter a number: ");
                    while (!input.hasNextInt()) {
                        System.out.print("Please enter a number: ");
                        input.next();
                    }
                    option = input.nextInt();

                    switch (option) {
                        case 1:
                            courses.viewCourseStatistics();
                            break;
                        case 2:
                            majors.viewMajorInformation();
                            break;
                        case 3:
                            profiles.viewProfile();
                            break;
                        case 4:
                            profiles.manageProfile();
                            break;
			case 5: 
			    courses.createSchedule();
                            break; 
                        case 6:
                            System.out.println("You have logged out.");
                            credential = 0;
                            break;
                        case 7:
                            System.out.println("You have exited MatadorAccess.");
                            exit = true;
                            break;
                        default:
                            System.out.println("Invalid Command.");
                            break;
                    }

                    break;

                case 2:
                    //Guide
                    System.out.println("Administrator Login Credential");
                    System.out.println("1) View Course Statistics");
                    System.out.println("2) View Major Information");
                    System.out.println("3) View Profile");
                    System.out.println("4) Manage Course");
                    System.out.println("5) Manage Major");
                    System.out.println("6) Logout");
                    System.out.println("7) Exit");

                    //Input
                    System.out.print("Enter a number: ");
                    while (!input.hasNextInt()) {
                        System.out.print("Please enter a number: ");
                        input.next();
                    }
                    option = input.nextInt();

                    switch (option) {
                        case 1:
                            courses.viewCourseStatistics();
                            break;
                        case 2:
                            majors.viewMajorInformation();
                            break;
                        case 3:
                            profiles.viewProfile();
                            break;
                        case 4:
                            courses.manageCourse();
                            break;
                        case 5:
                            majors.manageMajor();
                            break;
                        case 6:
                            System.out.println("You have logged out.");
                            credential = 0;
                            break;
                        case 7:
                            System.out.println("You have exited MatadorAccess.");
                            exit = true;
                            break;
                        default:
                            System.out.println("Invalid Command.");
                            break;
                    }

                    break;

                default:
                    System.out.println("Error: Invalid Credential");
                    exit = true;
                    break;
            }

        }

        input.close();

        //write all changes to persistent data and save databases to files
        try (FileOutputStream writecourses = new FileOutputStream("cdb.dat")) {
            ObjectOutputStream exportcourses = new ObjectOutputStream(writecourses);
            exportcourses.writeObject(courses);
            exportcourses.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Unable to write course database file\n");
        } catch (IOException e) {
            System.out.println("ERROR: Unable to write course database file\n");
        }
        
        try (FileOutputStream writemajors = new FileOutputStream("mdb.dat")) {
            ObjectOutputStream exportmajors = new ObjectOutputStream(writemajors);
            exportmajors.writeObject(majors);
            exportmajors.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Unable to write major database file\n");
        } catch (IOException e) {
            System.out.println("ERROR: Unable to write major database file\n");
        }
        
        try (FileOutputStream writeprofiles = new FileOutputStream("pdb.dat")) {
            ObjectOutputStream exportprofiles = new ObjectOutputStream(writeprofiles);
            exportprofiles.writeObject(profiles);
            exportprofiles.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Unable to write profile database file\n");
        } catch (IOException e) {
            System.out.println("ERROR: Unable to write profile database file\n");
        }

        System.out.println("Databases saved!");
    }

	private static int login(Scanner input) {
		// Local Variables
		String cvsSplitBy = ",";
		BufferedReader br = null;
	    
		// User input
		System.out.print("\nEnter you username: ");
			String username = input.next();
		System.out.print("Enter you password: ");
			String password = input.next();
		
		try {
			
			String sCurrentLine;
			
			// File to read
			br = new BufferedReader(new FileReader("accounts.csv"));

			while ((sCurrentLine = br.readLine()) != null) {
				
				String[] loginInfo = sCurrentLine.split(cvsSplitBy);
				
				if(username.equals(loginInfo[0]) && password.equals(loginInfo[1])) {
					
					if(loginInfo[2].equals("1")) {
						System.out.println("\nYou are now logged in as student!\n");
						br.close();
						return 1;
					} else {
						System.out.println("\nYou are now logged in as admin!\n");
						br.close();
						return 2;
					}		
				}
				
			}
			return 0;
		} 
		
		catch (IOException e) {			
			e.printStackTrace();
			return 0;		
		}
	} // END login(Scanner input)
	
}
