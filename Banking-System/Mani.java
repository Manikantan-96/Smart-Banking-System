import java.util.Scanner;

public class Mani {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
		Bank b=new Bank();
    System.out.println("======WELCOME TO SMART BANK======");
       b.Menu(sc);
       System.out.println("Thank you for banking with us! come again");
	
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
}
