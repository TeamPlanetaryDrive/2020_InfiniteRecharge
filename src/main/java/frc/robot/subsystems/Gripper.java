/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;
import frc.robot.commands.grip.*;

// use double solenoids
//use compressor
/**
 * Add your docs here.
 */

 //Use this for opening and closing the grippers onto the plate and the ball
public class Gripper extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DoubleSolenoid testSolenoid = new DoubleSolenoid(RobotMap.GRIPPER_CHANNEL_A, RobotMap.GRIPPER_CHANNEL_B);
  
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new RetractGripPiston());
  }

  public void pullPiston(){
    testSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void pushPiston(){
    testSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void pistonOff(){
    testSolenoid.set(DoubleSolenoid.Value.kOff);
  }

}
