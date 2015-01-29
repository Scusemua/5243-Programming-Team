
package org.usfirst.frc.team5243.robot.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MotorSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	/*
	 * The parameter in the Jaguar constructor is the channel number.
	 */
	private Jaguar leftFront = new Jaguar(1); 
	private Jaguar leftBack = new Jaguar(2);
	private Jaguar rightFront = new Jaguar(3);
	private Jaguar rightBack = new Jaguar(4);
	private Jaguar middleMiddle = new Jaguar(5);
	
    public MotorSubsystem() {
		System.out.println("MotorSystem constructor called");
	}

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	
	public Jaguar getLeftFront() {
		return leftFront;
	}
	
	public Jaguar getLeftBack() {
		return leftFront;
	}
	
	public Jaguar getRightFront() {
		return rightFront;
	}
	
	public Jaguar getRightBack() {
		return rightBack;
	}
	
	public Jaguar getMiddle() {
		return middleMiddle;
	}
}

