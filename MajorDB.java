import java.util.*;
import java.io.*;

class MajorDB implements Serializable{

    private static final long serialVersionUID = 9184085222891215235L;
    
    private Hashtable<String, Integer> stringTable;
    private Hashtable<Integer, Major> majors;
    
    public MajorDB() {
        this.stringTable = new Hashtable<String, Integer>();
        this.majors = new Hashtable<Integer, Major>();
    }
    
    public Major search(Integer id) {
        return majors.get(id);
    }
    
    public Major search(String name) {
        return majors.get(stringTable.get(name));
    }
    
    public void add(Major mjr) {
        majors.put(mjr.getMajorId(), mjr);
        stringTable.put(mjr.getMajorName(), mjr.getMajorId());
    }
    
    public void delete(Integer id) {
        stringTable.remove(majors.get(id).getMajorId());
        majors.remove(id);
    }
    
    public void delete(String name) {
        majors.remove(stringTable.get(name));
        stringTable.remove(name);
    }
    
    public Hashtable<Integer, Major> export() {
        return majors;
    }
	
    public void viewMajorInformation() {
    	Scanner input = new Scanner(System.in);
    	Major temp = null;
    	String name = "";
    	int id = 0;
    	int option = 0;
    	
    	while(temp == null) {
    		System.out.print("Enter a name or number: ");
    		if(!input.hasNextInt()) {
    			name = input.nextLine();
    			temp = search(name);
    			if(temp == null) {
    				System.out.println("Major not found");
    				System.out.println("1) Search again");
    				System.out.println("2) Exit");
    				
    				while(!input.hasNextInt()) {
    					System.out.print("Please enter a number: ");
    					input.next();
    				}
    				option = input.nextInt();
    				
    				while(option != 1 && option != 2) {
    					System.out.println("Invalid command please enter 1 or 2: ");
    					option = input.nextInt();
    				}
    				if(option == 2) break;
    			}
    		}
    		else {
    			id = input.nextInt();
    			temp = search(id);
    			
    			if(temp == null) {
    				System.out.println("Major not found");
    				System.out.println("1) Search again");
    				System.out.println("2) Exit");
    				
    				while(!input.hasNextInt()) {
    					System.out.print("Please enter a number: ");
    					input.next();
    				}
    				option = input.nextInt();
    				
    				while(option != 1 && option != 2) {
    					System.out.println("Invalid command please enter 1 or 2: ");
    					option = input.nextInt();
    				}
    				if(option == 2) break;
    			}
    		}
    	}
    	if(temp != null) {
    		System.out.println(temp.toString());
    	}
        
    }
    
    public void manageMajor() {
        System.out.println("Manage Major is not implemented yet");
    }	
    
}
