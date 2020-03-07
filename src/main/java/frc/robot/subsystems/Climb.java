/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.Robot;

public class Climb extends SubsystemBase {
  /**
   * Creates a new Climb.
   */
  public Climb() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSpeed(double speed){
    RobotMap.climbL.set(speed);
    RobotMap.climbR.set(speed);
  }

  public double getHeight(){
    return RobotMap.climbEncoder.getDistance();
  }
}
