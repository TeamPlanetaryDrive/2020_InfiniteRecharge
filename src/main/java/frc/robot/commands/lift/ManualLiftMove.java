/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.lift;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class ManualLiftMove extends Command {
  double setPoint;
  public ManualLiftMove() {
    requires(Robot.Elevator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    setPoint = 0;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(OI.leftJoystick.getTrigger()){
      setPoint += (-Robot.m_oi.getRightJoyStick().getZ()+1)/2;
      Robot.Elevator.setSetpoint(setPoint);
    }
    if(OI.rightJoystick.getTrigger()){
      setPoint += (Robot.m_oi.getRightJoyStick().getZ()+1)/2;
      Robot.Elevator.setSetpoint(setPoint);  
    }
}

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return !Robot.m_oi.getLeftJoystick().getTrigger() || !!Robot.m_oi.getRightJoyStick().getTrigger() ;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {}

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {}
}
