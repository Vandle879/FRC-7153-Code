package org.usfirst.frc.team7153.robot.subsystems;

import org.usfirst.frc.team7153.robot.commands.Stretch;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmRetractAndStretch extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	DoubleSolenoid sol1 = new DoubleSolenoid(0,1); //retract and stretch the arm
	//DoubleSolenoid sol2 = new DoubleSolenoid(2,3);
	public void SolenoidF() {	
		sol1.set(DoubleSolenoid.Value.kForward);
	//	sol2.set(DoubleSolenoid.Value.kForward);
	}
	public void SolenoidB() {
		sol1.set(DoubleSolenoid.Value.kReverse);
	//	sol2.set(DoubleSolenoid.Value.kReverse);
	}
	public void SolenoidDoNothing() {
		sol1.set(DoubleSolenoid.Value.kOff);
	//	sol2.set(DoubleSolenoid.Value.kOff);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Stretch());
    }
}

