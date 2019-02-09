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
import frc.robot.RobotMap;
import frc.robot.Extensions.*;
  //use to move the grippers up and down on the elevator
/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  // public double holeDistance;
  private SpeedController ElevatorMotor;
  private Encoder ElevatorEncoder;
<<<<<<< HEAD
=======
  //Jaguar use = new Jaguar(0);

>>>>>>> c1b1afd51cebd83db5dcfae4add242010d2bbe63
  PIDFix pid = new PIDFix(0.025,0,0){
  
    @Override
    public void usePIDOutput(double output) {
      ElevatorMotor.set(output);
    }
  
    @Override
    public double returnPIDInput() {
      return ElevatorEncoder.getDistance();
    }
  };
  
  public Lift(){
    pid.Activate();
  }

  public double getTarget(){
    return pid.getSetPoint();
  }

  public void setTarget(double level){
    pid.setSetpoint(level);
  }

  public boolean success(){
    return pid.isAtTarget();
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
    pid.setSetpoint(ElevatorEncoder.getDistance());
  }
  public double Distance( double speed){
    return speed *RobotMap.PERIODIC_UPDATE_PERIOD;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
