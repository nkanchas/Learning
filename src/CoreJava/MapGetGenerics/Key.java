package CoreJava.MapGetGenerics;

public class Key<T> {
	final String identifier;
	final Class<T> type;
	
	/*public static void Key2(String identifier, Class type){
		identifier = identifier;
		type = type;
	}*/
	
	public Key(String identifier, Class<T> type){
		this.identifier = identifier;
		this.type = type;
	}

	/*@Override
	public int hashCode() {
		int hash = 3;
		hash = 7* hash + this.identifier.hashCode();
		hash = 7*hash + this.type.hashCode();
		
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if(obj == null || obj.getClass() != getClass())
			result=false;
		else{
		    Key k = (Key) obj;
		    
		    if(identifier == k.identifier && type == k.type)
		    	result = true;
		    	
		}
		
		
		return result;
	}
*/
	public String getIdentifier() {
		return identifier;
	}

	public Class<T> getType() {
		return type;
	}
	
	
	
	
	

}
