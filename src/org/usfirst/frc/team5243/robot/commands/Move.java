package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Move extends Command {
	long time;
	long timeinit;
    public Move(long t) {
    	//time is in milliseconds
        time = t;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Autonomous initialize");
        timeinit = System.currentTimeMillis();
    	Robot.oi.motorSubsystem.getRobot().drive(-.5, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if((System.currentTimeMillis()-timeinit)>=time){
    		System.out.println("autonomous is finished");
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.oi.motorSubsystem.getRobot().drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
