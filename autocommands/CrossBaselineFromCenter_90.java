package org.usfirst.frc.team7153.robot.autocommands;

import org.usfirst.frc.team7153.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossBaselineFromCenter_90 extends CommandGroup {

    public CrossBaselineFromCenter_90() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	requires(Robot.drivetrain);
    	//addSequential(new AutoArcadeStraightDrive(90,5));
    	addSequential(new TurnWithGyro(90,0.5,0.049));
    	//addSequential(new AutoArcadeStraightDrive(90,5));
    	//addSequential(new TurnWithGyro(-90,));
    	//addSequential(new AutoArcadeStraightDrive(90,5));
    	
    	
    }
}
