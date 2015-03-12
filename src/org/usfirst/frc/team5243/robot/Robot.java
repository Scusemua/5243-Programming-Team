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
 * lol weed
 * 
 */

package org.usfirst.frc.team5243.robot;


import org.usfirst.frc.team5243.robot.commands.AutonomousEasiest;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.RobotDrive;

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
	public static ControlInitializer oi=new ControlInitializer();
	private double distToAutoZone;
	private double liftDistance;
	private Command autonomousStart;
	NIVision.Rect rect;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
        // instantiate the command used for the autonomous period
    	autonomousStart = new AutonomousEasiest();
    	System.out.println("robotInit() called");
        //Intialize the actual Robot
        oi.motorSubsystem.getRobot().setSafetyEnabled(false);
        oi.cameraSubsystem.initializeCam();
    }
	

    public void autonomousInit() {
    	autonomousStart.start();
    }
    
    /**
     * This function is called periodically during autonomous h
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
    }
    
    public void autonomousContinuous() {
    	
    	
    	
    }
    
    public void teleopInit() {
    	System.out.println("teleopInit called");
    	NIVision.IMAQdxStartAcquisition(oi.cameraSubsystem.getSession());

    	rect = new NIVision.Rect(10, 10, 100, 100);
    }
    
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    	oi.motorSubsystem.getRobot().tankDrive(oi.getLeftStick(), oi.getRightStick());
    	
        NIVision.IMAQdxGrab(oi.cameraSubsystem.getSession(), oi.cameraSubsystem.getFrame(), 1);
        //NIVision.imaqDrawShapeOnImage(oi.cameraSubsystem.getFrame(), oi.cameraSubsystem.getFrame(), rect,DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
        
        CameraServer.getInstance().setImage(oi.cameraSubsystem.getFrame());
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
    @Override 
    public void disabledInit(){
    	NIVision.IMAQdxStopAcquisition(oi.cameraSubsystem.getSession());
    }
    
    @Override 
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

}
