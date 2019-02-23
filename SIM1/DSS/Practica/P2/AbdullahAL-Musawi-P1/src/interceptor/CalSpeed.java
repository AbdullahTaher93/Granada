package interceptor;

public class CalSpeed implements Filter {
private double INTERVAL;
	
	public CalSpeed() {
		INTERVAL = 14.27;
	}

	@Override
	public double Exe(Object o) {
		double distance = (Double) o;
		double speed = distance * 3600 / INTERVAL;
		return speed;
	}

}
