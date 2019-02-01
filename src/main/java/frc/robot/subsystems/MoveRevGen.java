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
	private static double accelRate;
	private static double maxSpeed;
	private static double settleTime;

	// States
	private static MoveState moveState;
	private static double decelStart;
	private static double direction;
	private static double endDist;
	private static double refDist;
	private static double refSpeed;
	private static double settleTimer;

	public MoveRevGen() {
		moveState = MoveState.Idle;
	}

  public void configure(double accelRate, double maxSpeed, double settleTime) {
		this.accelRate = accelRate;
		this.maxSpeed = maxSpeed;
		this.settleTime = settleTime;
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
