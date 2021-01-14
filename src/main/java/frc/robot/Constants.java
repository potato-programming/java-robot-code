/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

public class Constants {

	public static class Joysticks {
		public final int driverRightPort = 0;
		public final int driverLeftPort = 1;
		public final int manipulatorRightPort = 2;
		public final int manipulatorLetPort = 3;
	}

	public static class DockingBay {
		public final int intakePort = 50;
		public final int agitatorPort = 1;
	}

	public static class Hyperdrive {
		public final int rightFrontPort = 3;
		public final int rightBackPort = 6;

		public final int leftFrontPort = 1;
		public final int leftBackPort = 2;
	}

	public static class TurboLift {
		public final int backMotorPort = 2;
		public final int frontMotorPort = 40;
	}

	public static class ControlPanel {
		public final int colorMotor = 11;
	}

	public static class IonCannon {
		// Motors
		public final int topPort = 0;
		public final int bottomPort = 3;

		// Encoders
		public final int topEncoderAPort = 7;
		public final int topEncoderBPort = 6;

		public final int bottomEncoderAPort = 9;
		public final int bottomEncoderBPort = 8;
	}

	public static class Climb {
		public final int hookPort = 12;
		public final int winchPort = 5;
	}

	public static class Turret {
		public final int motorPort = 4;
	}

}
