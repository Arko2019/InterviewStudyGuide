package interview;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SingleToneSerilization implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static SingleToneSerilization instance=null;
	
	private SingleToneSerilization() {}
	public SingleToneSerilization getSingleTone() {
		
		if(instance==null) {
			instance= new SingleToneSerilization();
		}
		return instance;
	}
	protected Object readResolver() {
		return instance;
	}
	
}
