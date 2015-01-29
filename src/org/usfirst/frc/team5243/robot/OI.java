package org.usfirst.frc.team5243.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;

import org.usfirst.frc.team5243.robot.commands.RobotCommand;

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
    private static Joystick leftStick = new Joystick(RobotMap.leftJoystick); 
    private static Joystick rightStick = new Joystick(RobotMap.rightJoystick);
	private static Button strafeTriggerLeft = new JoystickButton(leftStick, 1);
	private static Button strafeTriggerRight = new JoystickButton(rightStick, 1);
	
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
    public static Joystick getLeftStick() {
    	return leftStick;
    }
    
    /*
     * Get the right joystick 
     */
    public static Joystick getRightStick() {
    	return rightStick;
    }
    
    /*
     * Get the trigger on the LEFT joystick that allows for strafing 
     */
    public static Button getLeftStrafeTrigger() {
    	return strafeTriggerLeft;
    }
    
    /*
     * Get the trigger on the RIGHT joystick that allows for strafing 
     */
    public static Button getRightStrafeTrigger() {
    	return strafeTriggerRight;
    }
	
    /* 
     * This method checks if either the left trigger or right trigger is pressed. (The left trigger being the
     * trigger button on the left joystick, the right trigger being the trigger button on the right joystick.)
     * It returns true if either one is pressed or false if neither are pressed. 
     */
    public static boolean isPressed() {
    	if(strafeTriggerLeft.get() || strafeTriggerRight.get()) {
    		return true;
    	} else {
    		return false;
    	}
    }
}

