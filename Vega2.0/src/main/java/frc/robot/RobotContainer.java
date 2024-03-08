// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.autos.lowCubeTaxi;
import frc.robot.commands.Deadband;
import frc.robot.commands.DriveForwardCMD;
import frc.robot.commands.IntakeCMD;
import frc.robot.commands.MecanumDriveCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.Limelight;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  //private final Limelight m_Limelight = new Limelight();
  private final Deadband m_deadband = new Deadband();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final PS4Controller stick = new PS4Controller(0);

  //Autos
  private final Command lowCubeTaxi = new lowCubeTaxi(m_driveSubsystem, m_intakeSubsystem);
  private final Command noAuto = null;

  //Sendablechooser
  SendableChooser<Command> m_Chooser = new SendableChooser<>();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    m_driveSubsystem.setDefaultCommand(new MecanumDriveCommand(m_driveSubsystem, m_deadband, () -> (-stick.getLeftY()),
        () -> stick.getLeftX(), () -> stick.getRightX()));

    m_intakeSubsystem
        .setDefaultCommand(new IntakeCMD(m_intakeSubsystem, m_deadband, () -> (stick.getL2Axis() - stick.getR2Axis())));

    // Configure the trigger bindings
    configureBindings();

    
  //Chooser stuff
  m_Chooser.addOption("Low cube taxi", lowCubeTaxi);
  m_Chooser.addOption("No auto", noAuto);
  

  SmartDashboard.putData(m_Chooser);
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return lowCubeTaxi;
  }
}
