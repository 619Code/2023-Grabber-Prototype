// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {

  private CANSparkMax motorOne;
  private CANSparkMax motorTwo;
  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {
    this.motorOne = new CANSparkMax(15, MotorType.kBrushless);
    this.motorTwo = new CANSparkMax(10, MotorType.kBrushless);
    this.motorOne.restoreFactoryDefaults();
    this.motorTwo.restoreFactoryDefaults();
    this.motorOne.setIdleMode(IdleMode.kBrake);
    this.motorTwo.setIdleMode(IdleMode.kBrake);
    this.motorTwo.follow(this.motorOne);

  }

  public void Go(double speed) {
    var speedMax = 1;
    this.motorOne.set(speed * speedMax);
    SmartDashboard.putNumber("Speed", speed*speedMax);    
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // SmartDashboard.putNumber("Grabber Volts", grabberSpark.getBusVoltage());
    // SmartDashboard.putNumber("Grabber Current", grabberSpark.getOutputCurrent());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
