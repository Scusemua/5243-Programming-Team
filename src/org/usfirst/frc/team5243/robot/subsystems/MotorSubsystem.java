
package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MotorSubsystem extends Subsystem {
	
	private Victor middleMiddle1 = new Victor(RobotMap.middleMotor1); //related to hdrive 
	private Talon middleMiddle0 = new Talon(RobotMap.middleMotor0); //related to hdrive 

    public MotorSubsystem() {
		System.out.println("MotorSystem constructor called");
	}

	public void initDefaultCommand() {
	}
	public Victor getMiddleOne() {
		return middleMiddle1;
	}
	
	public Talon getMiddleZero() {
		return middleMiddle0;
	}
	
}

