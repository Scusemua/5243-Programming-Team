package org.usfirst.frc.team5243.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DigitalInput;

import org.usfirst.frc.team5243.robot.commands.StrafeCommand;
import org.usfirst.frc.team5243.robot.commands.StrafeSpeedCommand;
import org.usfirst.frc.team5243.robot.subsystems.CameraSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.MotorSubsystem;

public class ControlInitializer {
    private double strafeSpeed;
    
    private final Joystick leftStick = new Joystick(RobotMap.leftJoystick), 
   	rightStick = new Joystick(RobotMap.rightJoystick);

	public final static CameraSubsystem cameraSubsystem = new CameraSubsystem();
	public final static MotorSubsystem motorSubsystem = new MotorSubsystem();
	
	//This is the limit switch. The constructor parameter is the channel its plugged into. 
	private final DigitalInput limitSwitch = new DigitalInput(1);
	
	private Button speedUp= new JoystickButton(leftStick,3),
		slowDown= new JoystickButton(leftStick,2),
		leftStrafe = new JoystickButton(rightStick, 4),
		rightStrafe = new JoystickButton(rightStick, 5),
		resetButton = new JoystickButton(rightStick,2),
		strafeTriggerLeft = new JoystickButton(leftStick, 1), 
		strafeTriggerRight = new JoystickButton(rightStick, 1);
		
	public ControlInitializer(){
		strafeSpeed=0;
		speedUp.whenPressed(new StrafeSpeedCommand(strafeSpeed+.1));
		slowDown.whenPressed(new StrafeSpeedCommand(strafeSpeed-.1));
		//left is false right is true
		leftStrafe.whileHeld(new StrafeCommand(-1));
		rightStrafe.whileHeld(new StrafeCommand(1));
		resetButton.whenPressed(new StrafeSpeedCommand(0));
		//I have a problem with the ones below
		strafeTriggerLeft.whileHeld(new StrafeCommand(-1));
		strafeTriggerRight.whileHeld(new StrafeCommand(1));
	}
	/**
	 * sets the button speed making sure it does not exceed 1 or go below 0(negative speed is handled when moving left or right)
	 * @param s new speed the robot should go between 0 and 1
	 * @return false if the speed given(s) exceeds 1 or goes below 0: true if speed was changed to intended value;
	 */
	public boolean setStrafeSpeed(double s){
		if(s>1){
			strafeSpeed =1;
			return false;
		}
		else if(s<0){
			strafeSpeed=0;
			return false;
		}
		else{
			strafeSpeed =s;
			return true;
		}
	}
	public double getStrafeSpeed(){
		return strafeSpeed;
	}
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
    
}

