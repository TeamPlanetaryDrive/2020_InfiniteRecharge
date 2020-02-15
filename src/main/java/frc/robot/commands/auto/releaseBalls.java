/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;;

public class releaseBalls extends CommandBase {
  
  double idealWheel = 0; //Constant for when wheels are spinning and ready to fire
  /**
   * Creates a new releaseBall.
   */
  public releaseBalls() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.MultiSystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.MultiSystem.getWheelSpeed() >= idealWheel) {
      Robot.MultiSystem.barrierDown();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.MultiSystem.barrierUp();
  }

  // Returns true when the command should end.
  //@Override
  //public boolean isFinished() {
  //  return false; //if button is not pressed
  //}
}