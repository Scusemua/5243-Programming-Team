
package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MotorSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	/*
	 * The parameter in the Talon constructor is the channel number.
	 */
	/* private Talon leftFront = new Talon(RobotMap.frontLeftMotor); 
	private Talon leftBack = new Talon(RobotMap.backLeftMotor);
	private Talon rightFront = new Talon(RobotMap.frontRightMotor);
	private Talon rightBack = new Talon(RobotMap.backRightMotor);
	*/
	private Talon middleMiddle = new Talon(RobotMap.middleMotor1); //related to hdrive 
	private Talon middleMiddle2 = new Talon(RobotMap.middleMotor2); //related to hdrive 
	
    public MotorSubsystem() {
		System.out.println("MotorSystem constructor called");
		
	}

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	
	/* public Talon getLeftFront() {
		return leftFront;
	}
	
	public Talon getLeftBack() {
		return leftBack;
	}
	
	public Talon getRightFront() {
		return rightFront;
	}
	
	public Talon getRightBack() {
		return rightBack;
	} */
	
	public Talon getMiddleOne() {
		return middleMiddle;
	}
	
	public Talon getMiddleTwo() {
		return middleMiddle2;
	}
}

