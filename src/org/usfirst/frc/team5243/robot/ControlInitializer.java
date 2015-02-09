package org.usfirst.frc.team5243.robot;


import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Counter;

import org.usfirst.frc.team5243.robot.commands.StrafeCommand;
import org.usfirst.frc.team5243.robot.commands.StrafeSpeedCommand;
import org.usfirst.frc.team5243.robot.commands.LiftCommand;
import org.usfirst.frc.team5243.robot.subsystems.CameraSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.LiftSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.MotorSubsystem;

public class ControlInitializer {
    private double strafeSpeed;
    
    private final Joystick leftStick = new Joystick(RobotMap.leftJoystick), rightStick = new Joystick(RobotMap.rightJoystick);

    private final DigitalInput limitSwitch = new DigitalInput(8); //Parameter is the channel
    private Counter limitCounter = new Counter(limitSwitch);
    
	public final static CameraSubsystem cameraSubsystem = new CameraSubsystem();
	public final static MotorSubsystem motorSubsystem = new MotorSubsystem();
	public final static LiftSubsystem liftSubsystem = new LiftSubsystem();
	
	//This is the limit switch. The constructor parameter is the channel its plugged into. 
	//private final DigitalInput limitSwitch = new DigitalInput(1);
	//private Encoder encoder = new Encoder(2,7); // constructor parameters will change
	private Button speedUp,slowDown, leftStrafe, rightStrafe, resetButton, strafeTriggerLeft, strafeTriggerRight, liftUp, liftDown;
	
	public ControlInitializer() {
		speedUp= new JoystickButton(leftStick,3);
				slowDown= new JoystickButton(leftStick,2);
				leftStrafe = new JoystickButton(rightStick, 4);
				rightStrafe = new JoystickButton(rightStick, 5);
				resetButton = new JoystickButton(leftStick,4);
				strafeTriggerLeft = new JoystickButton(leftStick, 1); 
				strafeTriggerRight = new JoystickButton(rightStick, 1);
				liftUp= new JoystickButton(rightStick, 3);
				liftDown=new JoystickButton(rightStick,2);
		strafeSpeed=0;
		speedUp.whenPressed(new StrafeSpeedCommand(strafeSpeed+.1));
		slowDown.whenPressed(new StrafeSpeedCommand(strafeSpeed-.1));
		liftUp.whenPressed(new LiftCommand(1));
		liftDown.whenPressed(new LiftCommand(-1));
		//left is false right is true
		leftStrafe.whenPressed(new StrafeCommand(-1,2));
		rightStrafe.whenPressed(new StrafeCommand(1,1));
		resetButton.whenPressed(new StrafeSpeedCommand(0));
		// double check below later
		strafeTriggerLeft.whenPressed(new StrafeCommand(-1,4));
		strafeTriggerRight.whenPressed(new StrafeCommand(1,3));
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
    
    public DigitalInput getLimitSwitch(){
    	return limitSwitch;
    } 
    
    public Counter getCounter() {
    	return limitCounter;
    }
}

