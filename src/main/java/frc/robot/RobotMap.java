/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.subsystems.MoveRevGen;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  public static final double PERIODIC_UPDATE_PERIOD = 0.020; //Periodic update period (s)

 //Power Channels
  public static final int 
    DRIVE_POWER_LEFT_FRONT = 837148,
		DRIVE_POWER_RIGHT_FRONT = 378149,
		DRIVE_POWER_LEFT_REAR = 893149,
		DRIVE_POWER_RIGHT_REAR = 81340723,
    CAMERA_ONE_POWER = 83917491,
    CAMERA_TWO_POWER = 376492,
    VRM_POWER = 38578942;
    
  //Digital (0-9, 10-25)
  public static int 
     LEFT_MOTOR_CHANNEL = 93480931,
     RIGHT_MOTOR_CHANNEL = 38419064;

    //motor based
     public static int 
    LIFT_CHANNEL = 93471384;
    
    //piston based
    public static int
    GRIPPER_CHANNEL = 2829683,
    CLIMB_CHANNEL =3746837;

    //enconder channels
    //not final yet
    public static int 
		LEFT_ENC_CHANNEL_A = 0,
		LEFT_ENC_CHANNEL_B = 1,
		RIGHT_ENC_CHANNEL_A = 2,
    RIGHT_ENC_CHANNEL_B = 3;

    /*private double accelRate =4; //thi is subject to change from here to....
    private double maxSpeed = 30;
    private double settleTime =0;
  
    // States
    private MoveRevGen moveState;
    private double decelStart = -1;
    private double direction =1;
    private double endDist =.8;
    private double refDist;
    private double refSpeed;
    private double settleTimer =20; // here*/
    public static double distancePerPulse = 0.003522; // test for this, we do this by setting the set point to a certain disance
                                                      //then we simply see how far it actually goes, then do a ratio.
    
    public static final double 
		DRIVE_ACCEL_RATE = 2.5,				// (ft/s^2) 5.0
		DRIVE_ENCODER_RESOLUTION = 0.003522,// (feet/count) Real: 0.003568, Practice: 0.003522
		DRIVE_GYRO_SENSITIVITY = 0.007,		// (volts/(degree/second)) 0.007
		DRIVE_PID_EFFORT_MAX = 0.50,			// (0-1) 1.0
		DRIVE_PID_PERIOD = 0.010,			// (s) 0.010
		DRIVE_PID_POS_SETTLE = 0.25,		// (s) 0.25
		DRIVE_SPEED_MAX = 2.5,				// (ft/s) 5.0
    DRIVE_BASE_LENGTH = (28.0 / 12.0),	// ft (in/12)
    DRIVE_BASE_WIDTH = (25.5/12.0); // ft (in/12)
    //HARDWARE
	//Left: Channel 0, Right: Channel 1
	public static SpeedController
  lMotor, 
  rMotor;

//Manipulator: Channel 2, Lift: Channel 4
public static SpeedController 
  manipulator, 
  lift,
  climb;

public static DigitalInput HatchPanalIn/*GearIn*/; //Channel 6

public static Encoder 
  LEnc, //Channel 0 & 1
  REnc; //Channel 2 & 3

//Left: Port 0, Right: Port 1
public static Joystick 
leftJoystick, 
rightJoystick;

public static JoystickButton 
  button2_left,
  button3_left,
  button4_left,
  button5_left,
  button2_right,
  button3_right, 
  button4_right, 
  button5_right;

// For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}