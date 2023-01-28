package frc.robot;

import frc.robot.Constants;
import frc.robot.commands.GrabCommand;
import frc.robot.commands.ReleaseCommand;
import frc.robot.subsystems.Grabber;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
    private final Grabber grabber;

    private final CommandXboxController controller = new CommandXboxController(Constants.kDriverControllerPort);

    public RobotContainer() {

        grabber = new Grabber();
        /*ReleaseCommand releaseCommand = new ReleaseCommand(grabber, controller);
        grabber.setDefaultCommand(releaseCommand);*/

        configureBindings();
    }

    /*
     * A: pick up cone
     * B: pick up cube
     * X: release
     */
    private void configureBindings() {
        Trigger coneButton = controller.a();
        coneButton.onTrue(new GrabCommand(grabber, controller, false));
        Trigger cubeButton = controller.b();
        cubeButton.onTrue(new GrabCommand(grabber, controller, true));
        Trigger releaseButton = controller.x();
        releaseButton.onTrue(new ReleaseCommand(grabber, controller));
    }

    public Command getAutonomousCommand() {
        return null;
    }
}
