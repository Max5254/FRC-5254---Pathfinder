package org.usfirst.frc.team1.robot;

import org.usfirst.frc.team1.robot.Team5254Libraries.xBox360;

public class DriverControls extends Opportunity {

	//Opens a new xBox360 controller 
	private xBox360 driver = new xBox360(Constants.DRIVER_JOYSTICK_PORT);

	public DriverControls() {
	}

	public void driverControls() {

		// drivetrain motors
		//Split stick arcade drive
		drivetrain.drive(driver.getThrottle(), driver.getTurn());

		// shifting
		//Default to low gear, if Right or Left Bumper is hit shift high 
		if (driver.getLB() || driver.getRB())
			drivetrain.shiftHigh();
		else
			drivetrain.shiftLow();

		// catapult
		// Right Trigger does long shot, Left Trigger does short shot
		if (driver.getRT()) {
			catapult.longShot();
		} else if (driver.getLT()) {
			catapult.shortShot();
		} else {
			catapult.noShot();
		}

		// intake
		//Y button toggles intake to either up or down
		intake.toggleIntake(driver.getButtonY());
	
		//Changes the wheel direction
		if(driver.getButtonA()) //button A = intake in
			intake.intakeIn();		
		if(driver.getButtonB()) //button B = intake off
			intake.intakeOff();		
		if(driver.getButtonX()) //button C = intake out
			intake.intakeOut();

	}
}
