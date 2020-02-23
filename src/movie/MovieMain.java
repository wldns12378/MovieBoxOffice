package movie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MovieMain {
	Member member;
	Scanner sc = new Scanner(System.in);
	
	public MovieMain(Member member) {
		this.member = member;
		show();
	}
	
	public void show() {
		MovieSystem system = new MovieSystem(member);
		AdminSystem admin = new AdminSystem();
		ArrayList<String> reMovieList = system.ms.addMovieList();
		HashMap<String, ArrayList<String>> hs = system.ms.returnComent();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		while(true) {
			if(member.getId().equals("admin")) {
				System.out.println();
				System.out.println("========================================================================");
				System.out.println("1. 상영 영화 추가");
				System.out.println("2. 상영 영화 삭제");
				System.out.println("3. 상영 영화 리스트 보기");
				System.out.println("3. 리뷰 삭제");
				System.out.println("4. 로그아웃");
				System.out.println("========================================================================");
				System.out.print(">> ");
				String input = sc.nextLine();
				switch(input) {
				case "1":
					admin.AddMovie(reMovieList);
					break;
				case "2":
					admin.DelMovie(reMovieList);
					break;
				case "3":
					admin.showlist(reMovieList);
					break;
				case "4":
					admin.DelReview(hs);
					break;
				case "5":
					return;
				}
			} else {
				System.out.println("========================================================================");
				System.out.println("[ " + member.getName() + "님 반갑습니다!!" + " ]");
				System.out.println("1. 영화 조회 및 예매");
				System.out.println("2. 일간 및 주간 영화 랭킹");
				System.out.println("3. 영화리뷰");
				System.out.println("4. 예매조회");
				System.out.println("5. 로그아웃");
				System.out.println("========================================================================");
				System.out.print(">> ");
				String input = sc.nextLine();
				switch(input) {
				case "1":
					system.runningMovie();
					break;
				case "2":
					system.rankMovie();
					break;
				case "3":
					system.gradReview();
					break;
				case "4":
					system.checkingBook();
					break;
				case "5":
					return;
				}
			}
		}
	}
}
