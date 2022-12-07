package exceptions;

public class NoFolderException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoFolderException() {}
	public NoFolderException(String message) {
		super(message);
	}
	
	public NoFolderException(Throwable cause) {
		super(cause); 
	}
	
	public NoFolderException(String message, Throwable cause) {
		super(message, cause);
	}

}
