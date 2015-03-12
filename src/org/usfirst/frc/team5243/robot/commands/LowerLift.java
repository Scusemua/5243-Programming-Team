package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LowerLift extends Command {
	//private long time;
	
    public LowerLift() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//time = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	Robot.oi.liftSubsystem.lower();
    	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    /*private double determineSpeed(){
    	double speed;
    	speed = ((System.currentTimeMillis() - time)/1000) *2;
    	
    	
    	return speed/10;
    }*/
}
