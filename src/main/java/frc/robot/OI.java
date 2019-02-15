/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
//test
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import frc.robot.commands.*;
import frc.robot.commands.lift.*;
import frc.robot.commands.grip.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public static int 
		LEFT_JOYSTICK_PORT = 0,
    RIGHT_JOYSTICK_PORT = 1;
  
    final Joystick leftJoystick = new Joystick(LEFT_JOYSTICK_PORT);
    final Joystick rightJoystick = new Joystick(RIGHT_JOYSTICK_PORT);
   
   public OI(){

    
    final JoystickButton button2_left = new JoystickButton(leftJoystick, 2);
    final JoystickButton button3_left = new JoystickButton(leftJoystick, 3);
    final JoystickButton button4_left = new JoystickButton(leftJoystick, 4);
    final JoystickButton button5_left = new JoystickButton(leftJoystick, 5);
		
   
    final JoystickButton button2_right = new JoystickButton(rightJoystick, 2);
    final JoystickButton button3_right = new JoystickButton(rightJoystick, 3);
    final JoystickButton button4_right = new JoystickButton(rightJoystick, 4);
    final JoystickButton button5_right = new JoystickButton(rightJoystick, 5);

  //This is where you put associate commands with all the buttons
    //Gripper controls
    button2_left.whenPressed(new ExtendGripPiston());
    if(leftJoystick.getTrigger())
      new RetractGripPiston();

    //Lift controls
    button4_left.whenPressed(new LiftLevelOne());
    button3_left.whenPressed(new LiftLevelTwo());
    button5_left.whenPressed(new LiftLevelThree());
    button4_right.whenPressed(new LiftLevelFour());
    button3_right.whenPressed(new LiftLevelFive());
    button5_right.whenPressed(new LiftLevelSix());

    //testing PID
    button2_right.whenPressed(new TestPID());
    
    }

    public Joystick getRightJoyStick(){
      return rightJoystick;
    }
    public Joystick getLeftJoystick(){
      return leftJoystick;
    }
  }

