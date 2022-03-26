// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveTrain;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.XboxController;

/** An example command that uses an example subsystem. */
public class ArcadeDriveCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final DriveTrain m_drivetrain;
  private final double m_speed, m_direction;
  private final XboxController controller0 = new XboxController(0);

  /**
   * Creates a new ExampleCommand.
   *
   * @param drivetrain The subsystem used by this command.
   */
  public ArcadeDriveCommand(DriveTrain drivetrain, DoubleSupplier speed, DoubleSupplier direction) {
    m_speed = speed.getAsDouble();
    m_direction = direction.getAsDouble();
    m_drivetrain = drivetrain;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double converted_speed = controller0.getLeftY() * .8;
    double converted_rotation = controller0.getRightY() * .8;

    if (controller0.getRightBumper()) { // This is for speed up
      converted_speed = controller0.getLeftY() * 0.9;
      converted_rotation = controller0.getRightY() * 0.9;
    } else if (controller0.getLeftBumper()) {
      converted_speed = controller0.getLeftY() * 0.65;
      converted_rotation = controller0.getRightY() * 0.65;
    }
    m_drivetrain.arcadeDrive(converted_speed, converted_rotation);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.stopDrive();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}
