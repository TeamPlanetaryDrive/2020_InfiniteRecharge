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
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.grip.MoveGripPiston;
import frc.robot.commands.grip.PartialPneumaticClose;
import frc.robot.commands.lift.LiftToLevel;
import frc.robot.commands.lift.manualMotorLift;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
        public static final double PERIODIC_UPDATE_PERIOD = 0.020; // Periodic update period (s)

        // Power Channels
        public static final int DRIVE_POWER_LEFT_FRONT = 837148, DRIVE_POWER_RIGHT_FRONT = 378149,
                        DRIVE_POWER_LEFT_REAR = 893149, DRIVE_POWER_RIGHT_REAR = 81340723, CAMERA_ONE_POWER = 0,
                        CAMERA_TWO_POWER = 1, VRM_POWER = 38578942;

        // Camera Resolution Dimensions
        public static final int CAMERA_RESOLUTION_WIDTH = 320, CAMERA_RESOLUTION_HEIGHT = 240;

        // Digital (0-9, 10-25)
        public static int LEFT_MOTOR_CHANNEL = 0, RIGHT_MOTOR_CHANNEL = 1;

        // motor based
        public static int LIFT_CHANNEL = 2;

        // piston based
        public static int GRIPPER_CHANNEL_A = 0, GRIPPER_CHANNEL_B = 2;

        // Drive system PID Parameters
        public static final double DRIVE_PID_POSITION_KP = 2.00, // 2.00
                        DRIVE_PID_POSITION_KI = 0.01, // 0.01
                        DRIVE_PID_POSITION_KD = 1.00, // 1.00
                        DRIVE_PID_ANGLE_KP = 0.02, DRIVE_PID_ANGLE_KI = 0.001, DRIVE_PID_ANGLE_KD = 0.0;

        // enconder channels
        // not final yet
        public static int LIFT_ENC_CHANNEL_A = 0, LIFT_ENC_CHANNEL_B = 1;
        // LEFT_ENC_CHANNEL_A = 0,
        // LEFT_ENC_CHANNEL_B = 1,
        // RIGHT_ENC_CHANNEL_A = 2,
        // RIGHT_ENC_CHANNEL_B = 3;

        /*
         * private double accelRate =4; //thi is subject to change from here to....
         * private double maxSpeed = 30; private double settleTime =0;
         * 
         * // States private MoveRevGen moveState; private double decelStart = -1;
         * private double direction =1; private double endDist =.8; private double
         * refDist; private double refSpeed; private double settleTimer =20; // here
         */
        public static double distancePerPulse = 0.003522; // test for this, we do this by setting the set point to a
                                                          // certain
                                                          // disance
                                                          // then we simply see how far it actually goes, then do a
                                                          // ratio.
        public static final boolean GRIPPER_EXTEND = true, GRIPPER_RETRACT = false;
        public static boolean pneumaticsStart = false;

        public static final double DRIVE_ACCEL_RATE = 2.5, // (ft/s^2) 5.0
                        DRIVE_ENCODER_RESOLUTION = 1.0, // (feet/count) Real: 0.003568, Practice: 0.003522
                        DRIVE_GYRO_SENSITIVITY = 0.007, // (volts/(degree/second)) 0.007
                        DRIVE_PID_EFFORT_MAX = 0.50, // (0-1) 1.0
                        DRIVE_PID_PERIOD = 0.010, // (s) 0.010
                        DRIVE_PID_POS_SETTLE = 0.25, // (s) 0.25
                        DRIVE_SPEED_MAX = 2.5, // (ft/s) 5.0
                        DRIVE_BASE_LENGTH = (28.0 / 12.0), // ft (in/12)
                        DRIVE_BASE_WIDTH = (25.5 / 12.0); // ft (in/12)
        // HARDWARE
        // Left: Channel 0, Right: Channel 1
        public static Talon lMotor, rMotor;

        // Manipulator: Channel 2, Lift: Channel 4
        public static SpeedController lift;
        public static boolean liftStart;

        public static DigitalInput HatchPanalIn/* GearIn */; // Channel 6

        public static Encoder LEnc, // Channel 0 & 1
                        REnc, liftEncoder; // Channel 2 & 3

        // joystick variables
        public static int LEFT_JOYSTICK_PORT = 0, RIGHT_JOYSTICK_PORT = 1;

        public static Joystick leftJoystick = new Joystick(LEFT_JOYSTICK_PORT);
        public static Joystick rightJoystick = new Joystick(RIGHT_JOYSTICK_PORT);
        public static JoystickButton button2_left, button3_left, button4_left, button5_left, button8_left, button9_left;

        public static JoystickButton button2_right, button3_right, button4_right, button5_right, button8_right;

        // For example to map the left and right motors, you could define the
        // following variables to use with your drivetrain subsystem.
        // public static int leftMotor = 1;
        // public static int rightMotor = 2;

        // If you are using multiple modules, make sure to define both the port
        // number and the module. For example you with a rangefinder:
        // public static int rangefinderPort = 1;
        // public static int rangefinderModule = 1;
        public static void init() {
                // LEnc = new Encoder(LEFT_ENC_CHANNEL_A, LEFT_ENC_CHANNEL_B);
                // REnc = new Encoder(RIGHT_ENC_CHANNEL_A, RIGHT_ENC_CHANNEL_B);
                // instantiating buttons
                button2_left = new JoystickButton(leftJoystick, 2);
                button3_left = new JoystickButton(leftJoystick, 3);
                button4_left = new JoystickButton(leftJoystick, 4);
                button5_left = new JoystickButton(leftJoystick, 5);
                button8_left = new JoystickButton(leftJoystick, 8);
                button9_left = new JoystickButton(leftJoystick, 9);

                button2_right = new JoystickButton(rightJoystick, 2);
                button3_right = new JoystickButton(rightJoystick, 3);
                button4_right = new JoystickButton(rightJoystick, 4);
                button5_right = new JoystickButton(rightJoystick, 5);
                button8_right = new JoystickButton(rightJoystick, 8);

                // lift variables instantiated and get functions called
                liftEncoder = new Encoder(LIFT_ENC_CHANNEL_A, LIFT_ENC_CHANNEL_B);
                liftEncoder.setDistancePerPulse(distancePerPulse);
                liftEncoder.reset();
                liftEncoder.setReverseDirection(true);
                // instantiating variables
                lift = new Spark(LIFT_CHANNEL);
                lift.setInverted(true);
                liftStart = false;

                // LEnc.setPIDSourceType(PIDSourceType.kDisplacement);
                // lMotor = new Spark(LEFT_MOTOR_CHANNEL);
                // rMotor = new Spark(RIGHT_MOTOR_CHANNEL);
        }
}