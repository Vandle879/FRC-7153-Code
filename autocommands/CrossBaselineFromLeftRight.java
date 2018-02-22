package org.usfirst.frc.team7153.robot.autocommands;

import org.usfirst.frc.team7153.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 *
 */
public class CrossBaselineFromLeftRight extends CommandGroup {

    public CrossBaselineFromLeftRight() {

       	requires(Robot.drivetrain);
       /*	requires(Robot.gyro);
       	
       
       */
        addSequential(new AutoArcadeStraightDrive(549,0.6, 0.0089,8));
    }
}
