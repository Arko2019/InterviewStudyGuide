package interview;

import java.util.HashMap;
import java.util.Map;

final class Immutable{
	 // Member attributes of final class
   private final String name;
   private final int regNo;
   private final Map<String, String> metadata;
	Immutable(String name, int regNo,
           Map<String, String> metadata){
		this.name=name;
		this.regNo=regNo;
		Map<String,String>temp=new HashMap<>();
		for(Map.Entry<String,String> entry:metadata.entrySet()) {
			temp.put(entry.getKey(), entry.getValue());
		}
		this.metadata=temp;	
	}
	public String getName() {
		return name;
	}
	public int getRegNo() {
		return regNo;
	}
	public Map<String, String> getMetadata() {
		Map<String,String>temp=new HashMap<>();
		for(Map.Entry<String,String> entry:metadata.entrySet()) {
			temp.put(entry.getKey(), entry.getValue());
		}
		
		return temp;
	}
	
}