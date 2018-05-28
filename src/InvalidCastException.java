

public class InvalidCastException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3821719343305423284L;

	public InvalidCastException() {
		super("Invalid string value for data conversion.");
	}
	
	public InvalidCastException(String m) {
		super("Invalid string value for data conversion. Additional information: " + m);
	}
}
