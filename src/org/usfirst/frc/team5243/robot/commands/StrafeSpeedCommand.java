package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5243.robot.Robot;

public class StrafeSpeedCommand extends Command{
  double speed;
  
  public StrafeSpeedCommand(double d){
    speed = d;
  }
  
  public void initialize(){}
  public void start(){
	  Robot.oi.setStrafeSpeed(speed);
  }
  public void execute(){}
  public boolean isFinished(){return true;}
  public void end(){}
  protected void interrupted(){}
  
  
}
