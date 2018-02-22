

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7153.robot;

import edu.wpi.first.wpilibj.CameraServer;

import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team7153.robot.subsystems.*;

import org.usfirst.frc.team7153.robot.autocommands.*;
import org.usfirst.frc.team7153.robot.subsystems.TheEncoder;
import org.usfirst.frc.team7153.robot.subsystems.TheGyro;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final ExampleSubsystem kExampleSubsystem
			= new ExampleSubsystem();
	
	public static DriveTrain drivetrain = new DriveTrain();
	public static TheEncoder encoder = new TheEncoder();
	public static TheGyro gyro = new TheGyro();
	public static ArmRetractAndStretch armsol = new ArmRetractAndStretch();
	public static ArmLeverSystem armlever = new ArmLeverSystem();
	public static IntakeMotorsSystem intakemotors = new IntakeMotorsSystem();
	public static GrabberSystem grabbersys = new GrabberSystem();
	public static OI m_oi;
	
	//Ultrasonic ultra = new Ultrasonic(1,1); 
	
	Command m_autonomousCommand;
	
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		m_chooser.addDefault("Default Auto", new DoAbsolutelyNothing_IDKWhyImEvenHereBro());
		m_chooser.addObject("Cross Baseline Straight Starting From Either Left or Right", new CrossBaselineFromLeftRight());
		m_chooser.addObject("Cross Baseline straight Starting from the center", new CrossBaselineFromCenter_90());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		CameraServer.getInstance().startAutomaticCapture();
		//ultra.setAutomaticMode(true);
		encoder.setNumberOfEncoders(2);
		encoder.invert();
		gyro.resetGyro();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();
		encoder.reset();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
		//autoWaitTime = SmartDashboard.getNumber("Wait Timer", 0); // Gets how long to wait before moving forwards, drivers must type this in when setting up the match
		//autoDriveTime = 2;  // TODO: See if this drives where you need it to be
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
		
		}
		
	
			
		
	

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
	

		}
	}
	
	

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putBoolean("HSButton", Robot.m_oi.HighSpeed());
		SmartDashboard.putBoolean("LSButton", Robot.m_oi.LowSpeed());
		SmartDashboard.putNumber("ThrottleInput:",Robot.m_oi.Forward());
		SmartDashboard.putNumber("Speed of the arm motor:", Robot.m_oi.ArmLevel());
		
		SmartDashboard.putNumber("Height:", Robot.encoder.getHeight());
		SmartDashboard.putNumber("POV:", Robot.m_oi.POVvalue());
		//SmartDashboard.putNumber("LeftDist:", Robot.encoder.getLeftDist());
		//SmartDashboard.putNumber("RightDist", Robot.encoder.getRightDist());
		SmartDashboard.putNumber("AverageDist:", Robot.encoder.getDistance());
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
