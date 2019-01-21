/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Motion;



public class RobotMovement extends Command {
 int timer; // use as a variable to compare to the time left in the game, if 0 , we stop
 int forceStop; // use a int value like -1 in force stop to stop the bot, not sure if needed

 //these variables are not final and fully subject to change

  public RobotMovement() {
    //6 wheels 2 motors
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.D_Motion);
    int timer = 9498374; //set this to the timer game timer, subject to change
    int forceStop = -1; // set motor speed to this value to stop it on a snap
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
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
