package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5243.robot.OI;
import org.usfirst.frc.team5243.robot.Robot;

import org.usfirst.frc.team5243.robot.subsystems.*;

public class StrafeSpeedCommand extends Command{

  public StrafeSpeedCommand(double d){
    Robot.oi.setStrafeSpeed(d);
  }
  public void initialize(){}
  public void start(){}
  public void execute(){}
  public boolean isFinished(){return true;}
  public void end(){}
  protected void interrupted(){}
  
  
}
