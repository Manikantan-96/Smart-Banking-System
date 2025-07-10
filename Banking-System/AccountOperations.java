import java.util.Scanner;

public interface AccountOperations {
	public void menu(Scanner sc);
    public void statement();
    public void withdraw(Scanner sc);
    public void deposit(Scanner sc); 
    public void customerCare(Scanner sc);
    public void forgetPassword(int a,Scanner sc);

}
