import java.util.Scanner;

public class CalculatorThread {

	private static int[] menuItems = new int[] {1};
	
	private static int[] ops = new int[] {1, 2, 3};
	
	private static int toInt(String s) throws InvalidCastException {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			throw new InvalidCastException("The value '" + s + "' cannot be converted to int");
		}
	}
	
	private static int getMenuItemSelection(int i, int[] menuItems) throws MenuItemSelectionException {
		int r = -1;
		for(int x : menuItems) {
			if(x == i) {
				r = i;
				break;
			}
		}
		
		if(r < 0) {
			throw new MenuItemSelectionException("No such menu item ('" + i + "')");
		}
		return r;
	}
	
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			
			boolean loop = true;
			while (loop) {
				try {
					System.out.print("Menu: " + menuItems[0] + " - Enter arguments: ");
					String input = sc.nextLine();
					
					int mi = getMenuItemSelection(toInt(input), menuItems);
					
					if(mi == menuItems[0]) {
						System.out.print("Enter argument: ");
						String inp = sc.nextLine();
						int a = toInt(inp);
						
						System.out.print("Enter threads count: ");
						inp = sc.nextLine();
						int t = toInt(inp);
						
						System.out.print("Enter operator: " + ops[0] + " - for '+', " + ops[1] + " - for '-', " + ops[2] + " - for '*': ");
						inp = sc.nextLine();
						int op = getMenuItemSelection(toInt(inp), ops);
						
						System.out.println(a + " " + t + " " + op);
						
						Pair<Integer, Integer> p = new ThreadGenerator(a, t, op).getResult();
						System.out.println("Math result: " + p.element1() + "; Operation result: " + p.element2());
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			sc.close();
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println(e.fillInStackTrace());
		}
	}
	
	
	
}