package org.usfirst.frc.team449.robot.subsystem.interfaces.binaryMotor;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.usfirst.frc.team449.robot.jacksonWrappers.YamlSubsystem;

/**
 * A binary motor subsystem that uses PID to go to a given position when turned on.
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class)
public class BinaryMotorGoToPos extends YamlSubsystem implements SubsystemBinaryMotor{

	private double positionFeet;

	/**
	 * Do nothing.
	 */
	@Override
	protected void initDefaultCommand() {}

	/**
	 * Turns the motor on, and sets it to a map-specified speed.
	 */
	@Override
	public void turnMotorOn() {

	}

	/**
	 * Turns the motor off.
	 */
	@Override
	public void turnMotorOff() {

	}

	/**
	 * @return true if the motor is on, false otherwise.
	 */
	@Override
	public boolean isMotorOn() {
		return false;
	}
}
