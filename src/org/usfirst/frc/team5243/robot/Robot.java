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
 * P.S.
 * 
 * Austin just asked what a "crio" was. As in "C-Rio" but he pronounced cree-oh. 
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

/*
 *CHANGES 2/4/15 
 *Added 3 methods for strafing types:
 *Buttons way (variable speed)recently changed previously not working however recently untested(new code to test)
 *Triggers(constant speed)Working 
 *Triggers(variable speed) not working I think the problem lies in getting the magnitude of X for speed. I assumed this based off of the other Trigger working
 *
 *starting to experiment with whileheld()  and getting strafecommand to work how it is supposed to
 *Watch out joysticks are switched (the supposdly left one is right)
 *
 */

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
//>>>>>>> branch 'master' of https://github.com/Scusemua/5243-Programming-Team.git
public class Robot extends IterativeRobot {
	public static ControlInitializer oi = new ControlInitializer();
	private RobotDrive robot = new RobotDrive(RobotMap.frontLeftMotor,RobotMap.backLeftMotor,RobotMap.frontRightMotor,RobotMap.backRightMotor); //motor channels are parameters 
	
	

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
    	System.out.println("robotInit() called");
        //Intialize the actual Robot
        robot.setSafetyEnabled(false);

    }
	

    public void autonomousInit() {
        // schedule the autonomous command (example) ben fix this 
        //if (autonomousCommand != null) autonomousCommand.start();
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
        //oi.getTestButton().whenPressed(strafeCommand);
    	robot.tankDrive(oi.getLeftStick(), oi.getRightStick());
    }
   
    public void teleopInit() {
    	System.out.println("teleopInit called");
    	teleopPeriodic(); 
    }
    
    public void testInit() {
    	
    }
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
        
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
