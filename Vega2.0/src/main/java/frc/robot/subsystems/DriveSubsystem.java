// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

  private final CANSparkMax frontLeftDrivemotor = new CANSparkMax(4, MotorType.kBrushless);
  private final CANSparkMax frontRightDrivemotor = new CANSparkMax(2, MotorType.kBrushless);
  private final CANSparkMax backLeftDrivemotor = new CANSparkMax(3, MotorType.kBrushless);
  private final CANSparkMax backRightDrivemotor = new CANSparkMax(1, MotorType.kBrushless);

 // private final AHRS ahrs = new AHRS(SerialPort.Port.kUSB);

  private final MecanumDrive m_robotDrive = new MecanumDrive(frontLeftDrivemotor, backLeftDrivemotor,
      frontRightDrivemotor, backRightDrivemotor);

  /** Creates a new ExampleSubsystem. */
  public DriveSubsystem() {
    frontRightDrivemotor.setInverted(true);
    backRightDrivemotor.setInverted(true);

    frontLeftDrivemotor.setIdleMode(IdleMode.kBrake);
    frontRightDrivemotor.setIdleMode(IdleMode.kBrake);
    backLeftDrivemotor.setIdleMode(IdleMode.kBrake);
    backRightDrivemotor.setIdleMode(IdleMode.kBrake);

   // ahrs.calibrate();
  }

  @Override
  public void periodic() {
    //SmartDashboard.putNumber("NavX yaw value:", ahrs.getAngle());
  }

  public void drive(double xSpeed, double ySpeed, double zRotation) {
    m_robotDrive.driveCartesian(xSpeed, ySpeed, zRotation/*, Rotation2d.fromDegrees(ahrs.getAngle())*/);
  }
}
