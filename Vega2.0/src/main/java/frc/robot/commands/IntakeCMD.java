package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCMD extends Command{
    private final IntakeSubsystem intakeSubsystem;
    private final Deadband deadband;
    private final Supplier<Double> intakeFunction;

    public IntakeCMD(IntakeSubsystem intakeSubsystem, Deadband deadband, Supplier<Double> intakeFunction){
        this.intakeSubsystem = intakeSubsystem;
        this.deadband = deadband;
        this.intakeFunction = intakeFunction;
        addRequirements(intakeSubsystem);
    }
    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        double realTimeSpeed = intakeFunction.get();

        intakeSubsystem.moveIntake(realTimeSpeed);
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
    

