/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class PneumaticTest extends Command {
  DoubleSolenoid testSolenoid;
  public PneumaticTest() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.PneumaticsTest);
    testSolenoid = new DoubleSolenoid(1,2); // 1 & 2 are port numbers, not sure which ports they are going in so change these as needed
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      testSolenoid.set(DoubleSolenoid.Value.kOff);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    testSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    /* if(joystick button is pressed again){
      return true;
    }*/
    //assuming we going for left joystick
    if(RobotMap.leftJoystick.getTop())
      return true;
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    testSolenoid.set(DoubleSolenoid.Value.kOff);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
