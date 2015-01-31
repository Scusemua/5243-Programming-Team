
package org.usfirst.frc.team5243.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
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
	private Talon leftFront = new Talon(4); 
	private Talon leftBack = new Talon(2);
	private Talon rightFront = new Talon(5);
	private Talon rightBack = new Talon(3);
	private Talon middleMiddle = new Talon(1); //related to hdrive 
	private Talon middleMiddle2 = new Talon(0); //related to hdrive 
	
    public MotorSubsystem() {
		System.out.println("MotorSystem constructor called");
		
	}

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	
	public Talon getLeftFront() {
		return leftFront;
	}
	
	public Talon getLeftBack() {
		return leftFront;
	}
	
	public Talon getRightFront() {
		return rightFront;
	}
	
	public Talon getRightBack() {
		return rightBack;
	}
	
	public Talon getMiddleOne() {
		return middleMiddle;
	}
	
	public Talon getMiddleTwo() {
		return middleMiddle2;
	}
}

