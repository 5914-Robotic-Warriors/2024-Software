package frc.robot.autos;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class lowCubeTaxi extends SequentialCommandGroup {
    Timer timer;

    public lowCubeTaxi(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsystem){
        timer = new Timer();

        timer.start();

        while (timer.get() < 1){
            intakeSubsystem.moveIntake(0.5);
        }

        while (timer.get() <= 3){

        }
    }
}
