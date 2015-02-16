package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Move extends Command {
	private double speed;
	private int curve;
	private int action;//0 is drive to auto zone,
	private long time;
    public Move(double s, int c,int a) {
        speed = s;
        curve = c;
        action=a;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	time = System.currentTimeMillis();
    	if(action ==0){
    		Robot.oi.motorSubsystem.getRobot().drive(speed,curve);
    	}
    	if(action==1){
    		Robot.oi.motorSubsystem.getMiddleOne().set(speed);
    		Robot.oi.motorSubsystem.getMiddleZero().set(speed);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(action==0){
    		if((System.currentTimeMillis()-time)*Robot.oi.getSpeed()>=140){//140 is distance into autozone
    			return true;
    		}
    	}
    	if(action==1){
    		if(System.currentTimeMillis()-time==3000){
    			Robot.oi.motorSubsystem.getMiddleOne().set(0);
    			Robot.oi.motorSubsystem.getMiddleZero().set(0);
    		}
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
