package org.usfirst.frc.team449.robot.oi.buttons;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.jetbrains.annotations.NotNull;
import org.usfirst.frc.team449.robot.jacksonWrappers.MappedDigitalInput;

/**
 * A button triggered off of a digital input switch on the RoboRIO.
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class)
public class ButtonDigitalInput extends FactoryButton{

	/**
	 * The input to read from.
	 */
	@NotNull
	private final MappedDigitalInput input;

	/**
	 * Default constructor.
	 *
	 * @param input The input to read from.
	 */
	@JsonCreator
	public ButtonDigitalInput(@NotNull @JsonProperty(required = true) MappedDigitalInput input) {
		this.input = input;
	}

	/**
	 * Get whether this button is pressed
	 *
	 * @return true if the all the ports in the MappedDigitalInput are true, false otherwise.
	 */
	@Override
	public boolean get() {
		for (Boolean b: input.getStatus()){
			if (!b){
				return false;
			}
		}
		return true;
	}
}