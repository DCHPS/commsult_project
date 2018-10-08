package id.ac.sgu.commsult_training_project;

import java.util.Observable;
import java.util.Observer;

public class MainController implements Observer {
	private TimeSensor timeSensor;
	private TemperatureSensor tempSensor;

	private Blinds blinds;
	private AirCon airCon;
	private Lights lights;
	
	public MainController(TimeSensor timeSensor, TemperatureSensor tempSensor, Blinds blinds, AirCon airCon, Lights lights) {
		this.timeSensor = timeSensor;
		this.tempSensor = tempSensor;
		this.blinds = blinds;
		this.airCon = airCon;
		this.lights = lights;
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
		return timeSensor.getValue();
	}
	
	public int getCurrentTemp() {
		return tempSensor.getValue();
	}

	
	public void setTimeController(TimeSensor timeSensor) {
		this.timeSensor = timeSensor;
		timeSensor.addObserver(this);
	}

	public void setBlindController(Blinds blinds) {
		this.blinds = blinds;
	}

	public void setTemperatureController(TemperatureSensor tempSensor) {
		this.tempSensor = tempSensor;
		tempSensor.addObserver(this);
	}

	public void setAirConController(AirCon airCon) {
		this.airCon = airCon;
	}
	
	public void setTime(int time){
		timeSensor.setValue(time);
	}
	
	public void setTemp(int temp) {
		tempSensor.setValue(temp);
	}
	
	public void setLights(boolean isOn) {
		lights.setStatus(isOn);
	}
	
	public boolean getLights() {
		return lights.getStatus();
	}
	
	@Override
	public void update(Observable obs, Object arg) {
		// TODO Auto-generated method stub
		if (obs instanceof TemperatureSensor) {
			updateAirCon(tempSensor.getValue());
		}
		if (obs instanceof TimeSensor) {
			updateBlinds(timeSensor.getValue());
		}

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
		System.out.println("Current temperature: " + getCurrentTemp());
		System.out.println("Current time: " + String.format("%04d", getCurrentTime()));
		System.out.println("Blinds are up: " + getBlindStatus());
		System.out.println("Air conditioner temperature: " + getAirConTemp());
		System.out.println();
	}

	private boolean isDay(int time) {
		return time >= 600 && time <= 1800;
	}

}
