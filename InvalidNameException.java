package exceptions;

public class InvalidNameException extends Exception {

	private static final long serialVersionUID = 1L;
	
	
	public InvalidNameException() {}
	public InvalidNameException(String message) {
		super(message);
	}
	
	public InvalidNameException(Throwable cause) {
		super(cause); 
	}
	
	public InvalidNameException(String message, Throwable cause) {
		super(message, cause);
	}

}