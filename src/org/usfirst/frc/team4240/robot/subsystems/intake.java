// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team4240.robot.subsystems;

import org.usfirst.frc.team4240.robot.Robot;
import org.usfirst.frc.team4240.robot.RobotMap;
import org.usfirst.frc.team4240.robot.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class intake extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final WPI_TalonSRX talonSRX1 = RobotMap.intakeTalonSRX1;
    private final WPI_TalonSRX talonSRX2 = RobotMap.intakeTalonSRX2;
    private final SpeedControllerGroup intakeTalon = RobotMap.intakeintakeTalon;
    private final PowerDistributionPanel powerDistributionPanel1 = RobotMap.intakePowerDistributionPanel1;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new cubeStop());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }
    public void cubeIn() {
    	Robot.intake.intakeTalon.set(-.6);
    }
    public void cubeOut() {
    	Robot.intake.intakeTalon.set(.3);
    }
    public void stop() {
    	Robot.intake.intakeTalon.set(0);
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}
