import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class login {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter you username:");
		String username = input.nextLine();
		System.out.println("Enter you password:");
		String password = input.nextLine();
		
		String cvsSplitBy = ",";
		BufferedReader br = null;
		
		int credential = 0;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader("accounts.csv"));

			while ((sCurrentLine = br.readLine()) != null) {
				
				String[] loginInfo = sCurrentLine.split(cvsSplitBy);
				
				if(username.equals(loginInfo[0]) && password.equals(loginInfo[1])) {
					
					if(loginInfo[2].equals("1")) {
						
						credential = 1;
						System.out.print("You are now logged in as student!");
						
					} else
						
						credential = 2;
						System.out.print("You are now logged in as admin!");
					
					input.close();
					
				}
				
			}

		} catch (IOException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if (br != null) {
					
					br.close();
					input.close();
					
				}
				
			} catch (IOException ex) {
				
				ex.printStackTrace();
				
			}
		}

	}
	
}
