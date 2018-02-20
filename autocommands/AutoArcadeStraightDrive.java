package org.usfirst.frc.team7153.robot.autocommands;

import org.usfirst.frc.team7153.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoArcadeStraightDrive extends Command {
	
	//double timeElapsed = 15 - DriverStation.getInstance().getMatchTime(); // The DriverStation gives an approximate time until the end of the period
	double turnValue;
	double theshold = 0.03;
	double throttleDriveSpeed;
	double encoder_kp;
	double desiredDist;
	double currentDist;
	double encoder_error;
	double turnOffset;
    public AutoArcadeStraightDrive(double distance,double kp, double blah) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.encoder_kp = kp;
    	this.desiredDist = distance;
    	requires(Robot.drivetrain);
    	setTimeout(blah);
    	
    	    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gyro.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*double autoWaitTime = SmartDashboard.getNumber("Wait Timer", 0); // Gets how long to wait before moving forwards, drivers must type this in when setting up the match
		double autoDriveTime = 2;
		double timeElapsed = 15 - DriverStation.getInstance().getMatchTime(); // The DriverStation gives an approximate time until the end of the period
		if (timeElapsed >= autoWaitTime) {
			if (timeElapsed <= autoWaitTime + autoDriveTime) {
				 // Left and Right speeds, 20% power
				
				*/
    			turnValue = Robot.gyro.getGyroAngle();
    			
    			currentDist = Robot.encoder.getDistance();
    			encoder_error = desiredDist - currentDist;
    			double driveSpeed;
    			
    			if (currentDist>desiredDist) {
    				driveSpeed = -encoder_kp*encoder_error;
    			}
    			else {
    				driveSpeed = encoder_kp*encoder_error;
    			}
    			
				if (turnValue >= theshold) {
					turnOffset = theshold - turnValue;
				}
				else if (turnValue <=-theshold) {
					turnOffset = theshold - turnValue;
				}
				else {
					turnOffset = 0;
				}
				Robot.drivetrain.arcadeDrive(driveSpeed, turnOffset);
			}
    	
//    }	
 //   }
    	

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.arcadeDrive(0, 0);
    	Robot.gyro.resetGyro();
    	Robot.encoder.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
