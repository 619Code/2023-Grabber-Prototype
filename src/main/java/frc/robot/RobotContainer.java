package frc.robot;

import frc.robot.Constants;
import frc.robot.commands.GrabCommand;
import frc.robot.commands.GrabMasterCommand;
import frc.robot.commands.ReleaseCommand;
import frc.robot.subsystems.Grabber;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
    private final Grabber grabber;

    private final CommandXboxController controller = new CommandXboxController(Constants.CONTROLLER_PORT);

    public RobotContainer() {

        grabber = new Grabber();

        configureBindings();
    }

    /*
     * A: pick up / release cone
     * B: pick up / release cube
     */
    private void configureBindings() {
        Trigger coneButton = controller.a();
        coneButton.onTrue(new GrabMasterCommand(grabber, false));
        Trigger cubeButton = controller.b();
        cubeButton.onTrue(new GrabMasterCommand(grabber, true));
    }

    public Command getAutonomousCommand() {
        return null;
    }
}
