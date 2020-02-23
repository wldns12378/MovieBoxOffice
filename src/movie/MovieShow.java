package movie;

import java.io.BufferedInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MovieShow {
	Member member4;
	Scanner sc = new Scanner(System.in);
	HashMap<String, ArrayList<String>> hs = new HashMap<String, ArrayList<String>>();
	ArrayList<String> movieList = new ArrayList<String>();
	
	public MovieShow(Member member) {
		this.member4 = member;
	}
	
	public ArrayList<String> addMovieList() {
		BufferedInputStream br = null;
		 
		 try {
			 URL url = new URL(
			    " http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/"
				+ "searchDailyBoxOfficeList.json"
			    + "?key=a309b67551381f6d67e36146583e52dd"
				+ "&targetDt=20200219"	 
			    );
			 
			 br = new BufferedInputStream(url.openStream());
			 StringBuffer bf = new StringBuffer();
			 int i=0;
			 byte arr[] = new byte[1000];
			 while((i=br.read(arr))!= -1) {
				 bf.append(new String(arr, 0 , i));
			 }
			 String urll = bf.toString();
			 
			 JSONParser parser = new JSONParser();
			 JSONObject object = (JSONObject)parser.parse(urll);
			 JSONObject object1 = (JSONObject)object.get("boxOfficeResult");
			 JSONArray arr1 = (JSONArray)object1.get("dailyBoxOfficeList");
			 
			 for(int j=0; j<arr1.size(); j++) {
				 
				 JSONObject input1 = (JSONObject) arr1.get(j);
				 String movieNm = (String) input1.get("movieNm");
				 movieList.add(movieNm);
			 }
			 
			 for(int x=0; x<20;x++) {
				 int rand =(int) (Math.random() * (movieList.size() + 1));
				 String temp = movieList.get(0);
				 movieList.set(0, movieList.get(rand));
				 movieList.set(rand, temp);
			 }
		 }catch (Exception e) {
			e.printStackTrace();
		}
		return movieList;
	}
	
	public void showMivieList() {
		System.out.println("<<현재 상영중인 영화>>");
		for(int i=0; i<movieList.size(); i++) {
			System.out.println("[" + (i+1) + "] " + movieList.get(i));
		}
	}
	
	public void movieInfo() {
		
	}
	
	public void booking() {
		System.out.println("예매할 영화 이름을 입력 ");
		System.out.print(">> ");
		String movieName = sc.nextLine();
		for(int i=0; i<movieList.size(); i++) {
			if(movieList.get(i).equals(movieName)) {
				System.out.println("구매하실 티켓 수량 입력");
				System.out.print(">> ");
				String ticketNum = sc.nextLine();
				System.out.println("예약일을 입력해주세요(예 : 20190823)");
				System.out.print(">> ");
				String bookDay = sc.nextLine();
				BookMovie bm = new BookMovie(movieName,ticketNum,bookDay);
				member4.getMovieTicket().add(bm);
				return;
			}
		} System.out.println("입력하신 영화는 현재 상영중인 영화가 아닙니다.");
	}
	
	public void dailyRank() {
		BufferedInputStream br = null;
		 
		 try {
			 URL url = new URL(
			    " http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/"
				+ "searchDailyBoxOfficeList.json"
			    + "?key=a309b67551381f6d67e36146583e52dd"
				+ "&targetDt=20200219"	 
			    );
			 
			 br = new BufferedInputStream(url.openStream());
			 StringBuffer bf = new StringBuffer();
			 int i=0;
			 byte arr[] = new byte[1000];
			 while((i=br.read(arr))!= -1) {
				 bf.append(new String(arr, 0 , i));
			 }
			 String urll = bf.toString();
			 JSONParser parser = new JSONParser();
			 JSONObject object = (JSONObject)parser.parse(urll);
			 JSONObject object1 = (JSONObject)object.get("boxOfficeResult");
			 JSONArray arr1 = (JSONArray)object1.get("dailyBoxOfficeList");
			 System.out.println("<금일 영화 순위>");
			 for(int j=0; j<arr1.size(); j++) {
				 
				 JSONObject input1 = (JSONObject) arr1.get(j);
				 String movieNm = (String) input1.get("movieNm");
				 System.out.println("[" + (j+1) + "위]  ▶▶ " + movieNm);
				 
			 }
		 }catch (Exception e) {
			 e.printStackTrace();
		 }
	}
	
	public void weeklyRank() {
		BufferedInputStream br = null;
		 
		 try {
			 URL url = new URL(
			    "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/"
				+ "/searchWeeklyBoxOfficeList.json"
			    + "?key=a309b67551381f6d67e36146583e52dd"
				+ "&targetDt=20200216"	 
			    );
			 
			 br = new BufferedInputStream(url.openStream());
			 StringBuffer bf = new StringBuffer();
			 int i=0;
			 byte arr[] = new byte[1000];
			 while((i=br.read(arr))!= -1) {
				 bf.append(new String(arr, 0 , i));
			 }
			 String urll = bf.toString();
			 JSONParser parser = new JSONParser();
			 JSONObject object = (JSONObject)parser.parse(urll);
			 JSONObject object1 = (JSONObject)object.get("boxOfficeResult");
			 JSONArray arr1 = (JSONArray)object1.get("weeklyBoxOfficeList");
			 System.out.println("<금주 영화 순위>");
			 for(int j=0; j<arr1.size(); j++) {
				 
				 JSONObject input1 = (JSONObject) arr1.get(j);
				 String movieNm = (String) input1.get("movieNm");
				 System.out.println("[" + (j+1) + "위]  ▶▶ " + movieNm);
				 
			 }
	 }catch (Exception e) {
		e.printStackTrace();
	 }
	}
	public void showReview() {
		boolean abc = false;
		System.out.println("리뷰가 궁금한 영화이름 입력");
		System.out.print(">> ");
		String inputname = sc.nextLine();
		for(String key : hs.keySet()) {
			if(key.equals(inputname)) {
				System.out.println("==================================");
				System.out.println("[ " + inputname + "영화의 리뷰" + " ]");
				for(int i=0; i<hs.get(key).size(); i++) {
					System.out.println("☞" + hs.get(key).get(i));
				}
				System.out.println("==================================");
				abc = true;
				break;
			}
		}
		if(abc == false) {
			System.out.println("입력하신 영화의 리뷰가 존재하지 않습니다.");
		}
		abc = false;
	}
	public void showReview(String name) {
		boolean abc = false;
		for(String key : hs.keySet()) {
			if(key.equals(name)) {
				System.out.println("[ " + name + "영화의 리뷰" + " ]");
				for(int i=0; i<hs.get(key).size(); i++) {
					System.out.println("☞" + hs.get(key).get(i));
				}
				abc = true;
				break;
			}
		}
		if(abc == false) {
			System.out.println("입력하신 영화의 리뷰가 존재하지 않습니다.");
		}
		abc = false;
	}
	
	public void inputReview() {
		System.out.print("리뷰를 등록하실 영화 입력 :");
		String input = sc.nextLine();
		boolean ooo = false;
		for(String key : hs.keySet()) {
			if(key.equals(input)) {
				System.out.printf("'%s' 영화의 리뷰를 입력하세요 : ",input);
				String coment = sc.nextLine();
				hs.get(key).add(coment);
				ooo = true;
				break;
			}
		}
		if(ooo == false) {
			System.out.println("선택하신 영화의 첫 리뷰를 입력해주세요 !!");
			System.out.print("입력 : ");
			String newComent = sc.nextLine();
			ArrayList<String> coment = new ArrayList<String>();
			coment.add(newComent);
			hs.put(input, coment);
		}
		ooo = false;
	}
	
	public void checkingShow() {
		System.out.println("예매한영화 리스트");
	      
	      for(int i=0; i<member4.getMovieTicket().size(); i++) {
	         if(member4.getMovieTicket().size() != 0) {
	            System.out.println("▶" + member4.getMovieTicket().get(i));
	         }
	      }
	}
	
	public HashMap<String, ArrayList<String>> returnComent(){
		return hs;
	}
}
