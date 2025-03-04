package interview;

public class SingleTone {

	private static SingleTone instance=null;
	
	private SingleTone() {}
	public SingleTone getSingleTone() {
		if(instance==null) {
			instance= new SingleTone();
		}
		return instance;
	}
}
