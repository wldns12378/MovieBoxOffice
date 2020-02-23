package movie;

import java.io.BufferedInputStream;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MovieJSONdetail {

	public MovieJSONdetail(String movieCd) throws Exception {

		JSONParser jsonparser = new JSONParser();
		JSONObject jsonobject = (JSONObject) jsonparser.parse(readUrl(movieCd));
		JSONObject json = (JSONObject) jsonobject.get("movieInfoResult");
		JSONObject movieInfo = (JSONObject) json.get("movieInfo");
		System.out.println(movieInfo.get("movieNm"));

		JSONArray genresList = (JSONArray) movieInfo.get("genres"); // 장르리스트
		JSONArray actorList = (JSONArray) movieInfo.get("actors"); // 출연자 목록

		JSONArray directorsList = (JSONArray) movieInfo.get("directors"); // 감독 목록

		String movieNm = (String) movieInfo.get("movieNm"); // 영화제목
		String movieNmEn = (String) movieInfo.get("movieNmEn"); // 영어제목
		String showTm = (String) movieInfo.get("showTm"); // 영상길이
		String prdtStatNm = (String) movieInfo.get("prdtStatNm"); // 개봉상태
		String openDt = (String) movieInfo.get("openDt"); // 개봉연도

		JSONObject actor = null;
		JSONObject directors = null;

		for (int i = 0; i < directorsList.size(); i++) {
			directors = (JSONObject) directorsList.get(i);
			String resultPeopleNm = (String) directors.get("peopleNm");
			System.out.println(resultPeopleNm);
		}

		JSONObject genres = (JSONObject) genresList.get(0);

		System.out.println("");
		System.out.println("");
		System.out.println("영화제목:" + movieNm + "(" + movieNmEn + ")");
		System.out.println("감독:" + directors.get("peopleNm"));
		System.out.print("개봉일시:" + openDt + "\t");
		System.out.println("개봉상태:" + prdtStatNm);
		System.out.println("장르:" + genres.get("genreNm"));
		System.out.println(" - 출연진 - ");
		System.out.print(" 주연:");
		for (int i = 0; i < 3; i++) {
			actor = (JSONObject) actorList.get(i);
			String resultPeopleNm = (String) actor.get("peopleNm");
			String resultCast = (String) actor.get("cast");
			System.out.print(resultPeopleNm + "(" + resultCast + " 역)");
			if (i == 2) {
				System.out.println("");
				continue;
			}
			System.out.print(", ");
		}
		System.out.print(" 단역:");
		if (actorList.size() <= 7) {
			for (int i = 3; i < actorList.size(); i++) {
				actor = (JSONObject) actorList.get(i);
				String resultPeopleNm = (String) actor.get("peopleNm");
				String resultCast = (String) actor.get("cast");
				System.out.print(resultPeopleNm + "(" + resultCast + " 역)");
				if ((i + 1) == actorList.size()) {
					System.out.println("");
					System.out.println("");
					continue;
				}
				System.out.print(", ");
			}

		} else {
			for (int i = 3; i < 7; i++) {
				actor = (JSONObject) actorList.get(i);
				String resultPeopleNm = (String) actor.get("peopleNm");
				String resultCast = (String) actor.get("cast");
				System.out.print(resultPeopleNm + "(" + resultCast + " 역)");
				if (i == 6) {
					System.out.println("");
					continue;
				}
				System.out.print(", ");
			}

			System.out.print(" 단역:");
			for (int i = 7; i < actorList.size(); i++) {
				actor = (JSONObject) actorList.get(i);
				String resultPeopleNm = (String) actor.get("peopleNm");
				String resultCast = (String) actor.get("cast");
				System.out.print(resultPeopleNm + "(" + resultCast + " 역)");
				if (i+1 == actorList.size()) {
					System.out.println("");
					continue;
				}
				System.out.print(", ");
			}

		}

	}

	private static String readUrl(String movieCd) throws Exception {
		BufferedInputStream reader = null;

		try {
			URL url = new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/" + "searchMovieInfo.json"
					+ "?key=a309b67551381f6d67e36146583e52dd" + "&movieCd=" + movieCd);

			System.out.println("http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/" + "searchMovieInfo.json"
					+ "?key=a309b67551381f6d67e36146583e52dd" + "&movieCd=" + movieCd);

			reader = new BufferedInputStream(url.openStream());
			StringBuffer buffer = new StringBuffer();
			int i;
			byte[] b = new byte[4096];
			while ((i = reader.read(b)) != -1) {
				buffer.append(new String(b, 0, i));
			}
			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}

//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        try {
//            new MovieJSONMain();
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }

}