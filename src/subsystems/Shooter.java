package subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
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
	
	//Scale RPM  to native units using 4069 tics per rev / 600 ms per minute
	static final double RPMScale = -4096/600;
	
	public Shooter() {
		flywheelLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
		flywheelLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		flywheelLeft.configNominalOutputVoltage(+0.0f, -0.0f);
		flywheelLeft.configPeakOutputVoltage(0.0f, -12.0f);
		flywheelLeft.reverseSensor(false);
		flywheelLeft.setF(0.025);
		flywheelLeft.setP(0.11);
		flywheelLeft.setI(0);
		flywheelLeft.setD(0);
		
		flywheelRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		flywheelRight.set(Constants.LEFT_SHOOTER);
		flywheelRight.reverseOutput(true);
		
			
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
	public void shooterRetract() {
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
	
	public void setFlywheel(int RPM){
		flywheelLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
		flywheelLeft.set(RPM * RPMScale);
	}
	public void flywheelOut(){
		flywheelLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		flywheelLeft.set(-1);
	}
	public void flywheelIn(){
		flywheelLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		flywheelLeft.set(1);
	}	
	public void flywheelStop(){
		flywheelLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		flywheelLeft.set(0);
	}

}