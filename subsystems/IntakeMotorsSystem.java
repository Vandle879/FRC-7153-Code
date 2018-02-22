package org.usfirst.frc.team7153.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import org.usfirst.frc.team7153.robot.commands.IntakeMotorsDoABSOLUTELYNothing;

/**
 *
 */
public class IntakeMotorsSystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Spark leftintake = new Spark(6);//Intake Motors
    Spark rightintake = new Spark(7);
    
	


	
	
	
	
   
	public void HeyFetchThatCubeShallWeNot(double speed){
		leftintake.set(speed);
		rightintake.set(speed);
	}
	public void StopPUSHING() {
		leftintake.set(0);
		rightintake.set(0);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new IntakeMotorsDoABSOLUTELYNothing());
    	
    }
}

