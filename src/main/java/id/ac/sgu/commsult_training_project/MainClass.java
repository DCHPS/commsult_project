package id.ac.sgu.commsult_training_project;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class MainClass extends Frame {
	static JLabel temp = new JLabel();
	JLabel blind = new JLabel();
	
	public MainClass(MainController mc) {
		JFrame simpleGUI = new JFrame();
		
		simpleGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		simpleGUI.setTitle("AC & Blinds for Days Boii V:");
		simpleGUI.setSize(300, 250);
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
		boolean thereisNoGod = true;
		TimeSensor timeSensor = new TimeSensor();
		TemperatureSensor tempSensor = new TemperatureSensor(30);
		Blinds blind = new Blinds();
		AirCon airCon = new AirCon();
		MainController mc = new MainController(timeSensor, tempSensor, blind, airCon);
		
		MainClass og = new MainClass(mc);
		
		while (thereisNoGod)
		{
			setAll(mc);
		}
		
	}
	
	private static void setAll(MainController mc) {
		// TODO Auto-generated method stub
		int currentTemperature = getRandom(100);
		int currentTime = mc.getCurrentTime();
		
		mc.set
		
		temp.setText("The AC Temperature is: ");	
	}
	
	public static int getRandom(int max){
        return (int) (Math.random()*max);
    }

}
