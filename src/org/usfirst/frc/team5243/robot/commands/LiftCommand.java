package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.ControlInitializer;
import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DigitalInput;

/**5 limit switches 2 stop reverse 3 trigger response indicator on control panel one height at a time 350 revolutions (encoder) 
 *WE DOnt have an ENcoder
 */
public class LiftCommand extends Command {
	private boolean finish;
	private int direction; // -1 is down, 1 is up

	public LiftCommand(int dir) {
		requires(ControlInitializer.liftSubsystem);
		if(dir==-1||dir==1){
			direction = dir;
		}
		else{
			System.out.println("don't be a fool");
		}
		finish=false;
	}

	protected void initialize() {
		System.out.println("output initialize()");
		if(Robot.oi.getLimitSwitchTop().get()&&direction>0){
			finish=true;
		}
		if(Robot.oi.getLimitSwitchBottom().get()&&direction<0){
			finish=true;
		}
	}

	protected void execute() {
		ControlInitializer.liftSubsystem.getLiftMotor().set(direction * 0.5);
		System.out.println("execute method limitSwitch");
	}

	protected boolean isFinished() {
		if (Robot.oi.getLimitSwitchFirst().get()||Robot.oi.getLimitSwitchSecond().get()||Robot.oi.getLimitSwitchThird().get()) {
			return true;
		}
		return finish;
	}

	protected void end() {
		ControlInitializer.liftSubsystem.getLiftMotor().set(0);
	}

	protected void interrupted() {

	}

}
