package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class DriveForwardCMD extends Command {
    private final DriveSubsystem driveSubsystem;
    private Timer timer = new Timer();

    public DriveForwardCMD(DriveSubsystem driveSubsystem) {
        this.driveSubsystem = driveSubsystem;

        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println("DriveForwardCmd started!");
        timer.start();
    }

    @Override
    public void execute() {
        driveSubsystem.drive(0, 0.5, 0);
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.drive(0, 0, 0);
        System.out.println("DriveForwardCmd ended!");
    }

    @Override
    public boolean isFinished() {
        if (timer.hasElapsed(5)) {
            return true;
        } else {
            return false;
        }
    }

}
