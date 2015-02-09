package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftSubsystem extends Subsystem {
    
	private Talon liftMotor = new Talon(RobotMap.liftMotor);
	
    public void initDefaultCommand() {
        
    }
	public Talon getLiftMotor(){
		return liftMotor;
	} 
}

