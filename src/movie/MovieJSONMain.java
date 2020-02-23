package movie;
import java.io.BufferedInputStream;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
public class MovieJSONMain {
	
	ArrayList<String> resultMovieCd= new ArrayList<String>();
    
    public MovieJSONMain(String movieNm, String directorNm) throws Exception{
         
         JSONParser jsonparser = new JSONParser();
         JSONObject jsonobject = (JSONObject)jsonparser.parse(readUrl(movieNm,directorNm));
         JSONObject json =  (JSONObject) jsonobject.get("movieListResult");
         
         
         
         JSONArray array = (JSONArray)json.get("movieList");
         JSONObject entity; 
         for(int i = 0 ; i < array.size(); i++){
             
             entity = (JSONObject)array.get(i);
             
             
             String searchMovieNm = (String) entity.get("movieNm");
             String searchMovieCd = (String) entity.get("movieCd");
             resultMovieCd.add(searchMovieCd);
             System.out.print("영화제목:"+searchMovieNm);
             System.out.println("\t 검색번호:"+(i+1));
             System.out.println("영화코드:"+searchMovieCd);
         }
         
         
         
         
    }
    private static String readUrl(String movieNm, String directorNm) throws Exception {
        BufferedInputStream reader = null;
        
        		
        
        try {
            URL url = new URL(
                    "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/"
                    + "searchMovieList.json"
                    + "?key=a309b67551381f6d67e36146583e52dd"
                    + "&movieNm="+movieNm+"&directorNm="+directorNm);
            	
            System.out.println("http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/"
                    + "searchMovieList.json"
                    + "?key=a309b67551381f6d67e36146583e52dd"
                    + "&movieNm="+movieNm+"&directorNm="+directorNm);
            		
            
            reader = new BufferedInputStream(url.openStream());
            StringBuffer buffer = new StringBuffer();
            int i;
            byte[] b = new byte[4096];
            while( (i = reader.read(b)) != -1){
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