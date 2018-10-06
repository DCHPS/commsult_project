package id.ac.sgu.commsult_training_project;

public class MainController {
	private Sensor timeSensor;
	private Sensor tempSensor;

	private Blinds blinds;
	private AirCon airCon;

	public void timeController(TimeSensor timeSensor) {
		this.timeSensor = timeSensor;
	}

	public void blindController(Blinds blinds) {
		this.blinds = blinds;
	}

	public void temperatureController(TemperatureSensor tempSensor) {
		this.tempSensor = tempSensor;
	}

	public void airConController(AirCon airCon) {
		this.airCon = airCon;
	}

	public void updateBlinds() {
		int time = timeSensor.getValue();
		boolean blindsIsUp;
		if (isDay(time)) {
			blindsIsUp = true;
		} else {
			blindsIsUp = false;
		}
		blinds.setStatus(blindsIsUp);

	}

	public void updateAirCon() {
		int currentTemp = tempSensor.getValue();
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

	public void printStatus() {
		// TODO Auto-generated method stub
		System.out.println("Blinds are up: " + blinds.getStatus());
		System.out.println("Air conditioner temperature: " + airCon.getStatus());
	}

	private boolean isDay(int time) {
		return time >= 600 && time <= 1800;
	}

}
