package org.usfirst.frc.team7153.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TheEncoder {

	Encoder encoderLeft;
	Encoder encoderRight;
	Encoder encoderArm;
	int numberOfEncoders = 2;
	boolean isInverted = false;
	
	public TheEncoder() {
		encoderLeft = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
		encoderRight = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
		encoderArm = new Encoder(4, 5, false, Encoder.EncodingType.k4X);
		encoderLeft.setDistancePerPulse(0.027);
		encoderRight.setDistancePerPulse(0.027);
	}

	public void setNumberOfEncoders(int numberOfEncoders) {
		this.numberOfEncoders = numberOfEncoders;
	}

	public void reset() {
		encoderLeft.reset();
		encoderRight.reset();
	}

	public void invert() {
		isInverted = true;
	}
	
	public double getDistance() {
		SmartDashboard.putString("Left Encoder Distance", "" + encoderLeft.getDistance());
		SmartDashboard.putString("Right Encoder Distance", "" + encoderRight.getDistance());

		double distance = ((encoderLeft.getDistance() + encoderRight.getDistance()) / numberOfEncoders);
		if(isInverted)
			distance = -distance;
		SmartDashboard.putString("Encoder Distance", "" + distance);
		return distance;
	}
	public double getHeight() {
		SmartDashboard.putString("Arm Encoder Height", "" + encoderArm.getDistance());
		return encoderArm.getDistance();
	}
	/*public double getLeftDist() {
		return encoderLeft.getDistance();
	}
	public double getRightDist() {
		return encoderRight.getDistance();
	}*/
	public void logValues() {
		System.out.println("encoder left = " + encoderLeft.getDistance());
		System.out.println("encoder right = " + encoderRight.getDistance());
	}
}