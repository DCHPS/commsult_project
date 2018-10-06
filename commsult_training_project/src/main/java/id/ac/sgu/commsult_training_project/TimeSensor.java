package id.ac.sgu.commsult_training_project;

public class TimeSensor implements Sensor{
	private int time;
	public TimeSensor(int initialValue) {
		time = initialValue;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setValue(int newValue) {
		// TODO Auto-generated method stub
		time = newValue;
	}
	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return time;
	}

	
}
