package movie;
import java.io.BufferedInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MovieSystem{
	Member member;
	Scanner sc = new Scanner(System.in);
	MovieShow ms;
	ArrayList<String> movieList;
	
	public MovieSystem(Member member) {
		this.member = member;
		this.ms = new MovieShow(member);
	}
	public void runningMovie() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		while(true) {
			System.out.println("========================================================================");
			System.out.println("1.상영중인 영화 ");
			System.out.println("2.영화 정보 보기");
			System.out.println("3.영화예매하기");
			System.out.println("4.뒤로가기");
			System.out.println("========================================================================");
			System.out.print(">> ");
			String input = sc.nextLine();
			if(input.equals("1")) {
				ms.showMivieList();
			} else if(input.equals("2")) {
				String movieNm="";
		        String directorNm="";
		        System.out.println("========================================================================");
		        System.out.println("영화를 검색합니다.키워드를 선택하세요.");
		        System.out.println("1. 영화제목으로 검색");
		        System.out.println("2. 감독명으로 검색");
		        System.out.println("========================================================================");
		        String temp = sc.nextLine();
		        if(temp.equals("1")) {
		           System.out.println("검색할 영화 제목을 입력하세요.");
		           System.out.print(">>");
		           movieNm = sc.nextLine();
		        }else if(temp.equals("2")) {
		           System.out.println("검색할 영화 감독을 입력하세요.");
		           System.out.print(">> ");
		           directorNm = sc.nextLine();
		        }
		        
		        
		        try {
		           MovieJSONMain jsonMovie = new MovieJSONMain(movieNm,directorNm);
		           System.out.println("해당 영화 번호 입력 >> ");
		           int index = (sc.nextInt()-1);
		           sc.nextLine();
		           String resultCd = jsonMovie.resultMovieCd.get(index).toString();
		           System.out.println(resultCd);
		           new MovieJSONdetail(resultCd);
		           ms.showReview(movieNm);
		           
		        } catch (Exception e) {
		           // TODO Auto-generated catch block
		           e.printStackTrace();
		        }
			} else if(input.equals("3")) {
				ms.booking();
			} else if(input.equals("4")) {
				return;
			}
		}
	}
	
	public void rankMovie() {
		System.out.println("========================================================================");
		System.out.println("1.일간랭킹");
		System.out.println("2.주간랭킹");
		System.out.println("3.뒤로가기");
		System.out.println("========================================================================");
		System.out.print(">> ");
		String inputRank = sc.nextLine();
		if(inputRank.equals("1")) {
			ms.dailyRank();
		}else if(inputRank.equals("2")) {
			ms.weeklyRank();
		}
	}
	
	public void gradReview() {
		while(true) {
			System.out.println("========================================================================");
			System.out.println("1.리뷰보기");
			System.out.println("2.리뷰작성");
			System.out.println("3.뒤로가기");
			System.out.println("========================================================================");
			System.out.print(">> ");
			String inputNum = sc.nextLine();
			if(inputNum.equals("1")) {
				ms.showReview();
			}else if(inputNum.equals("2")) {
				ms.inputReview();
			} else {
				return;
			}
		}
	}
	  public void checkingBook() { //4.예매 조회 - 
		  System.out.println("예매한영화 리스트");
	      
	      for(int i=0; i<member.getMovieTicket().size(); i++) {
	         if(member.getMovieTicket().size() != 0) {
	        	System.out.println("======================================");
	            System.out.println("▶" + "제목 : " + member.getMovieTicket().get(i).movieName);
	            System.out.println("▶" + "수량 : " + member.getMovieTicket().get(i).ticketNum);
	            System.out.println("▶" + "관람일 : " + member.getMovieTicket().get(i).bookDay);
	            System.out.println("======================================");
	         }
	      }
	   }
	
	
}
