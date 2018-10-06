package id.ac.sgu.commsult_training_project;

public class SensorActorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainController controller = new MainController();
		Blinds blinds = new Blinds();
		TimeSensor timeSensor = new TimeSensor(1200);
		AirCon airCon = new AirCon();
		TemperatureSensor tempSensor = new TemperatureSensor(2);
		
		controller.timeController(timeSensor);
		controller.blindController(blinds);
		controller.temperatureController(tempSensor);
		controller.airConController(airCon);
	
		controller.updateBlinds();
		controller.updateAirCon();
		
		controller.printStatus();
		
	}

}
