import java.io.IOException;
import java.util.*;
public class Bank  {
private Map<String,Account> Accounts=new HashMap<>();
private final int MAX_LOGIN_ATTEMPTS=3;
public Bank() {
	Thread t=new Thread(r);
    t.setPriority(10);
	t.start();
}
Runnable r=()->{
try {
	Accounts=Input.loadData();
} catch (ClassNotFoundException | IOException e) {
	e.printStackTrace();
}
};
Runnable r1=()->{  try {
	Input.uploadData(Accounts);
} catch (IOException e) {
	e.printStackTrace();
}
};
public void Menu(Scanner sc)  {
	while(true) {
		 System.out.println("\n--- Main Menu ---");
         System.out.println("1: Create Account");
         System.out.println("2: Login to Account");
         System.out.println("3: Exit");
         System.out.println("Enter your choice: ");
    int opt=Input.getIntegerInput(sc);
    switch(opt) {
    case 1:
    	createAccount(sc);
        break;
    case 2:
    	loginToAccount(sc);
    	break;
    case 3:
    	Thread t1=new Thread(r1);
        t1.setPriority(10);
    	t1.start();
    	return;
    default:
    	 System.out.println("Invalid choice. Please enter 1, 2, or 3.");
}
   
	}
}
private void createAccount(Scanner sc){
	System.out.println("\n--- Create New Account ---");
	System.out.println("Enter Name: ");
	String name=Input.getStringInput(sc);
	System.out.println("Enter Mobile Number: ");
	String mobileNumber=Input.getmbnoInput(sc);
	System.out.println("Enter Initial Amount: ");
	double amount=Input.getDoubleInput(sc);
	AccountType accountType = null;
	while(accountType==null) {
	System.out.println("Enter Type of Account (1 for Savings, 2 for Fixed Deposit): ");
    int type=Input.getIntegerInput(sc);
    if(type==1) {
    	accountType=AccountType.SAVINGSACCOUNT;
    }
    else if(type==2) {
    	accountType=AccountType.FD_ACCOUNT;
    }
    else {
    	System.out.println("Invalid account type choice. Please enter 1 or 2.");
    }
	}
    String accountNumber=accountNo();
	String password=Input.setPassword(sc);
	Account account;
	if(accountType==AccountType.SAVINGSACCOUNT) {
		account=new SavingsAccount(name,mobileNumber,amount,accountNumber,password);
	}else {
		account=new FD_Account(name,mobileNumber,amount,accountNumber,password);
	}
	
    Accounts.put(accountNumber, account);
    System.out.println("Account created successfully!");
    System.out.println("Your Account Number is: " + accountNumber);
    System.out.println("Account Type: " + accountType.getDisplay());
    
    
}

private String accountNo() {
    int base = 1740000;
    int max = base;

    for (String accNo : Accounts.keySet()) {
        try {
            int num = Integer.parseInt(accNo.substring(3)); 
            if (num >= max) {
                max = num + 1;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            
        }
    }

    return "ACC" + max;
}


void loginToAccount(Scanner sc) {
	if(Accounts.isEmpty()) {
		System.out.println("No Account Found");
		return;
	}else {
		int count=0;
		while(count<=MAX_LOGIN_ATTEMPTS) {
		try {
		System.out.println("\n--- Login to Account ---");
		System.out.println("Enter Account Number: ");
		String number=Input.getStringInput(sc);
			Account loggedInAccount=Accounts.get(number);
			if(loggedInAccount==null) {
				count++;
				throw new InvalidAccountException("Invalid Account Number! Please Enter Correct Number");
				
			}
				System.out.println("Welcome: "+loggedInAccount.getName());
				while(count<=MAX_LOGIN_ATTEMPTS+1) {
				try {
				System.out.println("Please enter passward for fourther operations");
				String password=Input.getStringInput(sc);
				
			if(loggedInAccount.getPassword().equals(password)){
				loggedInAccount.menu(sc);
					return;
			}
			
			else if(count==MAX_LOGIN_ATTEMPTS) {
				System.out.println("you have exceded the max login attempts");
				System.out.println("please enter 1.for forget password , 2.for Exit: ");
				int option=Input.getIntegerInput(sc);
				switch(option) {
				case 1 :
					loggedInAccount.forgetPassword(MAX_LOGIN_ATTEMPTS,sc);
					break;
				case 2 :return;
				 default:System.out.println("Invalid choice. Please enter 1 or 2.");
				}
		  	}
			else {
				count++;
				throw new InvalidPasswordException("Invalid Account Password! Please Enter Correct password");
			}
			}
	
				catch(InvalidPasswordException e){
					System.err.println("Error: "+e.getMessage());
		}
				}
		}
		catch(InvalidAccountException e){
			System.err.println("Error: "+e.getMessage());
			
		}
	}
	}
}
}
