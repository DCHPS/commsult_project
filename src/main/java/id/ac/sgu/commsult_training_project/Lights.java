package id.ac.sgu.commsult_training_project;

public class Lights {
	private boolean isOn;

	public Lights()
	{
		isOn = true;
	}
	
	public void setStatus(boolean isOn) {
		this.isOn = isOn;
	}
	
	public boolean getStatus() {
		return isOn;
	}
}
