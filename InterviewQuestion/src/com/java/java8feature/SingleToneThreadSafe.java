package interview;

public class SingleToneThreadSafe {

	private static SingleToneThreadSafe instance;

	private SingleToneThreadSafe() {
	}

	SingleToneThreadSafe getInstance() {
		if (instance == null) {
			synchronized (SingleToneThreadSafe.class) {
				if (instance == null) {
					instance = new SingleToneThreadSafe();
				}
			}
		}
		return instance;
	}

}
