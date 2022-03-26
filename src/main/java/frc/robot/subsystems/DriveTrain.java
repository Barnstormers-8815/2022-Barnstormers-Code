// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import frc.robot.Constants.kDriveTrain;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.commands.ArcadeDriveCommand;

// This will be code to identify physical drivetrain components for use
public class DriveTrain extends SubsystemBase {

  public CANSparkMax m_frontRight;
  public CANSparkMax m_backRight;
  public CANSparkMax m_frontLeft;
  public CANSparkMax m_backLeft;

  public RelativeEncoder m_frontRightEncoder;

  public DifferentialDrive m_driveTrain;
  public MotorControllerGroup m_right;
  public MotorControllerGroup m_left;

  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    /**
     * The following lines will create a new SparkMax object
     * corresponding to a variable.
     */

    // creating SparkMax MotorControllers
    m_frontRight = new CANSparkMax(kDriveTrain.frontRightDrive, MotorType.kBrushless);
    m_backRight = new CANSparkMax(kDriveTrain.backRightDrive, MotorType.kBrushless);
    m_frontLeft = new CANSparkMax(kDriveTrain.frontLeftDrive, MotorType.kBrushless);
    m_backLeft = new CANSparkMax(kDriveTrain.backLeftDrive, MotorType.kBrushless);
    m_frontRightEncoder = m_frontRight.getEncoder();
    m_frontRightEncoder.setPosition(0);
    /**
     * Can be used to reset the configuration parameters in the SparkMax to their
     * factory
     * default state.
     */
    m_frontRight.restoreFactoryDefaults();
    m_backRight.restoreFactoryDefaults();
    m_frontLeft.restoreFactoryDefaults();
    m_backLeft.restoreFactoryDefaults();

    // Setting the rampup time for the neo motors on the robot's drivetrain
    m_frontRight.setClosedLoopRampRate(kDriveTrain.rampUpTime);
    m_backRight.setClosedLoopRampRate(kDriveTrain.rampUpTime);
    m_frontLeft.setClosedLoopRampRate(kDriveTrain.rampUpTime);
    m_backLeft.setClosedLoopRampRate(kDriveTrain.rampUpTime);

    // Creating motor groups for drive
    m_backRight.follow(m_frontRight);
    m_backLeft.follow(m_frontLeft);

    m_backRight.setInverted(true);
    m_frontRight.setInverted(true);

    // Robot now knows left and right side are now in DifferentialDrive object
    // Robot is self-aware of drivetrain
    m_driveTrain = new DifferentialDrive(m_frontRight, m_frontLeft);

  }

  public void arcadeDrive(double speed, double rotation) {
    m_driveTrain.arcadeDrive(speed, rotation);
  }

  public double getDistance() {
    return m_frontRightEncoder.getPosition();
  }

  // This method should stop the robot in speed direction
  public void stopDrive() {
    m_driveTrain.arcadeDrive(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

}
