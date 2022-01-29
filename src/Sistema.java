
public class Sistema {
	public static final int LIBERA_COUNT = 100;
	public static final int RESERVA_COUNT = 100;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < LIBERA_COUNT; i++) {
			new Libera();
		}
		
		for(int i=0; i<RESERVA_COUNT; i++) {
			new Reserva();
		}
	}

}

