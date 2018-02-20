package org.usfirst.frc.team7153.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.usfirst.frc.team7153.robot.commands.ArmElevator;

/**
 *
 */
public class ArmLeverSystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Spark elevator = new Spark (4);//Elevator of the Arm
	Spark elevator2 = new Spark(5);
	
	public void Elevator(double height) {
		elevator.set(-height/1.5);
		elevator2.set(-height/1.5);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ArmElevator());
    	
    }
}

