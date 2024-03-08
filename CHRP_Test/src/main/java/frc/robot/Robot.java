// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.Orchestra;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {

  TalonFX motor1 = new TalonFX(1);
  TalonFX motor2 = new TalonFX(2);
  TalonFX motor3 = new TalonFX(3);
  TalonFX motor4 = new TalonFX(4);
  TalonFX motor5 = new TalonFX(5);
  TalonFX motor6 = new TalonFX(6);
  TalonFX motor7 = new TalonFX(7);
  TalonFX motor8 = new TalonFX(8);
  TalonFX motor9 = new TalonFX(9);
  TalonFX motor10 = new TalonFX(10);
  TalonFX motor21 = new TalonFX(21);
  TalonFX motor22 = new TalonFX(22);
  TalonFX motor24 = new TalonFX(24);
  TalonFX motor27 = new TalonFX(27);
  TalonFX motor44 = new TalonFX(44);
  TalonFX motor45 = new TalonFX(45);


  Orchestra orchestra = new Orchestra();

  @Override
  public void robotInit() {
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    orchestra.addInstrument(motor1, 0);
    orchestra.addInstrument(motor2, 1);
    orchestra.addInstrument(motor3, 2);
    orchestra.addInstrument(motor4, 3);
    orchestra.addInstrument(motor5, 4);
    orchestra.addInstrument(motor6, 5);
    orchestra.addInstrument(motor7, 6);
    orchestra.addInstrument(motor8, 8);
    orchestra.addInstrument(motor9, 9);
    orchestra.addInstrument(motor10, 0);
    orchestra.addInstrument(motor21, 1);
    orchestra.addInstrument(motor22, 2);
    orchestra.addInstrument(motor24, 3);
    orchestra.addInstrument(motor27, 4);
    orchestra.addInstrument(motor44, 5);
    orchestra.addInstrument(motor45, 6);

//Total rtobot rock tracks = 9


    var status = orchestra.loadMusic("Pirate.chrp");

    if (!status.isOK()) {
      System.out.println("File not loaded.");
    }
  }

  @Override
  public void teleopPeriodic() {
    orchestra.play();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

  @Override
  public void simulationInit() {
  }

  @Override
  public void simulationPeriodic() {
  }
}
