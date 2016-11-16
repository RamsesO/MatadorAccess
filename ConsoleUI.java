//Lemuel Dizon

import java.util.Scanner;

public class ConsoleUI {
   
    public static void main(String[] args) {
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
                    option = input.nextInt();
                    
                    switch (option) {
                        case 1:
                            viewCourseStatistics();
                            break;
                        case 2:
                            viewMajorInformation();
                            break;
                        case 3:
                            credential = login();
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
                    System.out.println("5) Logout");
                    System.out.println("6) Exit");
                    
                    //Input
                    System.out.print("Enter a number: ");
                    option = input.nextInt();
                    
                    switch (option) {
                        case 1:
                            viewCourseStatistics();
                            break;
                        case 2:
                            viewMajorInformation();
                            break;
                        case 3:
                            viewProfile();
                            break;
                        case 4:
                            manageProfile();
                            break;
                        case 5:
                            System.out.println("You have logged out.");
                            credential = 0;
                            break;
                        case 6:
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
                    option = input.nextInt();
                    
                    switch (option) {
                        case 1:
                            viewCourseStatistics();
                            break;
                        case 2:
                            viewMajorInformation();
                            break;
                        case 3:
                            viewProfile();
                            break;
                        case 4:
                            manageCourse();
                            break;
                        case 5:
                            manageMajor();
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
        
    }

    private static void viewCourseStatistics() {
        System.out.println("View Course Statistics is not implemented yet");
    }

    private static void viewMajorInformation() {
        System.out.println("View Major Information is not implemented yet");
    }
    
    private static void viewProfile() {
        System.out.println("View Profile is not implemented yet");
    }

    private static void manageProfile() {
        System.out.println("Manage Profile is not implemented yet");
    }
    
    private static void manageCourse() {
        System.out.println("Manage Course is not implemented yet");
    }

    private static void manageMajor() {
        System.out.println("Manage Major is not implemented yet");
    }

    private static int login() {
        System.out.println("Login is not implemented yet");
        return 0;
    }
    
}
