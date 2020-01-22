/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.lift;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class manualLiftMove extends CommandBase {
  public double setPoint;

  public manualLiftMove() {
    addRequirements(Robot.Elevator);
    setPoint = 0;
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    // System.out.println(RobotMap.liftEncoder.getDistance() + "Encoder");
    if (RobotMap.leftJoystick.getTrigger()) {
      Robot.Elevator.enable();
      System.out.println("leftTrigger reached");
      setPoint += ((-RobotMap.rightJoystick.getZ())-1) / 200;
      Robot.Elevator.setSetpoint(setPoint);
      System.out.println(setPoint);
    }
    if (RobotMap.rightJoystick.getTrigger()) {
      Robot.Elevator.enable();
      System.out.println("RightTrigger reached");
      setPoint += ((RobotMap.rightJoystick.getZ() + 1)) / 200;
      Robot.Elevator.setSetpoint(setPoint);
      System.out.println(setPoint);
     
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return !RobotMap.leftJoystick.getTrigger() || !RobotMap.rightJoystick.getTrigger();
  }

  // Called once after isFinished returns true or is interrupted
  @Override
  public void end(boolean interrupted) {
  }


