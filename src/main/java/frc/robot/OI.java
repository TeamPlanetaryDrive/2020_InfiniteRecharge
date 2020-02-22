/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import frc.robot.commands.lift.*;
import frc.robot.commands.auto.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is what binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public OI() {
    // teleop lift controls
    //RobotMap.button8_left.whileHeld(new ManualLift());
    //RobotMap.button3_right.whenPressed(new auto2Test());
    RobotMap.button2_right.whenPressed(new ButtonPlease());
    //RobotMap.button4_right.whenPressed(new turnToGoal());

  }
}
