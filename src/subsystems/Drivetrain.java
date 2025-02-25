package subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import org.usfirst.frc.team5254.robot.Constants;


public class Drivetrain{
	
	private Solenoid shiftingPiston = new Solenoid(Constants.SHIFTING_PISTON); 
	private RobotDrive myRobot = new RobotDrive(2, 3, 0, 1); //Front Left, Rear Left, Front Right, Rear Right
	
	public Drivetrain() {
	}
	
	//Split stick arcade drive
	public void drive(double Throttle, double Turn) {
		myRobot.arcadeDrive(Throttle,Turn);
	}
	
	//Button to shift high
	public void shiftHigh() {
		shiftingPiston.set(true);
	}	
	public void shiftLow() {
		shiftingPiston.set(false);
	}
}