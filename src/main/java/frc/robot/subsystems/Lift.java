/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
  //use to move the grippers up and down on the elevator
/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public byte target;
  public double holeDistance;
  public SpeedController motor;
	
	public void liftUp(double speed){
		motor.set(speed);
	} 
		
	public void liftDown(double speed){
		motor.set(-speed);
	}
	
	public void liftStop(){
		motor.stopMotor();
  }
  public double Distance( double speed){
    holeDistance =  speed *RobotMap.PERIODIC_UPDATE_PERIOD;
    return holeDistance;
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
