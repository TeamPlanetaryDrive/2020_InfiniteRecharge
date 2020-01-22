/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.multi;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class aimShooter extends CommandBase {
  double turnAmount;
  double targetAngle;

  /**
   * Creates a new aimShooter.
   */
  public aimShooter(double target) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.MultiSystem);
    targetAngle = target;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //must choose direction and speed of turning
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.MultiSystem.rotateShooter(turnAmount);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Robot.MultiSystem.getShooterAngle() == targetAngle;
  }
}