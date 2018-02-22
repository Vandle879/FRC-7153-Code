package org.usfirst.frc.team7153.robot.subsystems;

import org.usfirst.frc.team7153.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	Spark rightMotor1 = new Spark(0);
	Spark rightMotor2 = new Spark(1);
	
	SpeedControllerGroup m_right = new SpeedControllerGroup(rightMotor1, rightMotor2);

	
	Spark leftMotor1 = new Spark(2);
	Spark leftMotor2 = new Spark(3);

	SpeedControllerGroup m_left = new SpeedControllerGroup(leftMotor1, leftMotor2);
	
	DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	//////////////////////////
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithJoystick());
    	
    }
    public void arcadeDrive(double throttle, double turn) {
    	double theshold = 0.05;
    	
    	m_drive.arcadeDrive(throttle, turn);
    	
    	
    }
 /*   public void autoArcadeDrive(double throttle, double turn) {
    	double autoWaitTime = SmartDashboard.getNumber("Wait Timer", 0); // Gets how long to wait before moving forwards, drivers must type this in when setting up the match
		double autoDriveTime = 2;
		double timeElapsed = 15 - DriverStation.getInstance().getMatchTime(); // The DriverStation gives an approximate time until the end of the period
				
				if (timeElapsed >= autoWaitTime) {
					if (timeElapsed <= autoWaitTime + autoDriveTime) {
						 // Left and Right speeds, 20% power
						double turnValue;
						turnValue = Robot.gyro.getTurningValue();
						double theshold = 0.03;
						if (turnValue >= theshold) {
							turnValue = theshold - turnValue;
						}
						else if (turnValue <=-theshold) {
							turnValue = theshold - turnValue;
						}
						else {
							turnValue = turnValue;
						}
						Robot.drivetrain.arcadeDrive(0.2, turnValue);
					}
    }*/
    }


