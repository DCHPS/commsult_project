package id.ac.sgu.commsult_training_project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimeSensor extends Sensor {
	private int time;

	public TimeSensor() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HHmm");
		Date date = new Date();
		time = Integer.parseInt(dateFormat.format(date));
		//timer.scheduleAtFixedRate(new setValueTask(), new Date(), 1000);
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
	
	/*
	static class setValueTask extends TimerTask {
		public void run() {
			System.out.println("test");
			setValue(time++);
		}
	}
	*/

}
