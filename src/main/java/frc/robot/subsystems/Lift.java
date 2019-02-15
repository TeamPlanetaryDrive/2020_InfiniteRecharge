/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.hal.EncoderJNI;
import edu.wpi.first.hal.sim.EncoderSim;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.util.*;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.Extensions.*;
  //use to move the grippers up and down on the elevator
/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  private SpeedController ElevatorMotor;
  private Encoder elevatorEncoder ;
  

  public double encoderGetDistLeft() {
		return RobotMap.LEnc.getDistance();
	}
	public double encoderGetRateLeft() {
		return RobotMap.LEnc.getRate();
	}
  
  public Lift(){
 
  }
  
  public double getTarget(){
    return Robot.PID.getSetpoint();
  }

  public void setTarget(double level){
   Robot.PID.setSetpoint(level);
  }

  public boolean success(){
    return Robot.PID.isAtTarget();
  }

	public void liftUp(double speed){
		ElevatorMotor.set(speed);
	} 
		
	public void liftDown(double speed){
		ElevatorMotor.set(-speed);
  }
  
  public void setSpeed(double effort){
    ElevatorMotor.set(effort);
  }
	
	public void liftStop(){
    Robot.PID.setSetpoint(elevatorEncoder.getDistance());
  }
  public double Distance( double speed){
    return speed *RobotMap.PERIODIC_UPDATE_PERIOD;
  }

  // public void moveStart(double distance){
  //   double accelRate;
	// 	double maxSpeed;
	// 	double Kp, Ki, Kd;
  // }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    
  }
}
