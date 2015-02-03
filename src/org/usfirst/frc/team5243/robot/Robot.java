/*
 * 
 * COMMENT THE CODE IF YOU MAKE CHANGES
 * SO WE DON'T HAVE TO SPEND 20 MINUTES
 * TRYING TO FIGURE OUT WHAT THE HECK YOU CHANGED
 * AND WHY EVERYTHING IS BROKEN/NOT WORKING LIKE IT WAS BEFORE
 * 
 * THANK YOU,
 * BEN
 * 
 */

package org.usfirst.frc.team5243.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.RobotDrive;

import org.usfirst.frc.team5243.robot.commands.*;
import org.usfirst.frc.team5243.robot.subsystems.*;
//import org.usfirst.frc.team5243.robot.triggers.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final RobotSubsystem robotSubsystem = new RobotSubsystem();
	public static final CameraSubsystem cameraSubsystem = new CameraSubsystem();
	public static final OI oi = new OI();
	
	private RobotDrive robot = new RobotDrive(RobotMap.frontLeftMotor,RobotMap.backLeftMotor,RobotMap.frontRightMotor,RobotMap.backRightMotor); //motor channels are parameters 
	private StrafeCommand strafeCommand;
	
	private boolean firstTime = true; //Used to test whether it's the first iteration of teleopContinuous(); 
	private boolean first1time = true;
    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
    	System.out.println("robotInit() called");
        autonomousCommand = new RobotCommand();
        //Intialize the actual Robot
        //MotorSubsystem test = new MotorSubsystem(new Jaguar(RobotMap.leftMotor));
        robot.setSafetyEnabled(false);
        //robot.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        //robot.setInvertedMotor(RobotDrive.MotorType.)
        System.out.println("Strafe command constructor before");
        strafeCommand = new StrafeCommand();
        System.out.println("Stafe command constructor after");
    }
	

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        robot.drive(1, 0);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousContinuous() {
    	System.out.println("AutonomousContinuous called");
    	robot.drive(1, 0);
    	
    }
    
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
    }
    
    public void teleopContinuous() {
    	if(firstTime) {
    		System.out.println("teleopContinuous called for first time");
    		firstTime = false;
    	}
        if (autonomousCommand != null) autonomousCommand.cancel();
        while(isEnabled()) {
        	/*
        	 * Temporary workaround for the strafeing. 
        	 * I call the strafeCommand method upon pressing the right trigger
        	 * and turn it off if I stop pressing the trigger. 
        	 */
            if(OI.getRightStrafeTrigger().get()) {
            	strafeCommand.start();
            }
            if(!OI.getRightStrafeTrigger().get()) {
            	strafeCommand.end();
            }
        	robot.tankDrive(oi.getLeftStick(), oi.getRightStick());
        	Timer.delay(0.1);
        }
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	System.out.println("teleopInit called");
    	teleopContinuous(); 
    }
    
    public void testInit() {
    	
    }
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
        
    }
    
    public void testContinuous() {
    	if (autonomousCommand != null) autonomousCommand.cancel();
        System.out.println("testContinuous running");
        //OI.getLeftStrafeTrigger().whileHeld(strafeCommand);
        robot.tankDrive(oi.getLeftStick(), oi.getRightStick());
        Timer.delay(0.01);
    }
    
    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	
    }
    
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void disabledContinuous(){
		
	}
}
