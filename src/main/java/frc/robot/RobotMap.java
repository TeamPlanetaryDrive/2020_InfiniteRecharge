/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
 // public static final double PERIODIC_UPDATE_PERIOD = 0.020; //Periodic update period (s)

 //Power Channels
  public static final int 
    DRIVE_POWER_LEFT_FRONT = 0,
		DRIVE_POWER_RIGHT_FRONT = 1,
		DRIVE_POWER_LEFT_REAR = 2,
		DRIVE_POWER_RIGHT_REAR = 3,
		CAMERA_POWER = 4,
    VRM_POWER = 5;
    
  //Digital (0-9, 10-25)
  public static int 
     LEFT_MOTOR_CHANNEL = 0,
     RIGHT_MOTOR_CHANNEL = 1;

  public static int 
		LIFT_CHANNEL = 4;

// For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}