package cache;

import java.util.concurrent.TimeUnit;

public class ClientThread implements Runnable {
	 
    //private Logger LOG = LoggerFactory.getLogger(ClientThread.class);
 
    private TTLCache<String, String> cache;
 
    public ClientThread(TTLCache<String, String> cache) {
        this.cache = cache;
    }
 
    @Override
    public void run() {
        try {
 
            for (int i = 0; i < 10; i++) {
                cache.put("key-" + i, "value-" + i);
            }
            
            TimeUnit.SECONDS.sleep(1);
 
            for (int i = 0; i < 5; i++) {
                print(i);
            }
 
            TimeUnit.SECONDS.sleep(5);
 
            for (int i = 5; i < 8; i++) {
                print(i);
            }
 
            TimeUnit.SECONDS.sleep(7);
 
            for (int i = 8; i < 10; i++) {
                print(i);
            }
 
        } catch (InterruptedException ie) {
           // LOG.error("Error: " + ie);
        }
 
    }
 
    private void print(int i) {
       System.out.println(Thread.currentThread().getName() + ": key-" + i + " = "
               + cache.get("key-" + i));
    }
 
}
