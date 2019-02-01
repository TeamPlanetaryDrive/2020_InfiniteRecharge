/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

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
	private double accelRate;
	private double maxSpeed;
	private double settleTime;

	// States
	private MoveState moveState;
	private double decelStart;
	private double direction;
	private double endDist;
	private double refDist;
	private double refSpeed;
	private double settleTimer;

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
