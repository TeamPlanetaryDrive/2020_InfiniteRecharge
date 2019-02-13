/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.*;
//use this for anything on th drivetrain like guiding electricty or something (likely redundent so delete if un needed)
/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem here. Call these from Commands.

  /*
  //Wood Robot Code
  Jaguar w_left = new Jaguar(0);
  Jaguar w_right = new Jaguar(1);

  DifferentialDrive robotDrive = new DifferentialDrive(w_left, w_right);
  */

  //Metal Robot Code
  
  Spark m_left = new Spark(0);
  Spark m_right = new Spark(1);

  DifferentialDrive robotDrive = new DifferentialDrive(m_left, m_right);
  

  //New Metal Robot Code

  public DifferentialDrive getDrive(){return robotDrive;}

  public SpeedController getSPRight(){return m_right;}
  public SpeedController getSPLeft(){return m_left;}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    //setDefaultCommand(new Motion());
    setDefaultCommand(new RobotMovement());
  }
}
