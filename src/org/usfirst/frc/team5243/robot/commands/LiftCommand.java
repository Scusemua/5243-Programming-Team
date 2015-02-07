package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.ControlInitializer;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 */
public class LiftCommand extends Command {
	private int direction; //-1 is down, 1 is up
	
    public LiftCommand(int dir) {
    	requires(ControlInitializer.motorSubsystem);
    	direction = dir;
    }


    protected void initialize() {
    	
    }

    protected void execute() {
    	
    }


    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	
    }


    protected void interrupted() {
    	
    }
}
