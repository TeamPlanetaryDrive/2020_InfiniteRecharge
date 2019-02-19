/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.lift.*;
import frc.robot.commands.grip.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  // joystick variables
  public static int LEFT_JOYSTICK_PORT = 0, RIGHT_JOYSTICK_PORT = 1;

  public static Joystick leftJoystick = new Joystick(LEFT_JOYSTICK_PORT);
  public static Joystick rightJoystick = new Joystick(RIGHT_JOYSTICK_PORT);

  public static JoystickButton button2_left, button3_left, button4_left, button5_left;

  public static JoystickButton button2_right, button3_right, button4_right, button5_right;

  public OI() {
    // instantiating buttons
    button2_left = new JoystickButton(leftJoystick, 2);
    button3_left = new JoystickButton(leftJoystick, 3);
    button4_left = new JoystickButton(leftJoystick, 4);
    button5_left = new JoystickButton(leftJoystick, 5);

    button2_right = new JoystickButton(rightJoystick, 2);
    button3_right = new JoystickButton(rightJoystick, 3);
    button4_right = new JoystickButton(rightJoystick, 4);
    button5_right = new JoystickButton(rightJoystick, 5);

    // This is where you put associate commands with all the buttons
    button2_left.whenPressed(new MoveGripPiston(RobotMap.GRIPPER_EXTEND));
    button2_right.whenPressed(new MoveGripPiston(RobotMap.GRIPPER_RETRACT));
    
    // button2_left.whenPressed(new ExtendGripPiston());
    // button2_right.whenReleased(new RetractGripPiston());
    

    // Lift controls

    button4_left.whenPressed(new LiftToLevel(0));
    button3_left.whenPressed(new LiftToLevel(1));
    button5_left.whenPressed(new LiftToLevel(2));
    button4_right.whenPressed(new LiftToLevel(3));
    button3_right.whenPressed(new LiftToLevel(4));
    button5_right.whenPressed(new LiftToLevel(5));

    // button4_left.whenPressed(new LiftLevelOne());
    // button3_left.whenPressed(new LiftLevelTwo());
    // button5_left.whenPressed(new LiftLevelThree());
    // button4_right.whenPressed(new LiftLevelFour());
    // button3_right.whenPressed(new LiftLevelFive());
    // button5_right.whenPressed(new LiftLevelSix());

  }

  public Joystick getRightJoyStick() {
    return rightJoystick;
  }

  public Joystick getLeftJoystick() {
    return leftJoystick;
  }
}
