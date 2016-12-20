package subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;

import org.usfirst.frc.team5254.robot.Constants;
import org.usfirst.frc.team5254.robot.Pathfinder;

public class Shooter extends Pathfinder {

	Solenoid shooter = new Solenoid(Constants.SHOOTER);
	Solenoid holder = new Solenoid(Constants.BALL_HOLDER_PISTON);
	CANTalon flywheelLeft = new CANTalon(Constants.LEFT_SHOOTER);
	CANTalon flywheelRight = new CANTalon(Constants.RIGHT_SHOOTER);
	DigitalInput leftBallSensor = new DigitalInput(Constants.LEFT_BALL_SENSOR);
	DigitalInput rightBallSensor = new DigitalInput(Constants.RIGHT_BALL_SENSOR);
	
	public Shooter() {
		flywheelLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		flywheelLeft.setPID(0.11, 0.0, 0.0);
		flywheelRight.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		flywheelRight.setPID(0.10, 0.0, 0.0);
			
	}
	public boolean leftBallIn() {
		System.out.printf("leftBallSensor %b%n", leftBallSensor.get());
		return leftBallSensor.get();
		}
	
	public boolean rightBallIn() {
		System.out.printf("rightBallSensor %b%n", rightBallSensor.get());
		return rightBallSensor.get();
	}
		

	//Outer works shot: Open holder then fire shooter
	public void highGoal() {
		if (Pathfinder.intake.intakeDown()) {
			holder.set(false);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			shooter.set(true);
		}
	}

	//148 shot: Open holder then fire shooter
	public void lowGoal() {
		if (Pathfinder.intake.intakeUp()) {
			holder.set(false);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			shooter.set(true);
		}
	}

	//Nothing: don't fire
	public void noShot() {
		holder.set(false);
		shooter.set(false);
		}
	public void shooterExtend(){
		shooter.set(true);
	}
	public void holderOpen(){
		holder.set(false);
	}
	
	public void holderClose(){
		holder.set(true);
	}
	public void flywheelOut(){
		flywheelLeft.set(-1);
		flywheelRight.set(-1);
	}
	public void flywheelIn(){
		flywheelLeft.set(1);
		flywheelLeft.set(1);
	}	
	public void flywheelStop(){
		flywheelLeft.set(0);
		flywheelRight.set(0);
	}
	public void d4Shot(){
		Potentiometer pot;
		pot = new AnalogPotentiometer(0, 360, 30);
		AnalogInput ai = new AnalogInput(1);
		pot = new AnalogPotentiometer(ai, 360, 30);
	}
	public void spyBoxShot(){
		Potentiometer pot;
		pot = new AnalogPotentiometer(0, 360, 30);
		AnalogInput ai = new AnalogInput(1);
		pot = new AnalogPotentiometer(ai, 360, 30);
	}
}