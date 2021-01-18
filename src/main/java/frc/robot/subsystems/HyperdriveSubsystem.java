/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HyperdriveSubsystem extends SubsystemBase() {

	private CANSparkMax leftFront = new CANSparkMax(Constants.Hyperdrive.leftFrontPort, MotorType.kBrushless);
	private CANSparkMax leftBack = new CANSparkMax(Constants.Hyperdrive.leftBackPort, MotorType.kBrushless);
	private CANSparkMax rightFront = new CANSparkMax(Constants.Hyperdrive.rightFrontPort, MotorType.kBrushless);
	private CANSparkMax rightBack = new CANSparkMax(Constants.Hyperdrive.rightBackPort, MotorType.kBrushless);

	private DifferentialDrive myRobot = new DifferentialDrive(new SpeedControllerGroup(leftFront, leftBack), new SpeedControllerGroup(rightFront, rightBack));

	bool robotDirectionInverted = false;

	override void periodic() {
	}

	void tankDrive(double leftPower, double rightPower) {
		myrobot.tankDrive(-leftPower, -rightPower, false);
	}

}
