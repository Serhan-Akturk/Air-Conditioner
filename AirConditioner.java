package edu.cuny.csi.csc330.lab4;

import java.util.*;
import edu.cuny.csi.csc330.util.Randomizer;

public class AirConditioner 
{
	//Static consts
	private final static int MAX_TEMP = 80;
	private final static int MIN_TEMP = 50;
	private final static int DEFAULT_TEMP = 60;

	//Object Instance Properties
	private boolean powerState; //On or off
	private Date firstTimeOn;
	private Date lastTimeOn;
	private String serialNumber;
	private int temperature; //Current temperature to cool to
	private String mode; //Different modes: Normal / Eco / Fan
	private String speed; //Different speeds: Low / Medium / High / Very High

	//Only constructor 
	public AirConditioner()
	{
		init();
	}

	private void init() //Creates serial number
	{
		Integer irand = Randomizer.generateInt(11111111, 99999999);
		this.serialNumber = new Date().getTime() + ":" + irand.toString();
	}

	public void on()
	{
		Date now = new Date();
		if (firstTimeOn == null) //First time use check
		{
			temperature = DEFAULT_TEMP;
			mode = "Normal";
			speed = "Low";
			firstTimeOn = now;
		}
		powerState = true;
		lastTimeOn = now;
	}

	public void off() 
	{
		powerState = false;
		speed = null; //Changes speed and mode to null when turned off
		mode = null;
		
	}

	public void setTemperature(int x)
	{
		if ((x < MAX_TEMP) && (x > MIN_TEMP))
			temperature = x;
		else
			System.err.println("Out of range! Set a temperature between: " + MAX_TEMP + " - " + MIN_TEMP);
	}

	public int getTemperature()
	{
		return temperature;
	}
	
	public void setMode() //Switches to next mode
	{
		if (mode == "Normal")
			mode = "Eco";
		else if (mode == "Eco")
			mode = "Fan";
		else if (mode == "Fan")
			mode = "Normal";
		else if (mode == null)
			mode = "Normal";
	}
	
	public String getMode()
	{
		return mode;
	}

	public void increaseTemp() //Increment temperature by 1
	{
		if ((temperature < MAX_TEMP) && (temperature > MIN_TEMP))
			temperature++;
		else
			System.err.println("Out of range! Set a temperature between: " + MAX_TEMP + " - " + MIN_TEMP);
	}

	public void decreaseTemp() //Decrement temperature by 1
	{
		if ((temperature < MAX_TEMP) && (temperature > MIN_TEMP))
			temperature--;
		else 
			System.err.println("Out of range! Set a temperature between: " + MAX_TEMP + " - " + MIN_TEMP);
	}
	
	public void setSpeed() //Switches to next speed
	{
		if(speed == "Low")
			speed = "Medium";
		else if(speed == "Medium")
			speed = "High";
		else if(speed == "High")
			speed = "Very high";
		else if(speed == "Very High")
			speed = "Low";
		else if(speed == null)
			speed = "Low";
	}
	
	public String getSpeed()
	{
		return speed;
	}
	
	//Displays the instances of each variable
	public String toString() {
		return "Air Condition Instance: " 
				+ "SerialNumber=" + serialNumber + ", " 
				+ "\npowerState= " + powerState + ", "
				+ "\nfirstTimeOn= " + firstTimeOn + ", " 
				+ "\nlastTimeOn= " + lastTimeOn + ", " 
				+ "\nmode= "+ mode + ", " 
				+ "\ntemperature= " + temperature + ", "
				+ "\nspeed= " + speed;
	}
	
	public static void main(String[] args) 
	{
		AirConditioner ac = new AirConditioner();
		int counter = 1; //Keep track amount of outputs 

		//First instance
		System.out.println("Display " + counter++ + ":\n" + ac + "\n");
		
		ac.on();
		System.out.println("Display " + counter++ + ": Turned on\n" + ac + "\n");
		
		ac.increaseTemp();
		System.out.println("Display " + counter++ + ": Increased Temperature by 1\n" + ac + "\n");
		
		ac.decreaseTemp();
		System.out.println("Display " + counter++ + ": Decreased Temperature by 1\n" + ac + "\n");
		
		ac.setTemperature(79);
		System.out.println("Display " + counter++ + ": Changed Temperature\n" + ac + "\n");
		
		ac.setMode();
		System.out.println("Display " + counter++ + ": Changed mode\n" + ac + "\n");
		
		ac.setSpeed();
		System.out.println("Display " + counter++ + ": Changed speed\n" + ac + "\n");
		
		ac.off();
		System.out.println("Display " + counter++ + ": Turned off\n" + ac + "\n");
	}

}
