
package org.usfirst.frc.team5243.robot.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MotorSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Jaguar j;
    public MotorSubsystem(Jaguar jag) {
		j=jag;
		j.set(.25);
		System.out.println("MotorSystem constructor called");
	}

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

