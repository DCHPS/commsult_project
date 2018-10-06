package id.ac.sgu.commsult_training_project;

public class TimeSensor implements Sensor {
	private int time;

	public TimeSensor(int initialValue) {
		time = initialValue;
	}

	@Override
	public void setValue(int newValue) {
		time = newValue;
	}

	@Override
	public int getValue() {
		return time;
	}

}
