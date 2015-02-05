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
	private double speed;
	public StrafeCommand() {
		System.out.println("Strafe command constructor: default shouldn't be called");
		speed=Robot.io.getStrafeSpeed();
	}
	
    // Called just before this Command runs the first time
    public void initialize() {
    	System.out.println("Strafecommand initialize");
    }
    public void start(double d){
    	//Added speed parameter so that the side the trigger was pushed(left or right) will change the direction
    	this.execute(d);
    }

    /**Execute gets a value that will take a value and run the strafe motor at the speed.
     * ====This is not the regular Command method====
     * @ param speedval the speed you want each motor to go(positive value 0-1)
     */
    public void execute(double speedval) {
    	System.out.println("Entering Strafe exectute");
    	if(Robot.oi.getRightStick().getX() > 1) {
    		OI.motorSubsystem.getMiddleOne().set(speedval); //Strafe right
    		OI.motorSubsystem.getMiddleTwo().set(speedval); //Strafe right
    	} else if (Robot.oi.getRightStick().getX() < 1) {
    		OI.motorSubsystem.getMiddleOne().set(speedval); //Strafe left
    		OI.motorSubsystem.getMiddleTwo().set(speedval); //Strafe left
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(!Robot.oi.getRightStrafeTrigger().get()) {
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    public void end() {
    	System.out.println("Strafing ended");
    	OI.motorSubsystem.getMiddleOne().set(0);
    	OI.motorSubsystem.getMiddleTwo().set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    protected boolean continueStrafe() {
    	return false;
    }
    //use scheduler with these not working yet.
    protected void execute() {
	System.out.println("AMAZING STRAFECOMMMAND EXECUTE HAS FINNALLY RUN!!");
	OI.motorSubsystem.getMiddleOne().set(speed);
    	OI.motorSubsystem.getMiddleTwo().set(speed);
	
	}
    public void start(){
	System.out.println("in StrafeCommand start ");
    }
    
}
