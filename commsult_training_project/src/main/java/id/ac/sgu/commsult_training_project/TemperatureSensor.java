package id.ac.sgu.commsult_training_project;

public class TemperatureSensor implements Sensor{
	private int temp;
	public TemperatureSensor(int temp ) {
		this.temp = temp	;
	}


	public void setValue(int temp) {
		this.temp = temp	;
		
	}


	public int getValue() {
		// TODO Auto-generated method stub
		return temp;
	}

}
