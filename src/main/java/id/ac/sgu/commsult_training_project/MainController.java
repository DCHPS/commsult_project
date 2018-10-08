package id.ac.sgu.commsult_training_project;

import java.util.Observable;
import java.util.Observer;

public class MainController implements Observer {
	private Observable timeSensor;
	private Observable tempSensor;

	private int currentTime;
	private int currentTemp;

	private Blinds blinds;
	private AirCon airCon;

	public MainController(TimeSensor timeSensor, TemperatureSensor tempSensor, Blinds blinds, AirCon airCon) {
		this.timeSensor = timeSensor;
		this.tempSensor = tempSensor;
		this.blinds = blinds;
		this.airCon = airCon;

		currentTime = timeSensor.getValue();
		currentTemp = tempSensor.getValue();

		tempSensor.addObserver(this);
		timeSensor.addObserver(this);

		printStatus();
	}

	public boolean getBlindStatus() {
		return blinds.getStatus();
	}

	public int getAirConTemp() {
		return airCon.getStatus();
	}

	public int getCurrentTime() {
		return currentTime;
	}
	
	public int getCurrentTemp() {
		return currentTemp;
	}

	public void setTimeController(TimeSensor timeSensor) {
		this.timeSensor = timeSensor;
		currentTime = timeSensor.getValue();
		timeSensor.addObserver(this);
	}

	public void setBlindController(Blinds blinds) {
		this.blinds = blinds;
	}

	public void setTemperatureController(TemperatureSensor tempSensor) {
		this.tempSensor = tempSensor;
		currentTemp = tempSensor.getValue();
		tempSensor.addObserver(this);
	}

	public void setAirConController(AirCon airCon) {
		this.airCon = airCon;
	}

	@Override
	public void update(Observable obs, Object arg) {
		// TODO Auto-generated method stub
		if (obs instanceof TemperatureSensor) {
			TemperatureSensor currentSensor = (TemperatureSensor) obs;
			currentTemp = currentSensor.getValue();
			updateAirCon(currentTemp);
		}
		if (obs instanceof TimeSensor) {
			TimeSensor currentSensor = (TimeSensor) obs;
			currentTime = currentSensor.getValue();
			updateBlinds(currentTime);
		}
		printStatus();

	}

	private void updateBlinds(int time) {
		boolean blindsIsUp;
		if (isDay(time)) {
			blindsIsUp = true;
		} else {
			blindsIsUp = false;
		}
		blinds.setStatus(blindsIsUp);

	}

	private void updateAirCon(int currentTemp) {
		int setTemp;
		if (currentTemp < 5) {
			setTemp = 20;
		} else if (currentTemp > 30) {
			setTemp = 16;
		} else {
			setTemp = 18;
		}

		airCon.setStatus(setTemp);

	}

	private void printStatus() {
		// TODO Auto-generated method stub
		System.out.println("Current temperature: " + currentTemp);
		System.out.println("Current time: " + String.format("%04d", currentTime));
		System.out.println("Blinds are up: " + blinds.getStatus());
		System.out.println("Air conditioner temperature: " + airCon.getStatus());
		System.out.println();
	}

	private boolean isDay(int time) {
		return time >= 600 && time <= 1800;
	}

}
