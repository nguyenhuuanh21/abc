package connect;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Account;

public class IOFILE {
	public static ArrayList<Account> readData(String fileName) {
	    ArrayList<Account> accounts = new ArrayList<>();
	    try (var fileReader = new FileReader(fileName);
	         var reader = new BufferedReader(fileReader)) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            // Split line by some delimiter, assuming the data is formatted appropriately
	        	 var info = line.split(","); // Assuming ';' is the delimiter
	            if (info.length == 2) { // Assuming each line contains email and password
	                String email = info[0];
	                String password = info[1];
	                accounts.add(new Account(email, password));
	            }
	        }
	    } catch (IOException ex) {
	        System.out.println(ex.getMessage());
	    }
	    return accounts;
	}
    
}
