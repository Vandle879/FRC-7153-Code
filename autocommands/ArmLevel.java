package org.usfirst.frc.team7153.robot.autocommands;

import org.usfirst.frc.team7153.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmLevel extends Command {
	
	double init_speed;
	double leverSpeed;
	double kp;
	double height_error;
	double currentHeight;
	double desiredHeight;
    public ArmLevel(double distance, double speed, double prop, double blah) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.armlever);
    	this.desiredHeight = distance;
    	this.init_speed = speed;
    	this.kp = prop;
    	this.desiredHeight = distance;
    	setTimeout(blah);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentHeight = Robot.encoder.getHeight();
    	height_error = desiredHeight - currentHeight;
    	if (kp*height_error>init_speed) {
    		leverSpeed = init_speed;
    	}
    	else {
    		leverSpeed = kp*height_error;
    	}
    	Robot.armlever.Elevator(leverSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
