package subsystems;

import org.usfirst.frc.team5254.robot.Constants;
import org.usfirst.frc.team5254.robot.Team5254Libraries.PneumaticToggle;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Tomahawk{
	
	DoubleSolenoid doubleSolenoid;
	private PneumaticToggle tomahawkToggle;
	
	static final Value down = DoubleSolenoid.Value.kForward;
	
	public Tomahawk(){
		doubleSolenoid = new DoubleSolenoid(Constants.TOMAHAWK_PISTON_EXTEND, Constants.TOMAHAWK_PISTON_RETRACT);
		tomahawkToggle = new PneumaticToggle(doubleSolenoid);
	}
	
	public void toggleTomahawk(boolean input1) {
		tomahawkToggle.DoubleToggle(input1);
	}
	
	public boolean tomahawkDown(){
		return (down == doubleSolenoid.get());
	}
}