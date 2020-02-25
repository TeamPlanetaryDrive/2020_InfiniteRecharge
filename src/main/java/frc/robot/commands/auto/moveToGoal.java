/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class moveToGoal extends CommandBase {
  /**
   * Creates a new test.
   */
  NetworkTableInstance inst;
  NetworkTable table;
  NetworkTableEntry goalWidth;
  public final double DISTANCE_CONSTANT = 12841.93333; //goal width * distance from goal
  double dist;
  double[] defaultArray;

  public moveToGoal() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.Cameras, Robot.Drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("initialized moveToGoal");
    inst = NetworkTableInstance.getDefault();
    table = inst.getTable("GRIP/goalContours");
    goalWidth = table.getEntry("width");
    inst.startClientTeam(2856);
    inst.startDSClient();

    defaultArray = new double[0];
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      System.out.println("ran execute()");
      Robot.Drive.drive(.46, .46);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished(){
    if(goalWidth.getDoubleArray(defaultArray).length == 0)
      return true;
    dist = DISTANCE_CONSTANT / goalWidth.getDoubleArray(defaultArray)[0];
    return dist <= 120; //within 10ft of goal
  }
}
