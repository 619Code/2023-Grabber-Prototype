package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.Grabber;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class GrabCommand extends CommandBase {
    private final Grabber grabber;
    private int limit;

    public GrabCommand(Grabber grabber, boolean isCube) {
        this.grabber = grabber;

        addRequirements(grabber);

        if(isCube) {
            limit = 15;
        } else {
            limit = 37;
        }
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        if(limit > grabber.getPosition()) {
            grabber.spinMotor(1, Constants.MAX_SPEED);
        } else {
            grabber.stop();
            grabber.grabbing = true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        grabber.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
