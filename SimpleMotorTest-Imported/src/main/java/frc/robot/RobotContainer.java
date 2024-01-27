// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.commands.ExampleCommand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandPS4Controller m_driverController =
      new CommandPS4Controller(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
    //m_exampleSubsystem.setDefaultCommand(new ExampleCommand(m_exampleSubsystem));
    //m_exampleSubsystem.setDefaultCommand(new InstantCommand(() -> m_exampleSubsystem.runMotors()));
    m_driverController.cross().onTrue(new ExampleCommand(m_exampleSubsystem, 0.45));
    m_driverController.cross().onFalse(new ExampleCommand(m_exampleSubsystem, 0));
    /*m_driverController.circle().onTrue(new ExampleCommand(m_exampleSubsystem, 0.75));
    m_driverController.square().onTrue(new ExampleCommand(m_exampleSubsystem, 0.25));
    m_driverController.triangle().onTrue(new ExampleCommand(m_exampleSubsystem, 1));*/
    //m_driverController.cross().onTrue(new InstantCommand(() -> m_exampleSubsystem.runMotor()));

    //m_driverController.cross().onTrue(new InstantCommand(() -> ExampleSubsystem.runMotors()));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
