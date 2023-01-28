package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Grabber extends SubsystemBase {
    private CANSparkMax grabberMotor;
    private RelativeEncoder grabberEncoder;
    public boolean grabbing = false;

    public Grabber() {
        grabberMotor = new CANSparkMax(15, MotorType.kBrushless);
        grabberMotor.restoreFactoryDefaults();
        grabberMotor.setIdleMode(IdleMode.kBrake);

        grabberEncoder = grabberMotor.getEncoder();
        grabberEncoder.setPosition(0); //zero position
    }

    public void spinMotor(double speed, double speedMax) {
        grabberMotor.set(speed * speedMax);
        SmartDashboard.putNumber("Rotations", getPosition());
    }

    public void stop() {
        grabberMotor.set(0);
    }

    public double getPosition() {
        return grabberEncoder.getPosition();
    }

    @Override
    public void periodic() {
    }
}
