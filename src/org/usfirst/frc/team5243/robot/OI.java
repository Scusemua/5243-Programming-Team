package org.usfirst.frc.team5243.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DigitalInput;

import org.usfirst.frc.team5243.robot.commands.StrafeCommand;

import org.usfirst.frc.team5243.robot.subsystems.CameraSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.MotorSubsystem;

public class OI {
    private Joystick leftStick = new Joystick(RobotMap.leftJoystick); 
    private Joystick rightStick = new Joystick(RobotMap.rightJoystick);
	private Button strafeTriggerLeft = new JoystickButton(leftStick, 1); 
	private Button strafeTriggerRight = new JoystickButton(rightStick, 1);
    	
	private StrafeCommand strafeCommand = new StrafeCommand();
	
	public static CameraSubsystem cameraSubsystem = new CameraSubsystem();
	public static MotorSubsystem motorSubsystem = new MotorSubsystem();
	
	//This is the limit switch. The constructor parameter is the channel its plugged into. 
	private DigitalInput limitSwitch = new DigitalInput(1);
	
    
    //buttons for various strafing things
	private Button testButton = new JoystickButton(rightStick,7);//test button isnt tested yet should set robot strafe speed to 0
	
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
    
    //Exiting strafing buttons
	/**
	 * Get the left joystick
	 */
    public Joystick getLeftStick() {
    	return leftStick;
    }
    
    /**
     * Get the right joystick 
     */
    public Joystick getRightStick() {
    	return rightStick;
    }
    
    /**
     * Get the trigger on the LEFT joystick that allows for strafing 
     */
    public Button getLeftStrafeTrigger() {
    	return strafeTriggerLeft;
    }
    
    /**
     * Get the trigger on the RIGHT joystick that allows for strafing 
     */
    public Button getRightStrafeTrigger() {
    	return strafeTriggerRight;
    }
	
    public StrafeCommand getStrafeCommand() {
    	return strafeCommand;
    }
    
    /**
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

