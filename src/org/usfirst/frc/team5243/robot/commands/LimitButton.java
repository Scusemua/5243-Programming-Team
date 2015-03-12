package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.Button;

public class LimitButton extends Button {
	private DigitalInput limit;
	public LimitButton(DigitalInput di){
		limit=di;
	}
	public boolean get() {
		//Use not if normally open vs close.
		return false; //!limit.get();
	}

}
