/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.OI;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PneumaticTest extends Command {
  DoubleSolenoid testSolenoid;
  //Boolean position;
  int timer;
  public PneumaticTest() {
    requires(Robot.PneumaticsTest);
    testSolenoid = new DoubleSolenoid(1,2); // 1 & 2 are port numbers, not sure which ports they are going in so change these as needed
    // position = false; //false is the default position where the piston is not extended and true is extended
    timer= 0;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    testSolenoid.set(DoubleSolenoid.Value.kOff);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // Will stay extended for 200 units of time (no idea what that time is) 
    if(timer <200){
      testSolenoid.set(DoubleSolenoid.Value.kForward);
      timer++;
    }
    else{
      testSolenoid.set(DoubleSolenoid.Value.kReverse);
      timer = timer+1;
    }
}

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(timer==205)
      return true;
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    testSolenoid.set(DoubleSolenoid.Value.kOff);
  }

  // Called when another command which requires one or more of the same subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}