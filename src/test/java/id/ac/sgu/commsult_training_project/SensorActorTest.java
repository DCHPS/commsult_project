package id.ac.sgu.commsult_training_project;

public class SensorActorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Blinds blinds = new Blinds();
		System.out.println();
		
		TimeSensor timeSensor = new TimeSensor();
		
		AirCon airCon = new AirCon();
		TemperatureSensor tempSensor = new TemperatureSensor(15);
		
		MainController controller = new MainController(timeSensor,tempSensor,blinds,airCon);
		
		//timeSensor.setValue(300);
		//
		

		tempSensor.setValue(11);
		while(true)
		{
			
		}
	}

}
