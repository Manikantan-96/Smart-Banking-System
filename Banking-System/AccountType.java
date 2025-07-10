import java.io.Serializable;

public enum AccountType implements Serializable {
  SAVINGSACCOUNT("Savings Account"),FD_ACCOUNT("Fixed Deposite Account");
   private  String str;
AccountType(String str) {
	this.str=str;
}
	public String getDisplay() {
		return str;
		}
	
}
