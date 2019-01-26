/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class PIDMotor extends PIDSubsystem{
	
	//PIDController ...
	public SpeedController motor;
	public PIDSource src;
	public double multiplier;

	/**
	 * Init needs to be called
	 */
	public PIDMotor(double Kp, double Ki, double Kd){
		super("PIDMotor", Kp, Ki, Kd);

		this.setOutputRange(-0.95, 0.95);
		this.setAbsoluteTolerance(0.05);
		this.getPIDController().setContinuous(true);//XXX
		multiplier = 1;
	}

	public void init(SpeedController sc, boolean inv, PIDSource en){
		motor = sc;
		motor.setInverted(inv);

		src = en;
	}

	protected double returnPIDInput() {
		return src.pidGet();
	}

	protected void usePIDOutput(double output) {
		motor.set(output * multiplier);
	}

	//Function is only here because PIDSubsystem requires this method
	@Deprecated
	protected void initDefaultCommand() {
		//this.setSetpoint(10);	
	}
}