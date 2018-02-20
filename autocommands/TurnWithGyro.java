package org.usfirst.frc.team7153.robot.autocommands;

import org.usfirst.frc.team7153.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
/**
 *
 */
public class TurnWithGyro extends Command {
	double turning_speed;
	double desiredAngle;
	double error;
	double kp;
    public TurnWithGyro(double Angle, double prop) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.desiredAngle = Angle;
    	this.kp = prop;
    	requires(Robot.drivetrain);
    	setTimeout(3);
    	
  
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gyro.resetGyro();

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	error = desiredAngle - Robot.gyro.getGyroAngle();
    	if (Robot.gyro.getGyroAngle() > desiredAngle)
        {
    		Robot.drivetrain.arcadeDrive(0, kp*error);
        }
        else
        {
        	Robot.drivetrain.arcadeDrive(0, -kp*error);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return isTimedOut(); //((Math.abs(error) <= tolerance) || isTimedOut());
    }


    protected void end() {
    	Robot.drivetrain.arcadeDrive(0, 0);
    	Robot.gyro.resetGyro();
    }


    protected void interrupted() {
    }
}