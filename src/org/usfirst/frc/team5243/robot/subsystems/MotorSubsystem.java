
package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MotorSubsystem extends Subsystem {
	
	private Talon middleMiddle = new Talon(RobotMap.middleMotor1); //related to hdrive 
	private Talon middleMiddle2 = new Talon(RobotMap.middleMotor2); //related to hdrive 
	
    public MotorSubsystem() {
		System.out.println("MotorSystem constructor called");
	}

	public void initDefaultCommand() {
	}
	public Talon getMiddleOne() {
		return middleMiddle;
	}
	
	public Talon getMiddleTwo() {
		return middleMiddle2;
	}
}

