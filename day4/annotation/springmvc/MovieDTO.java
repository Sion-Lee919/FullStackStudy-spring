package annotation.springmvc;

public class MovieDTO {
	String id,pw;
	int age;
	String[] moviemap;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String[] getMoviemap() {
		return moviemap;
	}
	public void setMoviemap(String[] moviemap) {
		this.moviemap = moviemap;
	}
	
}
