package frc.robot.commands;

import frc.robot.subsystems.Grabber;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class GrabCommand extends CommandBase {
    private final Grabber grabber;
    private CommandXboxController controller;
    private int limit;

    public GrabCommand(Grabber grabber, CommandXboxController controller, boolean isCube) {
        this.controller = controller;
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
            grabber.spinMotor(1, 0.6);
        } else {
            grabber.stop();
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
