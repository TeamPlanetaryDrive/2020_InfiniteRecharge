/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
// import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.vision.VisionThread;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Vision;
import frc.robot.subsystems.Multi;
import frc.robot.OI;
import frc.robot.commands.auto.breakStartLine;
import frc.robot.commands.auto.auto2;
import frc.robot.commands.auto.auto2Test;

import java.util.ArrayList;

import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  public static DriveTrain Drive;// could be redundent , if we delete drivetrain get rid of this
  public static Lift Elevator; // elevator for gripper
  // public static Vision Cameras; // used for the vision class as needed
  private VisionThread visionThread;
  private final Object imgLock = new Object();

  public static Multi MultiSystem; // contains shooter, intake, rotator
  public static OI m_oi;

  public Command m_autonomousCommand;
  public SendableChooser<Command> m_chooser;

  private ArrayList<MatOfPoint> contourArray;
  

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */

  public void robotInit() {
    RobotMap.init();
    Drive = new DriveTrain();
    Elevator = new Lift();
    MultiSystem = new Multi();
    m_oi = new OI();
    // Cameras.init();
    
    UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setFPS(15);
    camera.setResolution(320, 240);
    
    visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
          synchronized (imgLock) {
            contourArray = pipeline.filterContoursOutput();
          }
    });
    visionThread.start();
    
    m_chooser = new SendableChooser<Command>();
    m_chooser.addOption("breakStartLine", new breakStartLine());
    m_chooser.addOption("auto2Test", new auto2Test(new ArrayList<MatOfPoint>()));
    // m_chooser.addOption("auto2", new auto2());
    SmartDashboard.putData("Auto mode", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // synchronized (imgLock) {
    //   System.out.println(this.centerX);
    // }
  }

  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    SmartDashboard.updateValues();
    m_autonomousCommand = m_chooser.getSelected();
    CommandScheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString code to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons to
   * the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    System.out.println(SmartDashboard.getKeys());

    
    
    //Command autoSelected
    //autoSelected.schedule();
    
    // switch(autoSelected) { 
    //   case "auto2": 
    //     m_autonomousCommand = new auto2(); 
    //     break; 
    //   case "Default Auto": 
    //   default: 
    //     autonomousCommand = new ExampleCommand(); 
    //     break; 
    //   }
    
  }

  /**
   * This function is called periodically during autonomous.
   */
  //comment
  @Override
  public void autonomousPeriodic() {
    if (m_autonomousCommand != null) {
      if(m_autonomousCommand.getName().equals("auto2Test"))
        synchronized(imgLock){
          m_autonomousCommand = new auto2Test(contourArray);
        }
      m_autonomousCommand.schedule();
    }
    CommandScheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    SmartDashboard.putData("Encoder", m_chooser);
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Robot.Drive.drive(-0.7 * RobotMap.leftJoystick.getY(), -0.7 * RobotMap.rightJoystick.getY());
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
