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

public class PneumaticTest extends Command {
  DoubleSolenoid testSolenoid;
  Boolean position;
  public PneumaticTest() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.PneumaticsTest);
    testSolenoid = new DoubleSolenoid(1,2); // 1 & 2 are port numbers, not sure which ports they are going in so change these as needed
    position = false; //false is the default position where the piston is not extended and true is extended
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      testSolenoid.set(DoubleSolenoid.Value.kOff);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(position == false){
    testSolenoid.set(DoubleSolenoid.Value.kForward);
    position = true;
  }
    else{
      testSolenoid.set(DoubleSolenoid.Value.kReverse);
      position =false;
    }
}

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
   /* if(joystick button is pressed(not the one used to execute)){
      return true;
   }*/
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