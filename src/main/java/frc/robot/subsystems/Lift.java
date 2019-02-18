/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;
import frc.robot.commands.lift.ManualLiftMove;

//use to move the grippers up and down on the elevator
public class Lift extends PIDSubsystem {

  public Lift() {
    super("Lift", 0.025, 0, 0);

    setOutputRange(-0.20, 0.2);
    setAbsoluteTolerance(0.01);
    getPIDController().setContinuous(true);
    RobotMap.liftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
  }

  public void initDefaultCommand() {
    setDefaultCommand(new ManualLiftMove());
  }

  // inherited methods
  protected double returnPIDInput() {
    return RobotMap.liftEncoder.getDistance(); // returns the sensor value that is providing the feedback for the system
  }

  protected void usePIDOutput(double output) {
    liftMove(output); // this is where the computed output value from the PIDController is applied to
                      // the motor
  }

  public void liftMove(double speed) {
    RobotMap.lift.set(speed);
  }
}
