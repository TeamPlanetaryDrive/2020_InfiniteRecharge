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

public class TestPId extends Command {
  public TestPId() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.PID);
    requires(Robot.Drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.PID.init(Robot.Drive.getSPLeft(), false , RobotMap.LEnc);
    Robot.MoveRefGen.configure(Robot.PID.returnPIDInput(), 0.5, 40.0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    Robot.PID.setSetpoint(19-(51/8));
    Robot.MoveRefGen.start(19-(51/8));
    Robot.PID.enable();
    while(Robot.MoveRefGen.isActive()==true)
      Robot.MoveRefGen.update();
      


  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Robot.MoveRefGen.getRefPosition() >= Robot.PID.getSetpoint())
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
