// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team4240.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4240.robot.commands.*;
import org.usfirst.frc.team4240.robot.subsystems.*;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.cscore.UsbCamera;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static driveTrain driveTrain;
    public static intake intake;
    public static flipper flipper;
    public static intakeLift intakeLift;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
    	
    	UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture();
        camera1.setResolution(320, 240);
        
        UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture();
        camera2.setResolution(320, 240);
        
        

    	
        RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrain = new driveTrain();
        SmartDashboard.putData(driveTrain);
        intake = new intake();
        flipper = new flipper();
        intakeLift = new intakeLift();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // Add commands to Autonomous Sendable Chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        chooser.addObject("AutonomousNothing", new AutonomousNothing());
        chooser.addDefault("Autonomous Command", new AutonomousCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        SmartDashboard.putData("Auto mode", chooser);
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        autonomousCommand = chooser.getSelected();
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
    	SmartDashboard.putNumber("Angle", Robot.driveTrain.getIMUAngle());
    	SmartDashboard.putNumber("Current0", Robot.driveTrain.pdp.getCurrent(0));
    	SmartDashboard.putNumber("Current1", Robot.driveTrain.pdp.getCurrent(1));
    	SmartDashboard.putNumber("Current2", Robot.driveTrain.pdp.getCurrent(2));
    	SmartDashboard.putNumber("Current3", Robot.driveTrain.pdp.getCurrent(3));
    	SmartDashboard.putNumber("Current4", Robot.driveTrain.pdp.getCurrent(4));
    	SmartDashboard.putNumber("Current5", Robot.driveTrain.pdp.getCurrent(5));
    	
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}
