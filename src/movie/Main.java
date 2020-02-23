package movie;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SignSystem sign = new SignSystem();
		sign.readUser();
		while(true) {
			System.out.println("========================================================================");
			System.out.println(
					"██████╗  ██████╗ ██╗  ██╗     ██████╗ ███████╗███████╗██╗ ██████╗███████╗\n" +
					"██╔══██╗██╔═══██╗╚██╗██╔╝    ██╔═══██╗██╔════╝██╔════╝██║██╔════╝██╔════╝\n" +
					"██████╔╝██║   ██║ ╚███╔╝     ██║   ██║█████╗  █████╗  ██║██║     █████╗\n" +
					"██╔══██╗██║   ██║ ██╔██╗     ██║   ██║██╔══╝  ██╔══╝  ██║██║     ██╔══╝\n" +  
					"██████╔╝╚██████╔╝██╔╝ ██╗    ╚██████╔╝██║     ██║     ██║╚██████╗███████╗\n" +
					"╚═════╝  ╚═════╝ ╚═╝  ╚═╝     ╚═════╝ ╚═╝     ╚═╝     ╚═╝ ╚═════╝╚══════╝"                                                                                                                         
					);	
			System.out.println("========================================================================");
			System.out.println("◀  1. Sign in  ▶");
			System.out.println("◀  2. Sign up  ▶");
			System.out.print(">> ");
			String input = sc.nextLine();
			
			switch(input) {
			case "1":
				sign.signIn();
				break;
			case "2":
				sign.signUp();
				break;
			}
		}
	}

}
