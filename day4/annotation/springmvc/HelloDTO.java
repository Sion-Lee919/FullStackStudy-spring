package annotation.springmvc;

public class HelloDTO {
	String message;

	public HelloDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public HelloDTO(String message) {
		super();
		this.message = message;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
