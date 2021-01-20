/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.JSONPlotter;
import frc.robot.JSONPlotterNT;

public class IonCannonSubsystem extends SubsystemBase() {

	/**
	 * Creates a new IonCannon.
	 */
	WPI_VictorSPX top = new WPI_VictorSPX(Constants.IonCannon.topPort);
	WPI_VictorSPX bottom = new WPI_VictorSPX(Constants.IonCannon.bottomPort);

	// Encoders
	private Encoder topEncoder = new Encoder(Constants.IonCannon.topEncoderAPort, Constants.IonCannon.topEncoderBPort, false, EncodingType.k4X);
	private Encoder bottomEncoder = new Encoder(Constants.IonCannon.bottomEncoderAPort, Constants.IonCannon.bottomEncoderBPort, false, EncodingType.k4X);

	private double topEncoderRate = 0.0;
	private double bottomEncoderRate = 0.0;

	// PID things
	private PIDController topPIDController = new PIDController(0.0000125 * 0.45, 0.0000125 * 0.94, 0.000000175);
	private PIDController bottomPIDController = new PIDController(0.0000125 * 0.45, 0.0000125 * 0.94, 0.000000175);
	private JSONPlotter topJSONPlotter = new JSONPlotter("Ion Top");
	private JSONPlotter bottomJSONPlotter = new JSONPlotter("Ion Bottom");
	private JSONPlotter topAverageJSONPlotter = new JSONPlotter("Top Average");
	private JSONPlotter bottomAverageJSONPlotter = new JSONPlotter("Bottom Average");
	private JSONPlotterNT jsonPlotterNT = new JSONPlotterNT();

	private double bottomSetPoint = 0.0;
	private double toeSetPoint = 0.0;

	// Launch when ready
	private int pointsUntilReady = 15;
	private double marginOfError = 5000.0;


	public IonCannonSubsystem() {
		topEncoder.distancePerPulse = 1.0;
		topEncoder.pidSourceType = PIDSourceType.kRate;

		bottomEncoder.distancePerPulse = 1.0;
		bottomEncoder.pidSourceType = PIDSourceType.kRate;
	}

	/**
	 * Will be called periodically whenever the CommandScheduler runs.
	 */
	override void periodic() {
		topEncoderRate = topEncoder.rate;
		bottomEncoderRate = bottomEncoder.rate;
	}

	//* PID Functions
	void resetPID() {
		topPIDController.reset();
		bottomPIDController.reset();
	}

	void endPID() {
		top.set(0.0);
		bottom.set(0.0);
	}

	void setSetPoints Number l_bottomSetpoint, Number l_topSetpoint) {
		bottomSetpoint = l_bottomSetpoint.toDouble();
		topSetpoint = l_topSetpoint.toDouble();
	}

	void runPID() {
		topUseOutput(topPIDController.calculate(topEncoder.rate, topSetpoint))
		bottomUseOutput(bottomPIDController.calculate(bottomEncoder.rate, bottomSetpoint))
	}

	private void topUseOutput(double output) {
		top.set(-output);
	}

	private void bottomUseOutput(double output) {
		bottom.set(-output);
	}

	bool isReady() {
		
	}

}
