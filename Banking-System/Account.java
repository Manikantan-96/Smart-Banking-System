import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Account implements AccountOperations,Serializable{
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
     private  String mobileNumber;
     private double amount;
     private String accountNumber;
     private String password;
     private AccountType accountType;
      List<String> transcationHistory=new ArrayList<>();
Account(String name,String mobileNumber,double amount,String accountNumber,String password, AccountType accountType){
	this.name=name;
	this.mobileNumber=mobileNumber;
	this.amount=amount;
	this.accountNumber=accountNumber;
	this.password=password;
	this.accountType = accountType;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public double getAmount() {
	return amount;
}
public String getAccountNumber() {
	return accountNumber;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password= password;
}
public AccountType getAccountType() {
  return accountType;
}
public abstract void menu(Scanner sc);
@Override
public void forgetPassword(int MAX_LOGIN_ATTEMPTS,Scanner sc) {
	while(MAX_LOGIN_ATTEMPTS!=0) {
	System.out.println("Please enter mobile number");
	String mobileNo=Input.getmbnoInput(sc);
	System.out.println("Please enter name");
	String name=Input.getStringInput(sc);
	if(mobileNo.equals(getMobileNumber()) && name.equals(getName())) {
		System.out.println("you have verified successfuly");
		System.out.println("Enter new password");
		String password=Input.setPassword(sc);
		setPassword(password);
		System.out.println("your password updated successfuly");
		return;
	}
	else {
		MAX_LOGIN_ATTEMPTS--;
	}
	}
}

@Override
public void statement() {
	 System.out.println("\n--- Account Statement ---");
     System.out.println("Account Type: " + getAccountType().getDisplay());
     System.out.println("Name: " + getName());
     System.out.println("Mobile Number: " + getMobileNumber());
     System.out.println("Account Number: " + getAccountNumber());
     System.out.println("Current Balance: " + String.format("%.2f", getAmount())); // Format for currency
}
@Override
public void withdraw(Scanner sc) {
System.out.println("Enter Amount How Much you Want to Withdraw");
double withdrawAmount =Input.getDoubleInput(sc);
try {
	
	 if(withdrawAmount>amount) {
		throw new InsufficientBalanceException("Insufficient balance! Your current balance is: " + String.format("%.2f", getAmount()));
	}else {
		amount-=withdrawAmount;
		System.out.println("Successfully withdrew " + String.format("%.2f", withdrawAmount));
     System.out.println("Remaining balance is: " + String.format("%.2f", getAmount()));
     transcationHistory.add("withdrew amount of: " + String.format("%.2f", withdrawAmount));
	}
}
catch(InsufficientBalanceException e) {
	System.err.println("Error: "+e.getMessage());
}

}
@Override
public void deposit(Scanner sc) {
	System.out.println("Enter Amount how much we want to Deposite");
	double depositAmount=Input.getDoubleInput(sc);
		amount+=depositAmount;
		System.out.println("Successfully deposited " + String.format("%.2f", depositAmount));
        System.out.println("your balance is: " + String.format("%.2f", getAmount()));
        transcationHistory.add("deposited amount of: "+String.format("%.2f", depositAmount));
}
@Override
public void customerCare(Scanner sc) {
	System.out.println("Enter what you want to change");
	System.out.println("1.change Name");
	System.out.println("2.change Mobile Number");
	System.out.println("3. Back to Account Menu");
	int opt=Input.getIntegerInput(sc);
	switch(opt) {
	case 1:
		System.out.println("Enter New Name: ");
	    String name=Input.getStringInput(sc);
	    setName(name);
	    System.out.println("Name updated sucessfully");
	    break;
	case 2:
		System.out.println("Enter New Mobile Number: ");
	    String mobileNumber=Input.getmbnoInput(sc);
	    setMobileNumber(mobileNumber);
	    System.out.println("mobile number updated sucessfully");
	    break;
	 case 3:
        System.out.println("Returning to account menu.");
         break;
     default:
         System.out.println("Invalid choice. Please enter 1, 2, or 3.");
	}

}


}
