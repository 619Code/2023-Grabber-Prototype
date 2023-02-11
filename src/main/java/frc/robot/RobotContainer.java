package frc.robot;

import frc.robot.Constants;
import frc.robot.commands.GrabCommand;
import frc.robot.commands.GrabZeroCommand;
import frc.robot.commands.ReleaseCommand;
import frc.robot.commands.masters.GrabMasterCommand;
import frc.robot.commands.masters.ZeroMasterCommand;
import frc.robot.subsystems.Grabber;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.GrabManualCommand;

public class RobotContainer {
    private final Grabber grabber;
    private GrabManualCommand grabManualCommand;

    private final CommandXboxController controller = new CommandXboxController(Constants.CONTROLLER_PORT);

    public RobotContainer() {

        grabber = new Grabber();
        grabManualCommand = new GrabManualCommand(grabber, controller);
        grabber.setDefaultCommand(grabManualCommand);

        configureBindings();
    }

    /*
     * A: 
     * Y: pick up / release cone
     * X: pick up / release cube
     */
    private void configureBindings() {
        Trigger zeroButton = controller.a();
        zeroButton.onTrue(new ZeroMasterCommand(grabber));
        Trigger coneButton = controller.y();
        coneButton.onTrue(new GrabMasterCommand(grabber, false));
        Trigger cubeButton = controller.x();
        cubeButton.onTrue(new GrabMasterCommand(grabber, true));
    }

    public Command getAutonomousCommand() {
        return null;
    }
}
