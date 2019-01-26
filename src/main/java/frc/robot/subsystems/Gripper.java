/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.commands.PneumaticTest;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
//use this for opening and closing the gripperws onto the plate and the ball
// use double solenoids
//use compressor
/**
 * Add your docs here.
 */
public class Gripper extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DoubleSolenoid testSolenoid = new DoubleSolenoid(0, 1);
  
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new PneumaticTest());
    
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
