package interview;

public class SingleToneReflection implements Cloneable {

	private static SingleToneReflection instance=null;
	
	private SingleToneReflection() {}
	public SingleToneReflection getSingleTone() {
		if(instance==null) {
			instance= new SingleToneReflection();
		}
		return instance;
	}
	@Override
	protected Object clone()throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
}
