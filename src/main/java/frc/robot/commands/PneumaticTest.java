/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.OI;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PneumaticTest extends Command {
  public PneumaticTest() {
    requires(Robot.PneumaticsTest);
    //testSolenoid = new DoubleSolenoid(0,1); // 1 & 2 are port numbers, not sure which ports they are going in so change these as needed
    setTimeout(0.9);
  }

  // Called just before this Command runs the first time
  
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  
  protected void execute() {
    // Will stay extended for 200 units of time (no idea what that time is) 
    Robot.PneumaticsTest.pushPiston();
}

  // Make this return true when this Command no longer needs to run execute()
  
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  
  protected void end() {
    Robot.PneumaticsTest.pullPiston();
    Robot.PneumaticsTest.pistonOff();
  }

  // Called when another command which requires one or more of the same subsystems is scheduled to run
  
  protected void interrupted() {
  }
}