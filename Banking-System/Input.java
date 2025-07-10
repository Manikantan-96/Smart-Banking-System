import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.util.regex.Matcher;

public class Input {
 public static int getIntegerInput(Scanner sc) {
	 while(true) {
		 if(sc.hasNextInt()) {
			 int value=sc.nextInt();
			 sc.nextLine();
			 if(value>0)
			 return value;
			 System.out.println("please enter a non negative number");
		 }
		 else {
			 System.out.println("Invalid input, please enter valid input");
			 sc.nextLine();
		 }
	 }
 }
 public static double getDoubleInput(Scanner sc) {
	 while(true) {
		 if(sc.hasNextDouble()) {
			 double value=sc.nextDouble();
			 sc.nextLine();
			 if(value>0)
			 return value;
			 System.out.println("please enter a non negative number");
		 }
		 else {
			 System.out.println("Invalid input, please enter valid input");
			 sc.nextLine();
		 }
	 }
 }
 public static String getStringInput(Scanner sc) {
	 while(true) {
		 if(sc.hasNextLine()) {
			 String value=sc.nextLine();
			 return value;
		 }
		 else {
			 System.out.println("Invalid input, please enter valid input");
			 sc.nextLine();
		 }
	 }
 }
public static String setPassword(Scanner sc) {
	System.out.println("please set the password for your account it must contain 8 to 15 letter include at least one symbol,numbers,capital and small alphabits");
	while(true) {
	String s=sc.nextLine();
	String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,15}$";
	Pattern p=Pattern.compile(regex);
	Matcher m=p.matcher(s);
	if(m.matches()) {
		return s;
	}
	System.out.println("Enter password it must contain 8 to 15 letter include at least one symbol,numbers,capital and small alphabits");
	}
}
@SuppressWarnings("unchecked")
public static Map<String, Account> loadData() throws IOException, ClassNotFoundException {
    File file = new File("./storage.txt");
    Map<String, Account> accounts = new HashMap<>();

    if (file.exists() && file.length() > 0) { // Only load if file exists and has content
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            accounts = (Map<String, Account>) ois.readObject();
            System.out.println("Data loaded successfully");
        } catch (EOFException e) {
            System.out.println("File is empty. Starting with an empty map.");
        }
    } else {
        System.out.println("File does not exist or is empty. Creating fresh data.");
        file.createNewFile(); 
    }

    return accounts;
}

public static void uploadData(Map<String,Account> Accounts) throws IOException {
	 File file=new File("./storage.txt");
   ObjectOutputStream obj=new ObjectOutputStream(new FileOutputStream(file));
       	  obj.writeObject(Accounts); 
          obj.close();
          System.out.println("data uploaded sucessfully");
}
public static String getmbnoInput(Scanner sc) {
	while(true) {
	String s=sc.nextLine();
	String regex = "^(\\+91[-\\s]?)?[7-9]\\d{9}$";
	Pattern p=Pattern.compile(regex);
	Matcher m=p.matcher(s);
	if(m.matches()) {
		return s;
	}
	System.out.println("Enter correct moblie number");
	}
}
}
