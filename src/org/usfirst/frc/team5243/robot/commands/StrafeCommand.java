package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5243.robot.OI;
import org.usfirst.frc.team5243.robot.Robot;

import org.usfirst.frc.team5243.robot.subsystems.*;

/* The StrafeCommand class's methods are called if, while the teleopContinuous() method is running,
 * the trigger button on the right joystick is pressed. First, initialize() is called, then execute() is called
 * continuously until the trigger button on the right joystick is released. When it is released, isFinished() is called,
 * followed by end()
 */

public class StrafeCommand extends Command {
	//Constructor 
	MotorSubsystem strafeCommandMotorSubsystem; 
	
	public void StrafeCommand() {
		strafeCommandMotorSubsystem = new MotorSubsystem(); //Created so we can get the objects of that class
	}
	
	// Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run

    /*
     * Checks to see if the user wants to strafe to the left 
     */
    protected void execute() {
    	if(OI.getRightStick().getX() > 1) {
    		strafeCommandMotorSubsystem.getMiddleOne().set(1); //Strafe right
    		strafeCommandMotorSubsystem.getMiddleTwo().set(1); //Strafe right
    	} else if (OI.getRightStick().getX() < 1) {
    		strafeCommandMotorSubsystem.getMiddleOne().set(-1); //Strafe left
    		strafeCommandMotorSubsystem.getMiddleTwo().set(-1); //Strafe left
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Strafing ended");
    	strafeCommandMotorSubsystem.getMiddleOne().set(0);
    	strafeCommandMotorSubsystem.getMiddleTwo().set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    protected boolean continueStrafe() {
    	return false;
    }
    
}
