package id.ac.sgu.commsult_training_project;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class MainClass extends Frame {
	
	static TimeSensor timeSensor = new TimeSensor();
	static TemperatureSensor tempSensor = new TemperatureSensor(30);
	
	static Blinds blinds = new Blinds();
	static AirCon airCon = new AirCon();
	static Lights light = new Lights();
	
	static MainController mc = new MainController(timeSensor, tempSensor, blinds, airCon, light);
	
	
	static JLabel temp = new JLabel();
	static JLabel blind = new JLabel();
	static JLabel lamp = new JLabel();
	
	public MainClass(MainController mc) {
		JFrame simpleGUI = new JFrame();
		
		JButton lampButton = new JButton("Turn On Lights");
		lampButton.addActionListener(new turnLights());
		
		simpleGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		simpleGUI.setTitle("AC & Blinds for Days Boii V:");
		simpleGUI.setSize(500, 600);
		simpleGUI.setLocationRelativeTo(null);
		
		JPanel simplePanel = new JPanel();
		
		temp.setText("The AC Temperature is: "+mc.getAirConTemp());
		blind.setText("The Blinds are up: "+mc.getBlindStatus());
		lamp.setText("Lights are on: "+mc.getLights());
		
		GridLayout myLayout = new GridLayout(3,0);
		simplePanel.setLayout(myLayout);
		
		simplePanel.add(temp);
		
		simplePanel.add(blind);
		
		simplePanel.add(lamp);
		
		simpleGUI.add(simplePanel, BorderLayout.NORTH);
		simpleGUI.add(lampButton, BorderLayout.CENTER);
		simpleGUI.setVisible(true);
		
		
	}
	
	private static Random generator = new Random();
	
	
	private static void setAll(MainController mc) {
		// TODO Auto-generated method stub
		int currentTemperature = getRandom();
		
		int currentTime = mc.getCurrentTime();
		
		mc.setTime(currentTime);
		mc.setTemp(currentTemperature);
		
		temp.setText("The AC Temperature is: " + mc.getAirConTemp());
		blind.setText("The Blinds are up: " + mc.getBlindStatus());
	}

	public class turnLights implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (lightsAreOn())
			{
				mc.setLights(true);
				
				} else {
					mc.setLights(false);
				}
			lamp.setText("Lights are on: " + mc.getLights());
		}

		private boolean lightsAreOn() {
			return mc.getLights() == false;
		}
		
	}
	
	static int getRandom() {
	    return generator.nextInt()*5;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainClass og = new MainClass(mc);
		
		try {
			while (true)
			{
				setAll(mc);
				Thread.sleep(1 * 1000);
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
