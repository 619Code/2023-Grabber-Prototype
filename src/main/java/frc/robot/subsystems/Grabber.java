package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Grabber extends SubsystemBase {
    private CANSparkMax grabberMotor;
    private RelativeEncoder grabberEncoder;
    private DigitalInput limitSwitch;

    public boolean grabbing = false;
    public boolean zeroed = false;

    public Grabber() {
        grabberMotor = new CANSparkMax(Constants.MOTOR_PORT, MotorType.kBrushless);
        grabberMotor.restoreFactoryDefaults();
        grabberMotor.setIdleMode(IdleMode.kBrake);

        grabberEncoder = grabberMotor.getEncoder();
        grabberEncoder.setPosition(0); //zero position

        limitSwitch = new DigitalInput(Constants.SWITCH_PORT);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Velocity", grabberEncoder.getVelocity());
        SmartDashboard.putBoolean("Switch", switchIsPressed());
    }

    public void spinMotor(double speed, double speedMax) {
        if(speed > 0 && switchIsPressed()) {
            stop();
        } else {
            grabberMotor.set(speed * speedMax);
        }
        
        SmartDashboard.putNumber("Position", getPosition());
    }

    public void stop() {
        grabberMotor.set(0);
    }

    public double getPosition() {
        return grabberEncoder.getPosition();
    }

    public boolean switchIsPressed() {
        return limitSwitch.get();
    }

    public void zeroAtPosition(double position) {
        grabberEncoder.setPosition(position);
    }
}
