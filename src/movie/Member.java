package movie;


import java.io.Serializable;
import java.util.ArrayList;

public class Member implements Serializable{
	private String name, birth, phoneNum, eMail, id, password;
	private ArrayList<BookMovie> movieTicket = new ArrayList<BookMovie>();
	
	public Member() {}

	public Member(String name, String birth, String phoneNum, String eMail, String id, String password) {
		super();
		this.name = name;
		this.birth = birth;
		this.phoneNum = phoneNum;
		this.eMail = eMail;
		this.id = id;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<BookMovie> getMovieTicket() {
		return movieTicket;
	}

	public void setMovieTicket(ArrayList<BookMovie> movieTicket) {
		this.movieTicket = movieTicket;
	}

	

}
