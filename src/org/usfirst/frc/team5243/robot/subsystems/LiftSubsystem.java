package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.ControlInitializer;
import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftSubsystem extends Subsystem {
    
	private Talon liftMotor;
	private LiftLimits limits;
	private double speed;
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	public LiftSubsystem(){
		liftMotor = new Talon(RobotMap.liftMotor);
		//limits = new LiftLimits();
		speed=0;
	}
	
	public void lower(){
		System.out.println("Liftlower");
		if(limits.atBottom()){
			System.out.println("Already at bottom");
			return;
		}
		/*if(speed>.5){
			System.out.println("to fast");
			return;
		}*/
		speed=-.4;
		liftMotor.set(speed);
		
	}
	
	public void raise(){
		
		System.out.println("Liftraise");
		if(limits.atTop()){
			System.out.println("Already at top");
			return;
		}
		/*if (speed > .5) {
			System.out.println("to fast");
			return;
		}*/
		speed=.4;
		liftMotor.set(speed);
		
	}
	
	public void stop(){
		/*if(limits.atTop()&&speed<0){
			System.out.println("hit the top kept going");
			return;
		}
		if(limits.atBottom()&&speed>0){
			System.out.println("hit the bottom kept going");
			return;
		}*/
		System.out.println("Stop raise");
		speed=0;
		liftMotor.set(speed);
	}
	public void setLimits(LiftLimits l){
		limits=l;
	}
	
	
	
	
}

