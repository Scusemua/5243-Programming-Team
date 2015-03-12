package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousEasiest extends CommandGroup {
	
	public AutonomousEasiest(){
		//addSequential(new RaiseLift());
		addSequential(new Move(3250));//10^-3 |||| 5-> 5000
		System.out.println("constructor autonomous");
	}
	
	
}
