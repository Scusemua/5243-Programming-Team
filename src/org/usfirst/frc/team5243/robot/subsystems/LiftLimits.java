package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.commands.LimitButton;
import org.usfirst.frc.team5243.robot.commands.StopLift;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftLimits extends Subsystem {
    
	private final DigitalInput limitSwitchBottom; //Parameter is the channel
    private final DigitalInput limitSwitchFirst;
    //private final DigitalInput limitSwitchSecond;
    private final DigitalInput limitSwitchTop;
    
    private Button limitButtonBottom;
    private Button limitButtonFirst;
    //private Button limitButtonSecond;
    private Button limitButtonTop;
    public LiftLimits(){
    	limitSwitchBottom = new DigitalInput(0);
    	limitSwitchFirst = new DigitalInput(1);
    	//limitSwitchSecond = new DigitalInput(2);
    	limitSwitchTop = new DigitalInput(3);
    	
    	limitButtonBottom = new LimitButton(limitSwitchBottom);
    	limitButtonFirst = new LimitButton(limitSwitchFirst);
    	//limitButtonSecond= new LimitButton(limitSwitchSecond);
    	limitButtonTop = new LimitButton(limitSwitchTop);
    	
    	limitButtonBottom.whenPressed(new StopLift());
    	limitButtonFirst.whenPressed(new StopLift());
    	//limitButtonSecond.whenPressed(new StopLift());
    	limitButtonTop.whenPressed(new StopLift());
    }
    public void initDefaultCommand() {
    }

	public boolean atTop() {
		//if normally open returns true;
		return false;//!limitSwitchTop.get();
	}
	public boolean atBottom(){
		/*if(!limitSwitchBottom.get()){
			return true;
		}*/
		return false;
	}
	
    
    
}

