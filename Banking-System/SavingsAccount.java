import java.io.Serializable;
import java.util.Scanner;

public class SavingsAccount extends Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	SavingsAccount(String name,String mobileNumber,double amount,String accountNumber,String password){
		super(name,mobileNumber,amount,accountNumber,password,AccountType.SAVINGSACCOUNT);

	}

	@Override
	public void menu(Scanner sc) {
		while(true) {
			 System.out.println("\n--- Savings Account Menu ---");
             System.out.println("1. Check Balance");
             System.out.println("2. Deposit Amount");
             System.out.println("3. Withdraw Amount");
             System.out.println("4. Account Details");
             System.out.println("5. Customer Care");
             System.out.println("6. Logout");
             System.out.print("Enter your choice: ");
	int opt=Input.getIntegerInput(sc);
	switch(opt) {
	case 1:
		System.out.println("your current balance is"+ String.format("%.2f",getAmount()));
		break;
	case 2:
		deposit(sc);
		break;
	case 3:
		withdraw(sc);
		break;
	case 4:
		showTranscationHistory();
		break;
	case 5:
		customerCare(sc);
		break;
	case 6:
		System.out.println("Logging out from Savings Account.");
        return; 
    default:
        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
		
		
	}
	}
		
	}

	private void showTranscationHistory() {
		statement();
		for(String history: transcationHistory) {
			System.out.println(history);
		}
	}

}

