import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Buffer {
	private static ConcurrentLinkedQueue<Integer> store = new ConcurrentLinkedQueue<Integer>();
	public static final int bSize = Integer.MAX_VALUE;
	private static Semaphore sNoVacio = new Semaphore(0,true);
	private static Semaphore sNoLLeno = new Semaphore(bSize,true);
	
	public static Queue<Integer> getStore() {
		return store;
	}
	
	public static void setStore(ConcurrentLinkedQueue<Integer> store) {
		Buffer.store = store;
	}
	
	public static Semaphore getsNoVacio() {
		return sNoVacio;
	}
	
	public static void setsNoVacio(Semaphore sNoVacio) {
		Buffer.sNoVacio = sNoVacio;
	}
	
	public static Semaphore getsNoLLeno() {
		return sNoLLeno;
	}
	
	public static void setsNoLLeno(Semaphore sNoLLeno) {
		Buffer.sNoLLeno = sNoLLeno;
	}
	
	
	
	
	
}
