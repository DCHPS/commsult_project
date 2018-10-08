package id.ac.sgu.commsult_training_project;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class MainClass extends Frame {
	static JButton temp = new JButton();
	static JButton blind = new JButton();
	
	public MainClass(MainController mc) {
		JFrame simpleGUI = new JFrame();
		
		simpleGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		simpleGUI.setTitle("AC & Blinds for Days Boii V:");
		simpleGUI.setSize(500, 600);
		simpleGUI.setLocationRelativeTo(null);
		
		JPanel simplePanel = new JPanel();
		
		temp.setText("The AC Temperature is: "+mc.getAirConTemp());
		blind.setText("The Blinds are up: "+mc.getBlindStatus());
		
		GridLayout myLayout = new GridLayout(2,0);
		simplePanel.setLayout(myLayout);
		
		simplePanel.add(temp);
		
		simplePanel.add(blind);
		
		simpleGUI.add(simplePanel);
		simpleGUI.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimeSensor timeSensor = new TimeSensor();
		TemperatureSensor tempSensor = new TemperatureSensor(30);
		Blinds blind = new Blinds();
		AirCon airCon = new AirCon();
		MainController mc = new MainController(timeSensor, tempSensor, blind, airCon);
		
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
	
	static int getRandom() {
	    return generator.nextInt()*5;
	}

}
