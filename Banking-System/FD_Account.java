import java.io.Serializable;
import java.util.Scanner;

public class FD_Account extends Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	FD_Account(String name,String mobileNumber,double amount,String accountNumber,String password){
		super(name,mobileNumber,amount,accountNumber,password,AccountType.FD_ACCOUNT);
		
	}
	
	@Override
	public void menu(Scanner sc) {	
		while(true) {
			 System.out.println("\n--- Fixed Deposit Account Menu ---");
             System.out.println("1. Check Balance");
             System.out.println("2. Account Details");
             System.out.println("3. Customer Care");
             System.out.println("4. Logout");
             System.out.print("Enter your choice: ");
	int opt=Input.getIntegerInput(sc);
	switch(opt) {
	case 1:
		System.out.println("Your Fixed Deposit balance is: " + String.format("%.2f", getAmount()));
		break;
	case 2:
		statement();
		break;
	case 3:
		customerCare(sc);
		break;
	case 4:
		System.out.println("Logging out from Fixed Deposit Account.");
        return; // Exit the account menu
    default:
        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
	    }
   	}
	}	
	@Override
  public void deposit(Scanner sc) {
      System.out.println("Operation not supported for Fixed Deposit Accounts.");
      System.out.println("To add funds, you typically need to create a new FD or break the existing one.");
  }

  @Override
  public void withdraw(Scanner sc) {
      System.out.println("Operation not supported for Fixed Deposit Accounts.");
      System.out.println("To withdraw funds, you typically need to break the FD, which may incur penalties.");
}
}