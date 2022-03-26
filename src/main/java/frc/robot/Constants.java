// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */

public final class Constants {

  public static class kDriveTrain {
    // These are the id's of the Spark Max CANs
    public final static int frontRightDrive = 1;
    public final static int backRightDrive = 2;
    public final static int frontLeftDrive = 3;
    public final static int backLeftDrive = 4;

    // ID for the intake motor
    public final static int intakeMotor = 5;

    // Ramp up time for Sparkmax's in seconds
    public final static int rampUpTime = 2;
  }

}
