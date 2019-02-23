package interceptor;

public class CalDistance implements Filter {
	private double RADIO;
	private double revo;
	
	public CalDistance() {
		RADIO = 4.86;
		revo = 0.0;
	}
	
	

	@Override
	public double Exe(Object o) {
		double rev = (Double) o;
		double dis = (rev - revo) * 2 * RADIO * Math.PI;
		revo = rev;
		return dis;
	}

}
