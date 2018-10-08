package id.ac.sgu.commsult_training_project;

public class TemperatureSensor extends Sensor {
	private int temp;

	public TemperatureSensor(int temp) {
		this.temp = temp;
	}

	public void setValue(int temp) {
		this.temp = temp;
		setChanged();
		notifyObservers();

	}

	public int getValue() {
		return temp;
	}

}
