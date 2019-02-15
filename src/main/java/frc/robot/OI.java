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
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);
  // initializing the joystick mappings
  public static int 
		LEFT_JOYSTICK_PORT = 0,
    RIGHT_JOYSTICK_PORT = 1;
  
  public static Joystick leftJoystick = new Joystick(LEFT_JOYSTICK_PORT);
	public static JoystickButton button2_left = new JoystickButton(leftJoystick, 2);
	public static JoystickButton button3_left = new JoystickButton(leftJoystick, 3);
	public static JoystickButton button4_left = new JoystickButton(leftJoystick, 4);
	public static JoystickButton button5_left = new JoystickButton(leftJoystick, 5);
		
	public static Joystick rightJoystick = new Joystick(RIGHT_JOYSTICK_PORT);
	public static JoystickButton button2_right = new JoystickButton(rightJoystick, 2);
	public static JoystickButton button3_right = new JoystickButton(rightJoystick, 3);
	public static JoystickButton button4_right = new JoystickButton(rightJoystick, 4);
  public static JoystickButton button5_right = new JoystickButton(rightJoystick, 5);

  //This is where you put associate commands with all the buttons
  public OI(){
    //Gripper controls
    button2_left.whenPressed(new ExtendGripPiston());
    if(leftJoystick.getTrigger()){
      new RetractGripPiston();
    }

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

  // left and right joysticks being mapped to ports and having their keys mapped (last years code)
   public static void init(){

   }

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  }

