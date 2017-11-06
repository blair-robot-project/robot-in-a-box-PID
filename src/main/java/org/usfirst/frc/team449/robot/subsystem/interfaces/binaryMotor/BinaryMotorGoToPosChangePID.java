package org.usfirst.frc.team449.robot.subsystem.interfaces.binaryMotor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.jetbrains.annotations.NotNull;
import org.usfirst.frc.team449.robot.generalInterfaces.loggable.Loggable;
import org.usfirst.frc.team449.robot.jacksonWrappers.FPSTalonPIDExposed;
import org.usfirst.frc.team449.robot.jacksonWrappers.MappedAnalogInput;

/**
 * A binaryMotorGoToPos that sets the Talon PID values to a value read in from an analog input when the motor is turned
 * on.
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class)
public class BinaryMotorGoToPosChangePID extends BinaryMotorGoToPos implements Loggable {

	/**
	 * The talon to move to the given position.
	 */
	@NotNull
	protected final FPSTalonPIDExposed talon;

	/**
	 * The analog inputs to read the PID gains from.
	 */
	@NotNull
	private final MappedAnalogInput pInput, iInput, dInput;

	/**
	 * Default constructor
	 *
	 * @param talon        The talon to move to the given position.
	 * @param positionFeet The position, in feet, for the talon to go to. Defaults to 0.
	 * @param pInput       The analog input to read the P gain from.
	 * @param iInput       The analog input to read the I gain from.
	 * @param dInput       The analog input to read the D gain from.
	 */
	@JsonCreator
	public BinaryMotorGoToPosChangePID(@NotNull @JsonProperty(required = true) FPSTalonPIDExposed talon,
	                                   double positionFeet,
	                                   @NotNull @JsonProperty(required = true) MappedAnalogInput pInput,
	                                   @NotNull @JsonProperty(required = true) MappedAnalogInput iInput,
	                                   @NotNull @JsonProperty(required = true) MappedAnalogInput dInput) {
		super(talon, positionFeet);
		this.talon = talon;
		this.pInput = pInput;
		this.iInput = iInput;
		this.dInput = dInput;
	}

	/**
	 * Turns the motor on, sets the Talon PID values to the input, and sets it to a map-specified position.
	 */
	@Override
	public void turnMotorOn() {
		talon.setPID(pInput.getPercentValueCached(), iInput.getPercentValueCached(), dInput.getPercentValueCached());
		super.turnMotorOn();
	}

	@NotNull
	@Override
	public String[] getHeader() {
		return new String[]{
				"position",
				"kP",
				"kI",
				"kD"
		};
	}

	@NotNull
	@Override
	public Object[] getData() {
		return new Object[]{
				talon.getPositionFeet(),
				pInput.getPercentValueCached(),
				iInput.getPercentValueCached(),
				dInput.getPercentValueCached()
		};
	}
}
