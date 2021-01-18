/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HyperdriveSubsystem;

public class DriveHyperCommand(private HyperdriveSubsystem hyperdriveSubsystem, private Joystick leftJoystick, private Joystick rightJoystick) extends commandBase() {

	/**
	 * Creates a new DriveHyperCommand.
	 *
	 * @param hyperdriveSubsystem The subsystem used by this command.
	 */
	public DriveHyperCommand() {
		addRequirements(hyperdriveSubsystem)
	}

	// Called when the command is initially scheduled.
	void initialize() {
	}

	// Called every time the scheduler runs while the command is scheduled.
	void execute() {
		double leftPower = 0.0;
		double rightPower = 0.0;

		double leftJoystickVal = leftJoystick.y.toDouble();
		double rightJoystickVal = rightJoystick.y.toDouble();

		if (Math.abs(leftJoystickVal) > 0.1) {
			leftPower = leftJoystickVal;
		}
		if (Math.abs(rightJoystickVal) > 0.1) {
			rightPower = rightJoystickVal;
		}

		if (hyperdriveSubsystem.robotDirectionInverted) {
			hyperdriveSubsystem.tankDrive(-rightPower, -leftPower);
		} else {
			hyperdriveSubsystem.tankDrive(leftPower, rightPower);
		}
	}

	// Called once the command ends or is interrupted.
	void end(bool interrupted) {
		hyperdriveSubsystem.tankDrive(0.0, 0.0);
	}

	// Returns true when the command should end.
	bool isFinished() {
		return false
	}

}
