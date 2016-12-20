package org.usfirst.frc.team5254.robot.Team5254Libraries;

import edu.wpi.first.wpilibj.DigitalInput;

public class DigitalButton {
	private int channel;
	DigitalInput buttonInput;
	    
	public DigitalButton(int channel) {
		this.channel = channel;
		buttonInput = new DigitalInput(channel);
	    }

	public int getChannel() {
		return this.channel;
	    }
	    
	public boolean get() {
		return buttonInput.get();
	    }
	    
	}
