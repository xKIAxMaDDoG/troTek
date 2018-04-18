package org.usfirst.frc.team4240.robot.auto;

import edu.wpi.first.wpilibj.DriverStation;
import org.usfirst.frc.team4240.robot.*;
import org.usfirst.frc.team4240.robot.commands.*; // when the commands are ready, load each individually to decrease runtime
import org.usfirst.frc.team4240.robot.enumeration.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/** the sequence of commands for autonomous */
public class CommandGroupAuto extends CommandGroup {

	// Stores the states of the switches and scale
	String gameData;

	public CommandGroupAuto(Position position) {
		// Get the state of the switches and scale for each round
		gameData = DriverStation.getInstance().getGameSpecificMessage();

		// make sure everything is in the right state/position here

		switch (position) {
		case LEFT:
			if (gameData.charAt(0) == 'L') {
				addParallel(new liftUpHold());
				addSequential(new AutonomousCommand());
				addSequential(new rotate90Right());
				addSequential(new autoWalk());
				addSequential(new flip());
				addSequential(new flipStop());
			} else if (gameData.charAt(0) == 'R') {
				addParallel(new liftUpHold());
				addSequential(new AutonomousCommand());
			}
			break;
		case RIGHT:
			if (gameData.charAt(0) == 'R') {
				addParallel(new liftUpHold());
				addSequential(new AutonomousCommand());
				addSequential(new rotate90Left());
				addSequential(new autoWalk());
				addSequential(new flip());
				addSequential(new flipStop());
			} else if (gameData.charAt(0) == 'L') {
				addParallel(new liftUpHold());
				addSequential(new AutonomousCommand());
			}
			break;
		case CENTER:
			if (gameData.charAt(0) == 'R') {
				addParallel(new liftUpHold());
				addSequential(new AutonomousCommand());
				addSequential(new flip());
				addSequential(new flipStop());
			} else if (gameData.charAt(0) == 'L') {
				addParallel(new liftUpHold());
				addSequential(new AutonomousCommand());
			}
		}
	}
}