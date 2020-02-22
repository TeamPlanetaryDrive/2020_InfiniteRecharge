/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

import java.util.ArrayList;

import org.opencv.core.MatOfPoint;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
//import frc.robot.commands.grip.*;

public class findGoal extends CommandBase {
  final int IMAGEWIDTH = 320;
  ArrayList<MatOfPoint> contourArray;


  public findGoal(ArrayList<MatOfPoint> input) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    addRequirements(Robot.Drive);
    contourArray = input;
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    System.out.println("initialized findGoal");
    System.out.println(contourArray);
    
  }
  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    if (contourArray.size() == 0) {
      System.out.println("ran execute()");
      Robot.Drive.drive(.46, (-.46));
      System.out.println("rotated");
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return contourArray.size() > 0;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    System.out.println("END");
  }
}
