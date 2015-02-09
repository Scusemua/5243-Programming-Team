package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.ControlInitializer;
import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DigitalInput;

/**5 limit switches 2 stop reverse 3 trigger response indicator on control panel one height at a time 350 revolutions (encoder) 
 *
 */
public class LiftCommand extends Command {
	private int direction; // -1 is down, 1 is up

	public LiftCommand(int dir) {
		requires(ControlInitializer.liftSubsystem);
		if(dir==-1||dir==1){
			direction = dir;
		}
		else{
			System.out.println("don't be a fool");
		}
	}

	protected void initialize() {
		/*if (Robot.oi.getLimitSwitch().get()) {
			direction = 0;
		} */
	}

	protected void execute() {
		ControlInitializer.liftSubsystem.getLiftMotor().set(direction * 0.1);
		Robot.oi.getLimitSwitch().get();
		System.out.println("execute method limitSwitch" + Robot.oi.getLimitSwitch().get());
	}

	protected boolean isFinished() {
		return true;
		
		/*if (Robot.oi.getLimitSwitch().get()) {
			return true;
		}*/
	}

	protected void end() {
		ControlInitializer.liftSubsystem.getLiftMotor().set(0);
	}

	protected void interrupted() {

	}

}
