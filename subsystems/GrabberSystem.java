package org.usfirst.frc.team7153.robot.subsystems;

import org.usfirst.frc.team7153.robot.commands.GrabberDoABSOLUTELYNothing;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GrabberSystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	DoubleSolenoid grip1 = new DoubleSolenoid(4,5);//widen the grip
	DoubleSolenoid grip2 = new DoubleSolenoid(6,7);
	public void Widen() {
		grip1.set(DoubleSolenoid.Value.kForward);
		grip2.set(DoubleSolenoid.Value.kForward);
	}
	public void ClosingGrip() {
		grip1.set(DoubleSolenoid.Value.kReverse);
		grip2.set(DoubleSolenoid.Value.kReverse);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new GrabberDoABSOLUTELYNothing());
    }
}

