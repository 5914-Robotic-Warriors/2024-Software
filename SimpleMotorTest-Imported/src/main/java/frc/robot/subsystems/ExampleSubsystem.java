// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {

  TalonFX motor = new TalonFX(2);
  TalonFX motor2 = new TalonFX(3);

  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {
    var config = new TalonFXConfiguration();
    motor.getConfigurator().apply(config);
    motor2.getConfigurator().apply(config);
    motor.setInverted(true);
  }

  public void runMotors(double speed) {
    motor.set(speed);
    motor2.set(speed);
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
