package frc.robot.commands;

import frc.robot.subsystems.Grabber;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class ReleaseCommand extends CommandBase {
    private final Grabber grabber;
    private CommandXboxController controller;

    public ReleaseCommand(Grabber grabber, CommandXboxController controller) {
        this.controller = controller;
        this.grabber = grabber;

        addRequirements(grabber);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        if(grabber.getPosition() > 0) {
            grabber.spinMotor(-1, 0.6);
        } else {
            grabber.stop();
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
