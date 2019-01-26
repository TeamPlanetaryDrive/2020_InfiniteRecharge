/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

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

  //Wood Robot Code
  Jaguar w_left = new Jaguar(1);
  Jaguar w_right = new Jaguar(0);

  DifferentialDrive robotDrive = new DifferentialDrive(w_left, w_right);

  //Old Metal Robot Code
  /*
  Talon om_left = new Talon(0);
  Talon om_right = new Talon(1);

  DifferentialDrive robotDrive = new DifferentialDrive(om_left, om_right);
  */

  //New Metal Robot Code

  public DifferentialDrive getDrive(){return robotDrive;}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    //setDefaultCommand(new Motion());
    setDefaultCommand(new RobotMovement());
  }
}
