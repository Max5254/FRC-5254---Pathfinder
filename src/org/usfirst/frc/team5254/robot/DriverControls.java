package org.usfirst.frc.team5254.robot;

import java.util.concurrent.TimeUnit;

import org.usfirst.frc.team5254.robot.Team5254Libraries.xBox360;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriverControls extends Pathfinder {

	// Opens a new xBox360 controller
	private xBox360 driver = new xBox360(Constants.DRIVER_JOYSTICK_PORT);
	
	//Variables for publishing shot numbers to dashboard 
	boolean lastButton = false;
	int numHigh = 0;
	int numLow = 0;
	boolean lastValue;

	public DriverControls() {
	}

	public void driverControls() {

		// drivetrain motors
		// Split stick arcade drive
		if (driver.getRightStickClick() || driver.getBack()) {
			drivetrain.drive(driver.getThrottle(), 0.5 * driver.getTurn()); // slow turn
		} else {
			drivetrain.drive(driver.getThrottle(), driver.getTurn());
		}

		// shifting
		// Default to low gear, if Right or Left Bumper is hit shift high
		if (driver.getLB() || driver.getRB())
			drivetrain.shiftHigh();
		else
			drivetrain.shiftLow();

		
		// Right Trigger and Left Trigger shoot
		if (driver.getRT() || driver.getLT()) {
			shooter.holderOpen();
			try {
				TimeUnit.MILLISECONDS.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			shooter.shooterExtend();
			
		} else 
			shooter.noShot();
		
		
		//Code to report how many shots we take in a match 
		if (driver.getRT() && !lastButton){ //Each time button is hit increment numLong
			numHigh++;
		}
		if (driver.getLT() && !lastButton){ //Each time button is hit increment numShort
			numLow++;
		}
		
		lastButton = driver.getRT() || driver.getLT(); 
		
		//Publish values to dashboard
		SmartDashboard.putNumber("Goals", numLow + numHigh);
		
		//tomahawks
		// A toggles tomahawks up and down
		tomahawk.toggleTomahawk(driver.getButtonA());
		

		if (shooter.leftBallIn() && shooter.rightBallIn()){
			shooter.holderOpen();
		}	else {
			shooter.holderClose();
		}
	}
}
