package CoreJava.MapGetGenerics;

import java.util.HashMap;
import java.util.Map;

public class Context {
	
	private final Map<Key<?>, Object> map = new HashMap<>();
	
	
	public void put(Key<?> key, Object value){
		 map.put(key, value);		
	}
	
	public <T> T get(Key<T> key){
		  return  key.type.cast(map.get(key));
	}

}
