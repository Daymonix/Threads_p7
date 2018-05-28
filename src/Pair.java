
public class Pair<T1, T2> {
	private T1 e1 = null;
	private T2 e2 = null;
	
	public Pair(T1 e1, T2 e2) {
		this.e1 = e1;
		this.e2 = e2;
	}
	
	public T1 element1 () {
		return e1;
	}
	
	public T2 element2 () {
		return e2;
	}
}
