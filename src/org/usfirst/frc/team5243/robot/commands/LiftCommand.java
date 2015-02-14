package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.ControlInitializer;
import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DigitalInput;

/**5 limit switches 2 stop reverse 3 trigger response indicator on control panel one height at a time 350 revolutions (encoder) 
 *WE DOnt have an ENcoder
 */
public class LiftCommand extends Command {
	//False is pushed down on limits
	private boolean finish;
	private int direction;
	private int dir;
	public LiftCommand(int d) {
		//requires(ControlInitializer.liftSubsystem);
		finish = false;
		dir = d;
	}

	protected void initialize() {
		System.out.println("output initialize()");
		direction = Robot.oi.getDirection() + dir;
		if(direction > 1) direction = 1;
		if(direction < -1) direction = -1;
		
		finish=ControlInitializer.liftSubsystem.checkLimits( 0, direction);
		Robot.oi.setDirection(direction);
	}

	protected void execute() {
		ControlInitializer.liftSubsystem.startLift(direction);
	}
	
	protected boolean isFinished(){
		
		return ControlInitializer.liftSubsystem.getSwitches(direction);
	}

	protected void end() {
		ControlInitializer.liftSubsystem.stopLift();
		
		if (direction < 0&&ControlInitializer.liftSubsystem.getLevel()!=0) {
			ControlInitializer.liftSubsystem.decreaseLevel();
		}
		else if (direction > 0&&ControlInitializer.liftSubsystem.getLevel()!=4) {
			ControlInitializer.liftSubsystem.increaseLevel();
		}
	}
	
	protected void interrupted() {

	}

}
