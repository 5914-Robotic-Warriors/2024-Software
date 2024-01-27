package frc.robot.commands;

import frc.robot.Constants;

public class Deadband {
    public double driveAdjustment(double stickVal) {
        if (stickVal >= Constants.driveDeadband || stickVal <= -Constants.driveDeadband) {
            return stickVal;
        } else {
            return 0;
        }
    }
}
