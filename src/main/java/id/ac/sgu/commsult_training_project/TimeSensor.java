package id.ac.sgu.commsult_training_project;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeSensor extends Sensor {
	private int time;

	public TimeSensor() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HHmm");
		Date date = new Date();
		
		time = Integer.parseInt(dateFormat.format(date));
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
