package id.ac.sgu.commsult_training_project;

public class TimeSensor extends Sensor {
	private int time;

	public TimeSensor(int initialValue) {
		time = initialValue;
	}

	@Override
	public void setValue(int newValue) {
		time = newValue;
		setChanged();
		notifyObservers();
	}

	@Override
	public int getValue() {
		return time;
	}

}
