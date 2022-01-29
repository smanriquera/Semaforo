import java.util.Random;

public class Libera extends Thread {
	
	private static int liberaCount = 0;
	private int liberaId;
	
	
	public Libera() {
		liberaId = ++liberaCount;
		start();
	}
	
	private void produce() {
		 Random rdmNum = new Random();
		 int numP = rdmNum.nextInt(999) + 1;
		 int sleepTime = rdmNum.nextInt(250 - 25 + 1) + 25; //rango (max - min + 1) +  min
		 
		 try {
			sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 System.out.println("Libera("+ liberaId +"): --libero , de golpe, "+ numP +" unidades del recurso que previamente  se me habian concedido. ");
		 
		 //añadir al buffer
		 Buffer.getStore().add(numP);
		 
	}
	
	public void run() {
		
		while(true) {
			
			if (Buffer.getStore().size() == Buffer.bSize) {
				System.out.println("Libera(" + liberaId +"):-- El Buffer esta lleno, esperando a que alguien reserve sus recursos");
			}
			try {
				Buffer.getsNoLLeno().acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			produce();
			
			Buffer.getsNoVacio().release();
		}
	}
	

}