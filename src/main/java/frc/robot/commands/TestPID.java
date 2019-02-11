/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.Extensions.PIDFix;

public class TestPID extends Command {
  public TestPID() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.Elevator);
    //requires(Robot.PID);
    requires(Robot.MoveRefGen);

    System.out.println("hey");

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

  
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println("Hello world");
    Robot.Elevator.setTarget(19-(51/8));  
   if(Robot.Elevator.encoderGetDistLeft()<Robot.Elevator.getTarget()){
    if(Robot.Elevator.encoderGetDistLeft() <= 0){
      Robot.Elevator. liftUp(.50);
    }
    if(Robot.Elevator.encoderGetDistLeft() > Robot.Elevator.getTarget()*.7)
      Robot.Elevator.liftUp(.2);
  }
    if(Robot.Elevator.encoderGetDistLeft() > Robot.Elevator.getTarget()*.9){
      Robot.Elevator.liftUp(.1);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.Elevator.success();
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
