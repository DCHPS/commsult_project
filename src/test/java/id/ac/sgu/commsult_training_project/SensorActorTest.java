package id.ac.sgu.commsult_training_project;

public class SensorActorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Blinds blinds = new Blinds();
		TimeSensor timeSensor = new TimeSensor(17);
		AirCon airCon = new AirCon();
		TemperatureSensor tempSensor = new TemperatureSensor(15);
		
		MainController controller = new MainController(timeSensor,tempSensor,blinds,airCon);
		
		/*
		controller.timeController(timeSensor);
		controller.blindController(blinds);
		controller.temperatureController(tempSensor);
		controller.airConController(airCon);
		*/
		
		timeSensor.setValue(0);
		tempSensor.setValue(11);
	}

}
