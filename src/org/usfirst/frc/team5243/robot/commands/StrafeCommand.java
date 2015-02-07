package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5243.robot.ControlInitializer;
import org.usfirst.frc.team5243.robot.Robot;

/* The StrafeCommand class's methods are called if, while the teleopContinuous() method is running,
 * the trigger button on the right joystick is pressed. First, initialize() is called, then execute() is called
 * continuously until the trigger button on the right joystick is released. When it is released, isFinished() is called,
 * followed by end()
 */

public class StrafeCommand extends Command {
	private double speed;
	// true is right:false is left
	private int direction;

	public StrafeCommand(int d) {
		//requires(ControlInitializer.motorSubsystem);
		direction = d;
		System.out.println("Strafe command constructor: default shouldn't be called");
		
	}

	// Called just before this Command runs the first time
	public void initialize() {
		System.out.println("Strafecommand initialize");
	}

	public void start(double d) {
		// Added speed parameter so that the side the trigger was pushed(left or
		// right) will change the direction
		this.execute(d);
	}

	/**
	 * Execute gets a value that will take a value and run the strafe motor at
	 * the speed. ====This is not the regular Command method==== @ param
	 * speedval the speed you want each motor to go(positive value 0-1)
	 */
	public void execute(double speedval) {
		System.out.println("Entering Strafe exectute");
		if (Robot.oi.getRightStick().getX() > 1) {
			ControlInitializer.motorSubsystem.getMiddleOne().set(speedval); // Strafe
																			// right
			ControlInitializer.motorSubsystem.getMiddleTwo().set(speedval); // Strafe
																			// right
		} else if (Robot.oi.getRightStick().getX() < 1) {
			ControlInitializer.motorSubsystem.getMiddleOne().set(speedval); // Strafe
																			// left
			ControlInitializer.motorSubsystem.getMiddleTwo().set(speedval); // Strafe
																			// left
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (!Robot.oi.getRightStrafeTrigger().get()) {
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	public void end() {
		System.out.println("Strafing ended");
		ControlInitializer.motorSubsystem.getMiddleOne().set(0);
		ControlInitializer.motorSubsystem.getMiddleTwo().set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}

	// use scheduler with these not working yet.
	@Override
	protected void execute() {
		System.out.println("AMAZING STRAFECOMMMAND EXECUTE HAS FINNALLY RUN!!");
		ButtonSpeed();
		Strafe(direction);
	}

	@Override
	public void start() {
		System.out.println("in StrafeCommand start ");
	}

	/**
	 * constant speed push right go right push left go left
	 */
	private void Strafe(int d) {
		ControlInitializer.motorSubsystem.getMiddleOne().set(d * speed);
		ControlInitializer.motorSubsystem.getMiddleTwo().set(d * speed);
	}

	/*
	 * sets the button speed making sure it does not exceed 1 or go below
	 * 0(negative speed is handled when moving left or right)
	 * 
	 * @param s new speed the robot should go between 0 and 1
	 * 
	 * @return false if the speed given(s) exceeds 1 or goes below 0: true if
	 * speed was changed to intended value;
	 */

	private void JoystickSpeed() {
		speed = Robot.oi.getRightStick().getX();
	}
	private void ButtonSpeed(){
		speed = Robot.oi.getStrafeSpeed();
	}

}
