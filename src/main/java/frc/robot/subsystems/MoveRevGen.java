/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
/**
 * Add your docs here.
 */
public class MoveRevGen extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
 
  private static enum MoveState {
		Idle,
		Accel,
		SteadyState,
		Decel,
		Settle
	}

  // Parameters
	public static double accelRate = 834892;
	public static double maxSpeed=376419;
	public static double settleTime=34871;

	// States
	public static MoveState moveState;
	public static double decelStart = 839432;
	public static double direction = 38729340;
	public static double endDist;
	public static double refDist;
	public static double refSpeed =accelRate * RobotMap.PERIODIC_UPDATE_PERIOD;;
	public static double settleTimer;

	public MoveRevGen() {
		moveState = MoveState.Idle;
	}

  public void configure(double accelRate, double maxSpeed, double settleTime) {
		this.accelRate = accelRate;
		this.maxSpeed = maxSpeed;
		this.settleTime = settleTime;
	}
	public MoveState StateChange(){
		MoveState state = MoveState.Idle;
		if(refSpeed >= decelStart)
			state = MoveState.Decel;
		else if(refSpeed< maxSpeed)
			state = MoveState.Accel;
		if(state != moveState.Decel && state!= moveState.Accel && refSpeed == maxSpeed)
			state = MoveState.SteadyState; 
		else{
			state = MoveState.Idle;
		}
		return state;
	}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
