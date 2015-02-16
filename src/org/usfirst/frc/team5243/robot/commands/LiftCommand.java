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
	private int amount;
	private int stop;
	public LiftCommand(int d,int a) {
		//requires(ControlInitializer.liftSubsystem);
		finish = false;
		dir = d;
		amount =a;
	}

	protected void initialize() {
		System.out.println("output initialize()");
		
		direction = Robot.oi.getDirection() + dir;
		if(direction > 1) direction = 1;
		if(direction < -1) direction = -1;
		
		if(direction==1) stop = Robot.oi.liftSubsystem.getLevel()+amount;
		else if(direction==-1) stop=Math.abs(Robot.oi.liftSubsystem.getLevel()-amount);
		
		if(stop%4!=stop){
			if(direction>0)stop =3;
			else stop =0;
		}
		
		Robot.oi.setDirection(direction);
	}

	protected void execute() {
		ControlInitializer.liftSubsystem.startLift(direction);
		ControlInitializer.liftSubsystem.getSwitches(direction);
	}
	
	protected boolean isFinished(){
		
		if(stop==Robot.oi.liftSubsystem.getLevel()||Robot.oi.getDirection()==0){
			return true;
		}
		return ControlInitializer.liftSubsystem.checkLimits(direction);
	}

	protected void end() {
		System.out.println("end Lift");
		direction=0;
		Robot.oi.setDirection(0);
		ControlInitializer.liftSubsystem.stopLift();
	}
	
	protected void interrupted() {

	}

}
