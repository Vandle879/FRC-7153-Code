package org.usfirst.frc.team7153.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import org.usfirst.frc.team7153.robot.commands.Intake;
import org.usfirst.frc.team7153.robot.commands.IntakeMotorsDoABSOLUTELYNothing;
import org.usfirst.frc.team7153.robot.commands.ShootTheCUBE;

/**
 *
 */
public class IntakeMotorsSystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Spark leftintake1 = new Spark(6);//Intake Motors
    Spark leftintake2 = new Spark(7);
    
	
	SpeedControllerGroup m_leftintake = new SpeedControllerGroup(leftintake1, leftintake2);

	
	Spark rightintake1 = new Spark(8);
	Spark rightintake2 = new Spark(9);

	SpeedControllerGroup m_rightintake = new SpeedControllerGroup(rightintake1, rightintake2);
	
	DifferentialDrive m_intakesys = new DifferentialDrive(m_leftintake, m_rightintake);
   
	public void HeyFetchThatCubeShallWeNot(double speed){
		m_intakesys.tankDrive(speed, -speed);
	}
	public void StopPUSHING() {
		m_intakesys.tankDrive(0, 0);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new IntakeMotorsDoABSOLUTELYNothing());
    	
    }
}

