package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class MecanumDriveCommand extends Command {

    private final DriveSubsystem driveSubsystem;
    private final Deadband deadband;
    private final Supplier<Double> driveFunction, strafeFunction, rotFunction;

    public MecanumDriveCommand(DriveSubsystem driveSubsystem, Deadband deadband, Supplier<Double> driveFunction,
            Supplier<Double> strafeFunction, Supplier<Double> rotFunction) {
        this.driveSubsystem = driveSubsystem;
        this.deadband = deadband;
        this.driveFunction = driveFunction;
        this.strafeFunction = strafeFunction;
        this.rotFunction = rotFunction;
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        double realTimeDrive = driveFunction.get();
        double realTimeStrafe = strafeFunction.get();
        double realTImeRot = rotFunction.get();

        driveSubsystem.drive(deadband.driveAdjustment(realTimeDrive), deadband.driveAdjustment(realTimeStrafe),
                deadband.driveAdjustment(realTImeRot));
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
