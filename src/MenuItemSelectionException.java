

public class MenuItemSelectionException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5104077789231958814L;

	public MenuItemSelectionException() {
		super("Invalid menu item selection.");
	}
	
	public MenuItemSelectionException(String m) {
		super("Invalid menu item selection. Additional information: " + m);
	}

}
