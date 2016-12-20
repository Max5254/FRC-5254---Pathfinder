package org.usfirst.frc.team5254.robot.Team5254Libraries;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * 
 * @author Max Westwater
 * @version 0.2
 */

public class PneumaticToggle {
	DoubleSolenoid.Value lastValue = DoubleSolenoid.Value.kReverse;
	boolean lastInput;
	DoubleSolenoid doubleSolenoid;
	Solenoid solenoid;

	// constructor for using double solenoid
	public PneumaticToggle(DoubleSolenoid doubleSolenoid) {
		this.doubleSolenoid = doubleSolenoid;
	}

	// constructor for using single solenoid
	public PneumaticToggle(Solenoid solenoid) {
		this.solenoid = solenoid;
	}

	/**
	 * 
	 * @param input
	 *            boolean input to toggle solenoid
	 * @param doubleSolenoid
	 *            the object of the double solenoid you'd like to toggle
	 */
	public void DoubleToggle(boolean input) {
		if (lastInput == input)
			return;
		lastInput = input;
		if (!input)
			return;
		DoubleSolenoid.Value value;
		if (lastValue == DoubleSolenoid.Value.kForward) {
			value = DoubleSolenoid.Value.kReverse;
		} else {
			value = DoubleSolenoid.Value.kForward;
		}
		doubleSolenoid.set(value);
		lastValue = value;
	}

	/**
	 * 
	 * @param input
	 *            boolean input to toggle solenoid
	 * @param solenoid
	 *            the object of the single solenoid you'd like to toggle
	 */
	public void SingleToggle(boolean input) {

		if (!lastInput && input && solenoid.get()) {
			solenoid.set(false);
		}
		if (!lastInput && input && !solenoid.get()) {
			solenoid.set(true);
		}

		lastInput = input;
	}

	/**
	 * 
	 * @param input1
	 *            Button to set double solenoid to Forward
	 * @param input2
	 *            Button to set double solenoid to Reverse
	 */
	public void DoubleToggle(boolean input1, boolean input2) {

		if (input1) {
			doubleSolenoid.set(DoubleSolenoid.Value.kForward);
		}
		if (input2) {
			doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
		}

	}

	/**
	 * 
	 * @param input1
	 *            Button to set single solenoid to true
	 * @param input2
	 *            Button to set single solenoid to false
	 */
	public void SingleToggle(boolean input1, boolean input2) {

		if (input1) {
			solenoid.set(true);
		}
		if (input2) {
			solenoid.set(false);
		}

	}

}