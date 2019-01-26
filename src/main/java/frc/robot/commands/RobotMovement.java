/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;;

public class RobotMovement extends Command {
 int timer; // use as a variable to compare to the time left in the game, if 0 , we stop
 SpeedController left;
 SpeedController right;
 //these variables are not final and fully subject to change

  public RobotMovement() {
    requires(Robot.Drive);
    int timer = 9498374; //set this to the timer game timer, subject to change
    //left = 0;
   // right = right.set(0.0);;
  }

  // Called just before this Command runs the first time
  protected void initialize() {
      //left = 0;
      //right = 0;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.Drive.getDrive().tankDrive(OI.leftJoystick.getY(), OI.rightJoystick.getY());
    timer--;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(timer > 0)
      return false;
    return true;
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
