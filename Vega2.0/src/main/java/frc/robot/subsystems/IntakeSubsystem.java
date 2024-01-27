package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase{
    private final CANSparkMax intakeMotor = new CANSparkMax(5, MotorType.kBrushless);

    public IntakeSubsystem(){

    }

    @Override
    public void periodic(){

    }

    public void moveIntake(double speed){
        intakeMotor.set(speed * Constants.intakeMotorSpeed);
    }
}
