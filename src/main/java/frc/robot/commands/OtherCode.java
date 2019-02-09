/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class OtherCode extends Command {
  public static enum ElevatorPosition {
    Bottom, RocketBottom, RocketMiddle, RocketTop, ShipLevel;

    public static final double resolve(ElevatorPosition pos) {
      switch (pos) {

      case Bottom:
        return 0;
      case RocketBottom:
        return 0;
      case RocketMiddle:
        return 100;
      case RocketTop:
        return 200;
      case ShipLevel:
        return 50;
      default:
        return 10;

      }
    }
  }

  ElevatorPosition pos;

  public OtherCode(ElevatorPosition pos) {
    requires(Robot.Elevator);
    this.pos = pos;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.Elevator.setTarget(ElevatorPosition.resolve(pos));
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.Elevator.success() && Robot.Elevator.getTarget() == ElevatorPosition.resolve(pos);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    // Robot.elevator.stop();
  }
}