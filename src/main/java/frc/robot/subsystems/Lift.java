/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;
import frc.robot.commands.lift.ManualLiftMove;


  //use to move the grippers up and down on the elevator
/**
 * Add your docs here.
 */
public class Lift extends PIDSubsystem {
  //public double holeDistance;
  //private SpeedController ElevatorMotor;
  //private SpeedController ElevatorMotor2;

  //PIDController ...
	public SpeedController motor;
	public PIDSource src;
	public double points;
	public double tolerance;
  public double setPoint;
  //public double multiplier;
  
  public Lift(){
    super("Lift", 0.025, 0, 0);

    this.setOutputRange(-0.20, 0.50);
    this.setAbsoluteTolerance(0.05);
    this.getPIDController().setContinuous(false);
    RobotMap.liftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);

  }

  public void init(SpeedController sc, boolean inv, PIDSource en){
    motor = sc;
    motor.setInverted(inv);
    src = en;
	}

  public void initDefaultCommand() {
    setDefaultCommand(new ManualLiftMove());
  }
  
  //inherited methods
  protected double returnPIDInput() {
    return 0.11; // returns the sensor value that is providing the feedback for the system
  }

  protected void usePIDOutput(double output) {
    motor.set(output); // this is where the computed output value fromthe PIDController is applied to the motor
  }

  // public void liftUp(double speed){
	// 	RobotMap.lift.set(speed);
	// } 
		
	// public void liftDown(double speed){
	// 	RobotMap.lift.set(-speed);
  // }
  
public void liftMove(double speed){
  RobotMap.lift.set(speed);
}

  // public void moveStart(double distance){
  //   double accelRate;
	// 	double maxSpeed;
	// 	double Kp, Ki, Kd;
  // }
  
  /** extra methods

  public double getTarget(){
    return Robot.PID.getSetpoint();
  }

  public void setTarget(double level){
   Robot.PID.setSetpoint(level);
  }

  public boolean success(){
    return Robot.PID.isAtTarget();
  }
  
  public void setSpeed(double effort){
    RobotMap.lift.set(effort);
  }
	
	public void liftStop(){
    Robot.PID.setSetpoint(elevatorEncoder.getDistance());
  }

  public double encoderGetDistLeft() {
		return RobotMap.LEnc.getDistance();
  }
  
	public double encoderGetRateLeft() {
		return RobotMap.LEnc.getRate();
  } 
  
  public double Distance(double speed){
    return speed * RobotMap.PERIODIC_UPDATE_PERIOD;
  }
   * 
   */

}
