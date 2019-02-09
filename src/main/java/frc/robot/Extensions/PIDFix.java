/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Extensions;

/**
 * Add your docs here.
 */
public abstract class PIDFix {
    double 
        Kp,Ki,Kd; // To be set for the params for the PID class

    double setPoint = 0; // The point to be reached by the lift, accessed in setSetPoint

    double Tolerance = 0; // The tolerant levels for the motor to begin to shutdown before reaching the point in setPoint

    double ErrorCycle = 0; //How many times has the loop gone through with a tolerable error

    double Error = 0; //What is the error value

    boolean active = false; // Is the class active

    public static double timer = 5; // call loop every 5 milliseconds

    public PIDFix(double p, double i, double d){
        Kp = p;
        Ki = i;
        Kd = d;
    }

    public final void Run(){
        if(!active)
            return;
        usePIDOutput(calculate(returnPIDInput()));
    }

    public abstract double returnPIDInput();

    public abstract void usePIDOutput(double output);
          
    public void disable() {
        active= false;
        }
        
    public void Activate() {
        active = true;
        }
    public boolean isAtTarget() {
        return Math.abs(Error) <= Tolerance;
     }
        
    public void setSetpoint(double setpoint) {
          this.setPoint = setpoint;
    } 
    public double getSetPoint(){
    return setPoint;
   }

    public void setTolerance(double tolerance) {
          this.Tolerance = tolerance;
     }
        
    private final double calculate(double measured) {
        var error = setPoint - measured;

        if (error > 180) {
            error -= 360;
          } else if (error < -180) {
            error += 360;
          }
      
       
        if (Math.abs(error) <= Tolerance) {
          ErrorCycle = 0;
          return 0;
        }
        // Otherwise, increment it since we aren't yet at a tolerable error.
        ErrorCycle++;
    
        var p = Kp * error;
        var i = Ki * error * ErrorCycle;
        var d = Kd * (Error - error / timer);
    
        Error = error;
    
        return -(p + i - d);
      }


    
}
