/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.climb;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class raiseRobot extends CommandBase {
  /**
   * Creates a new raiseRobot.
   */
  public raiseRobot() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.Climber);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.Climber.setSpeed(-1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.Climber.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Robot.Climber.getHeight() < 0;
  }
}
