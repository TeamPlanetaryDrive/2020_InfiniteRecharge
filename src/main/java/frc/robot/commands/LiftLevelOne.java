/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.MoveRefGen;

public class LiftLevelOne extends Command {
  public LiftLevelOne() {
    //will be 1 ft 7 in for the hub zone and the hatch panals for all things
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.Elevator);
    requires(Robot.PID);
    requires(Robot.MoveRefGen);
    

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.PID.setSetpoint(19-(51/8));
    if(Robot.MoveRefGen.getRefPosition()==0)
    Robot.MoveRefGen.start(Robot.PID.getSetPoint());
    while(Robot.MoveRefGen.isActive()==true)
      Robot.MoveRefGen.update();
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Robot.PID.getPosition()>= Robot.PID.getSetPoint()&& Robot.MoveRefGen.isActive() == true )
      return true;
    
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
