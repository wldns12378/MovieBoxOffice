package movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AdminSystem {
	Scanner sc = new Scanner(System.in);
	public void AddMovie(ArrayList<String> list) {
		System.out.println("추가할 상영 영화제목 입력 ");
		System.out.print(">> ");
		String input = sc.nextLine();
		list.add(input);
		System.out.println("추가 완료");
	}
	
	public void DelMovie(ArrayList<String> list) {
		System.out.println("상영 종료할 영화제목 입력");
		System.out.print(">> ");
		String input = sc.nextLine();
		for(int i=0; i<list.size(); i++) {
			if(input.equals(list.get(i))) {
				list.remove(i);
				System.out.println("입력하신 영화를 상영 종료하였습니다.");
				break;
			}
		}
	}
	
	public void showlist(ArrayList<String> list) {
		for(int i=0; i<list.size(); i++) {
			System.out.println("[" + (i+1) + "]" + list.get(i));
		}
	}
	
	public void DelReview(HashMap<String, ArrayList<String>> list) {
		System.out.println("삭제하실 리뷰의 영화 제목을 입력하세요");
		System.out.print(">> ");
		String input = sc.nextLine();
		for(String movie : list.keySet()) {
			if(movie.equals(input)) {
				for(int j=0; j<list.get(movie).size(); j++) {
					System.out.println("[" + (j+1) + "]" + list.get(movie).get(j));
				}
				System.out.println("삭제하실 리뷰 번호 입력");
				System.out.println(">> ");
				String input1 = sc.nextLine();
				list.get(movie).remove(Integer.parseInt(input1) - 1);
				System.out.println("리뷰 삭제 완료!");
			}
		}
		
	}
}
