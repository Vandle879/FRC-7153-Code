/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7153.robot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team7153.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	
	
	Joystick Gamepad = new Joystick(3);
	Joystick Extreme3DPro = new Joystick(0);

	
	
	public OI(){
		JoystickButton HSButton= new JoystickButton(Gamepad,4);
		JoystickButton LSButton= new JoystickButton(Gamepad,1);
		HSButton.toggleWhenPressed(new DriveWithHighSpeed());
		LSButton.toggleWhenPressed(new DriveWithLowSpeed());
		JoystickButton resetencoder = new JoystickButton(Gamepad,8);
		resetencoder.toggleWhenPressed(new encoder_test());
		//JoystickButton StetchAndRetract = new JoystickButton(Gamepad, 3);
		//JoystickButton GrabberSolenoids = new JoystickButton(Gamepad,2);
		
		JoystickButton GrabberOpen = new JoystickButton(Extreme3DPro,7);
		JoystickButton GrabberClose= new JoystickButton(Extreme3DPro,8);
		JoystickButton Intake = new JoystickButton(Extreme3DPro,1);
		JoystickButton ShootTheCUBE = new JoystickButton(Extreme3DPro,2);
		
		
		/*
		 * Option 2:
		 * JoystickButton Stretch = new JoystickButton(Extreme3DPro, 5);
		 * JoystickButton Retract = new JoystickButton(Extreme3DPro, 3);
		 * JoystickButton GrabberOpen = new JoystickButton(Extreme3DPro,7);
		 * JoystickButton GrabberClose= new JoystickButton(Extreme3DPro,8);
		 */
		//start a new command when you press the button

		 GrabberOpen.toggleWhenPressed(new GrabberOpen());
		 GrabberClose.toggleWhenPressed(new GrabberClose());
		 Intake.toggleWhenPressed(new Intake());
		 ShootTheCUBE.toggleWhenPressed(new ShootTheCUBE());
	}
		
	

		

	/**Joystick leftDriverstick = new Joystick(0);
	Joystick rightDriverstick = new Joystick(1);
	*/
	public double Forward() {
		return Gamepad.getRawAxis(3);
	}
	
	public double Backward() {
		return Gamepad.getRawAxis(2);
	}
	
	public boolean LowSpeed() {
		return Gamepad.getRawButton(1);
	}
	
	public boolean HighSpeed() {
		return Gamepad.getRawButton(4);
	}
	
	public double POVvalue() {
		return Extreme3DPro.getPOV();
	}

	
	public double ArmLevel() {
		return Extreme3DPro.getY();
	}
	/**public double LeftStickPower() {
		return leftDriverstick.getY();
	}
	
	public double RightStickPower() {
		return rightDriverstick.getY();
	}
	
	*/
	

	public double DriveLeftAndRight() {
		return Gamepad.getRawAxis(0);
	}
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
