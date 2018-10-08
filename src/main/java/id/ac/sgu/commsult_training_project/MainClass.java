package id.ac.sgu.commsult_training_project;
import java.awt.*;
import javax.swing.*;

public class MainClass extends Frame {
	
	public MainClass(MainController mc) {
		JFrame simpleGUI = new JFrame();
		
		simpleGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		simpleGUI.setTitle("AC & Blinds for Days Boii V:");
		simpleGUI.setSize(300, 250);
		simpleGUI.setLocationRelativeTo(null);
		
		JPanel simplePanel = new JPanel();
		
		JLabel temp = new JLabel("The AC Temperature is: ");
		JLabel blind = new JLabel("The Blinds are: ");
		
		GridLayout myLayout = new GridLayout(2,0);
		simplePanel.setLayout(myLayout);
		
		simplePanel.add(temp);
		
		simplePanel.add(blind);
		
		simpleGUI.add(simplePanel);
		simpleGUI.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TimeSensor timeSensor = new TimeSensor(30);
		TemperatureSensor tempSensor = new TemperatureSensor(30);
		Blinds blind = new Blinds();
		AirCon airCon = new AirCon();
		MainController mc = new MainController(timeSensor, tempSensor, blind, airCon);
		
		//new MainClass();
	}

}
