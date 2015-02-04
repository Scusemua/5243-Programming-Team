/*
 * 
 * COMMENT THE CODE IF YOU MAKE CHANGES
 * SO WE DON'T HAVE TO SPEND 20 MINUTES
 * TRYING TO FIGURE OUT WHAT THE HECK YOU CHANGED
 * AND WHY EVERYTHING IS BROKEN/NOT WORKING LIKE IT WAS BEFORE
 * 
 * THANK YOU,
 * BEN
 * 
 * P.S.
 * 
 * Austin just asked what a "crio" was. As in "C-Rio" but he pronounced cree-oh. 
 * 
 */

package org.usfirst.frc.team5243.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.RobotDrive;

import org.usfirst.frc.team5243.robot.commands.*;
import org.usfirst.frc.team5243.robot.subsystems.*;
//import org.usfirst.frc.team5243.robot.triggers.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static OI oi = new OI();
	private RobotDrive robot = new RobotDrive(RobotMap.frontLeftMotor,RobotMap.backLeftMotor,RobotMap.frontRightMotor,RobotMap.backRightMotor); //motor channels are parameters 
	
	private boolean firstTime = true; //Used to test whether it's the first iteration of teleopContinuous(); 
	private boolean currentlyPushedR = false;
	private boolean currentlyPushedL =false;
    //Austinstuff
	private double buttonSpeed;
	
	//End AustinStuff

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
    	System.out.println("robotInit() called");
        //autonomousCommand = new RobotCommand(); ben fix this 
        //Intialize the actual Robot
        robot.setSafetyEnabled(false);
        //robot.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        //robot.setInvertedMotor(RobotDrive.MotorType.)
        buttonSpeed = 0;
    }
	

    public void autonomousInit() {
        // schedule the autonomous command (example) ben fix this 
        //if (autonomousCommand != null) autonomousCommand.start();
        robot.drive(1, 0);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousContinuous() {
    	System.out.println("AutonomousContinuous called");
    	robot.drive(1, 0);
    	
    }
    
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        AustinTriggerStrafe();
        //oi.getTestButton().whenPressed(strafeCommand);
    	robot.tankDrive(oi.getLeftStick(), oi.getRightStick());
    }
    
    /* public void teleopContinuous() {
    	if(firstTime) {
    		System.out.println("teleopContinuous called for first time");
    		firstTime = false;
    	}
        if (autonomousCommand != null) autonomousCommand.cancel();
        while(isEnabled()) {
        	/*
        	 * Temporary workaround for the strafeing. 
        	 * I call the strafeCommand method upon pressing the right trigger
        	 * and turn it off if I stop pressing the trigger. 
        	 *
            if(OI.getRightStrafeTrigger().get()) {
            	strafeCommand.start();
            }
            if(!OI.getRightStrafeTrigger().get()) {
            	strafeCommand.end();
            }
        	robot.tankDrive(oi.getLeftStick(), oi.getRightStick());
        	Timer.delay(0.1);
        }
    } */
    
    
    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	System.out.println("teleopInit called");
    	teleopPeriodic(); 
    }
    
    public void testInit() {
    	
    }
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
        
    }
    
    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	
    }
    
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void disabledContinuous(){
		
	}
	/**way to run the robot with a constant speed:
	 * Left JoystickButton(1) for left:  
	 * Right Joystick Button(1) for right
	 * 
	 * ===UNTESTED===
	 * @return true if state of strafe changed false if unchanged(method does nothing)
	 */
	private boolean AustinTriggerStrafe(){
		if(!currentlyPushedR&&oi.getRightStrafeTrigger().get()) {
        	oi.getStrafeCommand().start(.5);
        	currentlyPushedR = true;
        	return true;
        }
        if(currentlyPushedR&&!oi.getRightStrafeTrigger().get()){
        	oi.getStrafeCommand().end();
        	currentlyPushedR=false;
        	return true;
        }
        if(!currentlyPushedL&&oi.getLeftStrafeTrigger().get()){
        	oi.getStrafeCommand().start(-.5);
        	currentlyPushedL = true;
        	return true;
        }
        if(currentlyPushedL&&!oi.getLeftStrafeTrigger().get()){
        	oi.getStrafeCommand().end();
        	currentlyPushedL = false;
        	return true;
        }
        return false;
	}
	/**
	 * Alternate method used if driver prefers buttons over joystick control over regular joystick. Or if we never got the joysticks
	 * to work like we wanted.
	 */
	private void AustinButtonStrafe(){//Doesnt work
		if(oi.getRightStrafe().get()){
			oi.getStrafeCommand().start(buttonSpeed);
		}
		if(oi.getLeftStrafe().get()){
			oi.getStrafeCommand().start(-buttonSpeed);
		}
		if(oi.getSpeedButton().get()){
			setButtonSpeed(buttonSpeed+.1);
		}
		if(oi.getSlowButton().get()){
			setButtonSpeed(buttonSpeed-.1);
		}
		if(oi.getResetButton().get()){
			setButtonSpeed(0);
		}
	}
	/**
	 * sets the button speed making sure it does not exceed 1 or go below 0(negative speed is handled when moving left or right)
	 * @param s new speed the robot should go between 0 and 1
	 * @return false if the speed given(s) exceeds 1 or goes below 0: true if speed was changed to intended value;
	 */
	private boolean setButtonSpeed(double s){
		if(s>1){
			buttonSpeed =1;
			return false;
		}
		else if(s<0){
			buttonSpeed=0;
			return false;
		}
		else{
			buttonSpeed =s;
			return true;
		}
	}
	
	private boolean AustinTriggerStrafeWJoystick(){//doesnt work
		if(!currentlyPushedR&&oi.getRightStrafeTrigger().get()) {
        	oi.getStrafeCommand().start(oi.getRightStick().getX());
        	currentlyPushedR = true;
        	return true;
        }
        if(currentlyPushedR&&!oi.getRightStrafeTrigger().get()){
        	oi.getStrafeCommand().end();
        	currentlyPushedR=false;
        	return true;
        }
        return false;
	}

}
