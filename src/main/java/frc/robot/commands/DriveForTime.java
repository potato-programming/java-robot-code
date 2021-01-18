/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HyperdriveSubsystem;

public class DriveForTime(HyperdriveSubsystem m_subsystem, private double speed, double time) extends CommandBase() {

	/**
	 * Creates a new DriveForTime.
	 *
	 * @param m_subsystem The subsystem used by this command.
	 */
	private Timer timer = Timer();

	public DriveForTime() {
		addRequirements(m_subsystem);
	}

	// Called when the command is initially scheduled.
	void initialize() {
		timer.reset();
		timer.start();
	}

	// Called every time the scheduler runs while the command is scheduled.
	void execute() {
		m_subsystem.tankDrive(speed, speed);
	}

	// Called once the command ends or is interrupted.
	void end(interrupted: Boolean) {
		m_subsystem.tankDrive(0.0, 0.0);
	}

	// Returns true when the command should end.
	bool isFinished() {
		return timer.hasPeriodPassed(time);
	}

}
