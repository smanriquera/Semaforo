import java.util.Random;

public class Reserva extends Thread {
	
	private static int reservaCount = 0;
	private int reservaId;
	
	
	public Reserva() {
		reservaId = ++reservaCount;
		start();
	}
	
	public void consume() {
		Random rdmNum =  new  Random();
		 int sleepTime = rdmNum.nextInt(250 - 25 + 1) + 25;
		 
		 try {
			sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 //Consumir el elemento
		 int reservaNum = Buffer.getStore().poll();
		 System.out.println("Reservar("+ reservaId + "):--necesito que se me concedan, de golpe "+ reservaNum +" unidades del recurso.");
		
	}
	@Override
	public void run() {
		
		while(true) {
			
			if(Buffer.getStore().size() == 0) {
				
				System.out.println("Reservar("+ reservaId +"): --El Buffer esta vacio, esperando a que alguien libere recursos.");
			}
			
			try {
				Buffer.getsNoVacio().acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			consume();
			Buffer.getsNoLLeno().release();
		}
		
	}

}

