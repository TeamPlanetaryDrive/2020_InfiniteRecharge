/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.lift;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LiftToLevel extends Command {
  // this array represents all the levels that we can lift to.
  private static final double[] LIFT_PRESETS = new double[]{
    9.9573 * 1.58,
    27.5 - (51 / 8),
    47 - (51 / 8),
    55.5 - (51 / 8),
    74 - (51 / 8),
    83.5 - (51 / 8)
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
