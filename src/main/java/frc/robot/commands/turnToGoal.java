/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

import java.util.ArrayList;

import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
//import frc.robot.commands.grip.*;

public class turnToGoal extends CommandBase {
  NetworkTableInstance inst;
  NetworkTable table;
  NetworkTableEntry goalPosition;
  NetworkTableEntry goalWidth;
  double[] defaultArray;
  final int IMAGEWIDTH = 320;
  double goalX;
  double goodRange;
  ArrayList<MatOfPoint> contourArray;


  public turnToGoal(ArrayList<MatOfPoint> input) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    addRequirements(Robot.Drive);
    contourArray = input;
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
  
  
  
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    if (contourArray.size() > 0) {
      System.out.println("ran execute()");
      Rect r = Imgproc.boundingRect(contourArray.get(0));
      goalX = r.x + (r.width/2);
      goalX -= IMAGEWIDTH/2;
      // System.out.println("goal position: " + goalPosition.getDoubleArray(defaultArray)[0]);
      // System.out.println("image width: " + IMAGEWIDTH / 2);
      // System.out.println("goalX: " + goalX);
      int direction = (int) (goalX / Math.abs(goalX));
      System.out.println("direction: " + direction);
      Robot.Drive.drive(.35 * direction, (-.35) * direction);
      System.out.println("rotated");
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    if (contourArray.size() == 0)
      return true;
    Rect s = Imgproc.boundingRect(contourArray.get(0));
    goodRange = s.width / 3;
    // System.out.println("goodRange: " + goodRange);
    // System.out.println("goalX*2: " + goalX * 2);
    // System.out.println("END: " + (Math.abs(goalX) * 2 < goodRange));
    return Math.abs(goalX) * 2 < goodRange;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    System.out.println("END");
  }
}
