package exceptions;

public class FolderAlreadyExistExcpetion extends Exception {
	
	private static final long serialVersionUID = 1L;

	public FolderAlreadyExistExcpetion() {}
	public FolderAlreadyExistExcpetion(String message) {
		super(message);
	}
	
	public FolderAlreadyExistExcpetion(Throwable cause) {
		super(cause); 
	}
	
	public FolderAlreadyExistExcpetion(String message, Throwable cause) {
		super(message, cause);
	}

}
