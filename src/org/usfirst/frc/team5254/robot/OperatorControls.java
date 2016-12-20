package org.usfirst.frc.team5254.robot;

import org.usfirst.frc.team5254.robot.Team5254Libraries.xBox360;

public class OperatorControls extends Pathfinder {

	// Opens a new xBox360 controller
	private xBox360 operator = new xBox360(Constants.OPERATOR_JOYSTICK_PORT);

	public OperatorControls() {
	}

	public void operatorControls() {
		
		// intake
		// Y button toggles intake to either up or down
		intake.toggleIntake(operator.getStart());

		// Changes the wheel direction
		if (operator.getButtonA()) { // button A = intake in
			intake.intakeIn();
			shooter.flywheelIn();
		}
		if (operator.getButtonB()) { // button B = intake off
			intake.intakeOff();
			shooter.flywheelStop();
		}
		if (operator.getButtonX()) { // button C = intake out
			intake.intakeOut();
			shooter.flywheelOut();
		}
		if (operator.getLB())       { // button LB = intake out
			intake.intakeOut();
			shooter.flywheelOut();
		}
		if (operator.getRB())        { // button RB = intake in
			intake.intakeIn();
			shooter.flywheelIn();
		}
		//if (operator.getBack())    // button Back = holder open
			//shooter.holderClose();
		
		//if (!operator.getBack())   // button not Back = holder close
			//shooter.holderOpen();
	}
}