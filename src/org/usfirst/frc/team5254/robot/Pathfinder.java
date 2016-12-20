package org.usfirst.frc.team5254.robot;

import subsystems.Shooter;
import subsystems.Drivetrain;
import subsystems.Intake;
import subsystems.Tomahawk;

public class Pathfinder {

	public Pathfinder() {

	}
	

	// Subsystems
	protected static Drivetrain drivetrain = new Drivetrain(); // Done
	protected static Intake intake = new Intake(); // Done
	protected static Shooter shooter = new Shooter(); // Done
	protected static Tomahawk tomahawk = new Tomahawk();
	
	// Human Controls
	protected static DriverControls driver = new DriverControls(); // Done
	protected static OperatorControls operator = new OperatorControls(); // Done
}