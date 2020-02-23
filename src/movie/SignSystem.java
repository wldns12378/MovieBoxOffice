package movie;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class SignSystem {
	 Scanner sc = new Scanner(System.in);
	 ArrayList<Member> member = new ArrayList<Member>();
	
	 public void readUser() {
	      ObjectInputStream ois = null;
	      try {
	    	  File file = new File("D:\\work\\java_work\\MovieBoxOffice\\member.ser");
	    	  if(!(file.length()==0)) {
	    		  ois = new ObjectInputStream(new FileInputStream("member.ser"));
	    		  member = (ArrayList<Member>)ois.readObject();
	    	  }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            ois.close();
	         } catch (Exception e2) { }
	      }
	   }

	 
	public void signIn() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("****************");
		System.out.println("*     로그인         *");
		System.out.println("****************");
		System.out.println();
		loop:
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			
			for(int i=0; i<member.size(); i++) {
				if(member.get(i).getId().equals(id)){
					System.out.print("비밀번호 : ");
					String password = sc.nextLine();
					if(member.get(i).getPassword().equals(password)) {
						System.out.println("로그인 성공!");
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println();
						//영화시스템을 호출
						MovieMain moviemain = new MovieMain(member.get(i));
						return;
					} else System.out.println("비밀번호가 틀렸습니다."); continue loop;
				}
			}System.out.println("입력하신 계정이 존재하지 않습니다.");
		}
	}
	
	
	public void signUp() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("****************");
		System.out.println("*    회원가입        *");
		System.out.println("****************");
		System.out.println();
		loop:
		while(true) {
			//이름, 생일, 전화번호, 이메일, 아이디, 비번
			System.out.print("사용 할 아이디 : ");
			String id = sc.nextLine();
			for(int i=0; i<member.size(); i++) {
				if(member.get(i).getId().equals(id)) {
					System.out.println("이미 존재하는 아이디입니다.");
					continue loop;
				}
			}
			System.out.print("사용 할 비번 : ");
			String password = sc.nextLine();
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("생일 : ");
			String birth = sc.nextLine();
			System.out.print("전화번호 : ");
			String phoneNum = sc.nextLine();
			System.out.print("이메일 : ");
			String eMail = sc.nextLine();
			member.add(new Member(name, birth, phoneNum, eMail, id, password));
			ObjectOutputStream oos = null;
		    try {
		       oos = new ObjectOutputStream(new FileOutputStream("member.ser"));
		       oos.writeObject(member); 
		    } catch (Exception e) {
		       e.printStackTrace();
		    } finally {
		       try {
		          oos.close();
		       } catch (Exception e) { }
		    }
		    System.out.println("회원가입이 완료되었습니다!");
		    break;
		}
	}
}
