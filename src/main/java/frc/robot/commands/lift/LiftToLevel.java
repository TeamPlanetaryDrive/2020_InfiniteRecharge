/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.lift;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class LiftToLevel extends Command {
  // this array represents all the levels that we can lift to.
  // quantified in "encoder values", not inches
  private static final double[] LIFT_PRESETS = new double[]{
    0,
    5.05,
    8.45,
    16.25,
    19.65,
    27.05,
    30.85
  };
  
  private int level_preset;

  public LiftToLevel(int level) {
    // Will be 2 ft 3 and 1/2 in to get to the port for the balls
    requires(Robot.Elevator);
    level_preset = level;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.Elevator.enable();
    Robot.Elevator.setSetpoint(LIFT_PRESETS[level_preset]);
    System.out.print(RobotMap.liftEncoder.getDistance());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.Elevator.onTarget();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
