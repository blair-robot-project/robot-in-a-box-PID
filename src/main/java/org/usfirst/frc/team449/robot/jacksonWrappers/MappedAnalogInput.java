package org.usfirst.frc.team449.robot.jacksonWrappers;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import edu.wpi.first.wpilibj.AnalogInput;

import org.usfirst.frc.team449.robot.other.Clock;

/**
 * A Jackson-friendly wrapper on WPILib's {@link AnalogInput}.
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class)
public class MappedAnalogInput extends AnalogInput {

	/**
	 * The time at which the analog value was last calculated
	 */
	private long timeValueCached;

	/**
	 * The value of analog input, as a percent.
	 */
	protected double percentValue;

	/**
	 * Default constructor.
	 *
	 * @param port           The analog input port this object reads analog voltage from.
	 * @param oversampleBits The sensor will be oversampled by 2^oversampleBits bits. Oversampling is kinda confusing, so just read the wikipedia page on it. Defaults to 0.
	 * @param averageBits    The sensor output will be the average of 2^averageBits readings. Defaults to 0.
	 */
	@JsonCreator
	public MappedAnalogInput(@JsonProperty(required = true) int port,
	                         int oversampleBits,
	                         int averageBits) {
		super(port);
		setOversampleBits(oversampleBits);
		setAverageBits(averageBits);
	}

	/**
	 * Cache the value of the analog input if it hasn't been cached yet this tic.
	 */
	protected void cachePercentValue(){
		if (timeValueCached < Clock.currentTimeMillis()){
			percentValue = Math.min(Math.max((getAverageValue()-55.)/64190.,0), 1);
			timeValueCached = Clock.currentTimeMillis();
		}
	}

	/**
	 * Get the percentage value of the analog input.
	 *
	 * @return The value of the analog input on [0,1], scaled so that 5 volts is 1 and 0 volts is 0.
	 */
	public double getPercentValue() {
		cachePercentValue();
		return percentValue;
	}
}
