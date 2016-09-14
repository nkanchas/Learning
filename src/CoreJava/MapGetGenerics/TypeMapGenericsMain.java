package CoreJava.MapGetGenerics;

public class TypeMapGenericsMain {

	public static void main(String[] args) {
		Runnable r1 = new ARunnable();
		Key key1 = new Key("id1", Runnable.class);
		
		Runnable r2 = new BRunnable();
		Key key2 = new Key("id2", Runnable.class);
		
		
		Context ctx = new Context();
		ctx.put(key1, r1);
		ctx.put(key2, r2);
		
		
		Runnable myrun = ctx.get(key2);
		
		Thread t1 = new Thread(myrun);
		t1.start();

	}

}
