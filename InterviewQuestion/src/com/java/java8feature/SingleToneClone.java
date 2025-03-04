package interview;

public class SingleToneClone implements Cloneable {

	private static SingleToneClone instance=null;
	
	private SingleToneClone() {}
	public SingleToneClone getSingleTone() {
		if(instance==null) {
			instance= new SingleToneClone();
		}
		return instance;
	}
	protected Object clone()throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
}
