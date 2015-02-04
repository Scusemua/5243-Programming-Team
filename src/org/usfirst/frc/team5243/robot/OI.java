package org.usfirst.frc.team5243.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DigitalInput;

import org.usfirst.frc.team5243.robot.commands.StrafeCommand;

import org.usfirst.frc.team5243.robot.subsystems.CameraSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.MotorSubsystem;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    private Joystick leftStick = new Joystick(RobotMap.leftJoystick); 
    private Joystick rightStick = new Joystick(RobotMap.rightJoystick);
	private Button strafeTriggerLeft = new JoystickButton(leftStick, 1); 
	private Button strafeTriggerRight = new JoystickButton(rightStick, 1);
    
    //Entering test things Austin was doing
	private Button testButton = new JoystickButton(rightStick,7);
	
	private Button speedUp= new JoystickButton(leftStick,3);
	private Button slowDown= new JoystickButton(leftStick,2);
	private Button leftStrafe = new JoystickButton(rightStick, 4);
	private Button rightStrafe = new JoystickButton(rightStick, 5);
	private Button resetButton = new JoystickButton(rightStick,2);
	
	public Button getSpeedButton(){
		return speedUp;
	}
	public Button getSlowButton(){
		return slowDown;
	}
	public Button getLeftStrafe(){
		return leftStrafe;
	}
	public Button getRightStrafe(){
		return rightStrafe;
	}
    public Button getResetButton(){
    	return resetButton;
    }
    public Button getTestButton(){
    	return testButton;
    }
    
    //Exiting test things Austin was doing
	
	private StrafeCommand strafeCommand = new StrafeCommand();
	
	public static CameraSubsystem cameraSubsystem = new CameraSubsystem();
	public static MotorSubsystem motorSubsystem = new MotorSubsystem();
	/*
	 * This is the limit switch. The constructor parameter is the channel its plugged into. 
	 */
	private DigitalInput limitSwitch = new DigitalInput(1);
	
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new RobotCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new RobotCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new RobotCommand());
    
	/*
	 * Get the left joystick
	 */
    public Joystick getLeftStick() {
    	return leftStick;
    }
    
    /*
     * Get the right joystick 
     */
    public Joystick getRightStick() {
    	return rightStick;
    }
    
    /*
     * Get the trigger on the LEFT joystick that allows for strafing 
     */
    public Button getLeftStrafeTrigger() {
    	return strafeTriggerLeft;
    }
    
    /*
     * Get the trigger on the RIGHT joystick that allows for strafing 
     */
    public Button getRightStrafeTrigger() {
    	return strafeTriggerRight;
    }
	
    public StrafeCommand getStrafeCommand() {
    	return strafeCommand;
    }
    
    /* 
     * This method checks if either the left trigger or right trigger is pressed. (The left trigger being the
     * trigger button on the left joystick, the right trigger being the trigger button on the right joystick.)
     * It returns true if either one is pressed or false if neither are pressed. 
     */
    public boolean isPressed() {
    	if(strafeTriggerLeft.get() || strafeTriggerRight.get()) {
    		return true;
    	} else {
    		return false;
    	}
    }
}

