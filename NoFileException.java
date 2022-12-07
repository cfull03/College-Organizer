package exceptions;

public class NoFileException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoFileException() {}
	public NoFileException(String message) {
		super(message);
	}
	
	public NoFileException(Throwable cause) {
		super(cause); 
	}
	
	public NoFileException(String message, Throwable cause) {
		super(message, cause);
	}

}
