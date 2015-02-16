package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousMed extends CommandGroup {
    
    public  AutonomousMed() {
        addSequential(new AutonomousStart());
        addSequential(new Move(.5,0,1));
    }
}
