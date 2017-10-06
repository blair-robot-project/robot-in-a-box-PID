package org.usfirst.frc.team449.robot.jacksonWrappers;

import com.ctre.CANTalon;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;
import org.usfirst.frc.team449.robot.generalInterfaces.shiftable.Shiftable;
import org.usfirst.frc.team449.robot.jacksonWrappers.FPSTalon;

import java.util.List;

/**
 * A variant of FPSTalon that adds more position functionality.
 */
public class FPSTalonWithPositon extends FPSTalon {

	/**
	 * Default constructor.
	 *
	 * @param port                       CAN port of this Talon.
	 * @param inverted                   Whether this Talon is inverted.
	 * @param reverseOutput              Whether to reverse the output (identical effect to inverting outside of position
	 *                                   PID)
	 * @param enableBrakeMode            Whether to brake or coast when stopped.
	 * @param fwdLimitSwitchNormallyOpen Whether the forward limit switch is normally open or closed. If this is null, the
	 *                                   forward limit switch is disabled.
	 * @param revLimitSwitchNormallyOpen Whether the reverse limit switch is normally open or closed. If this is null, the
	 *                                   reverse limit switch is disabled.
	 * @param fwdSoftLimit               The forward software limit, in feet. If this is null, the forward software limit is
	 *                                   disabled.
	 * @param revSoftLimit               The reverse software limit, in feet. If this is null, the reverse software limit is
	 *                                   disabled.
	 * @param postEncoderGearing         The coefficient the output changes by after being measured by the encoder, e.g.
	 *                                   this would be 1/70 if there was a 70:1 gearing between the encoder and the final
	 *                                   output. Defaults to 1.
	 * @param feetPerRotation            The number of feet travelled per rotation of the motor this is attached to.
	 *                                   Defaults to 1.
	 * @param currentLimit               The max amps this device can draw. If this is null, no current limit is used.
	 * @param maxClosedLoopVoltage       The voltage to scale closed-loop output based on, e.g. closed-loop output of 1 will
	 *                                   produce this voltage, output of 0.5 will produce half, etc. This feature
	 *                                   compensates for low battery voltage.
	 * @param feedbackDevice             The type of encoder used to measure the output velocity of this motor. Can be null
	 *                                   if there is no encoder attached to this Talon.
	 * @param encoderCPR                 The counts per rotation of the encoder on this Talon. Can be null if feedbackDevice
	 *                                   is, but otherwise must have a value.
	 * @param reverseSensor              Whether or not to reverse the reading from the encoder on this Talon. Ignored if
	 *                                   feedbackDevice is null. Defaults to false.
	 * @param perGearSettings            The settings for each gear this motor has. Can be null to use default values and
	 *                                   gear # of zero. Gear numbers can't be repeated.
	 * @param startingGear               The gear to start in. Can be null to use startingGearNum instead.
	 * @param startingGearNum            The number of the gear to start in. Ignored if startingGear isn't null. Defaults to
	 *                                   the lowest gear.
	 * @param minNumPointsInBottomBuffer The minimum number of points that must be in the bottom-level MP buffer before
	 *                                   starting a profile. Defaults to 20.
	 * @param updaterProcessPeriodSecs   The period for the Notifier that moves points between the MP buffers, in seconds.
	 *                                   Defaults to 0.005.
	 * @param slaves                     The other {@link CANTalon}s that are slaved to this one.
	 */
	@JsonCreator
	public FPSTalonWithPositon(@JsonProperty(required = true) int port,
	                           @JsonProperty(required = true) boolean inverted,
	                           boolean reverseOutput,
	                           @JsonProperty(required = true) boolean enableBrakeMode,
	                           @Nullable Boolean fwdLimitSwitchNormallyOpen,
	                           @Nullable Boolean revLimitSwitchNormallyOpen,
	                           @Nullable Double fwdSoftLimit,
	                           @Nullable Double revSoftLimit,
	                           @Nullable Double postEncoderGearing,
	                           @Nullable Double feetPerRotation,
	                           @Nullable Integer currentLimit,
	                           double maxClosedLoopVoltage,
	                           @Nullable CANTalon.FeedbackDevice feedbackDevice,
	                           @Nullable Integer encoderCPR,
	                           boolean reverseSensor,
	                           @Nullable List<PerGearSettings> perGearSettings,
	                           @Nullable Shiftable.gear startingGear,
	                           @Nullable Integer startingGearNum,
	                           @Nullable Integer minNumPointsInBottomBuffer,
	                           @Nullable Double updaterProcessPeriodSecs,
	                           @Nullable List<SlaveTalon> slaves) {
		super(port, inverted, reverseOutput, enableBrakeMode, fwdLimitSwitchNormallyOpen, revLimitSwitchNormallyOpen, fwdSoftLimit, revSoftLimit, postEncoderGearing, feetPerRotation, currentLimit, maxClosedLoopVoltage, feedbackDevice, encoderCPR, reverseSensor, perGearSettings, startingGear, startingGearNum, minNumPointsInBottomBuffer, updaterProcessPeriodSecs, slaves);
	}

	/**
	 * Set a position setpoint for the Talon.
	 *
	 * @param feet An absolute position setpoint, in feet.
	 */
	public void setPositionSetpoint(double feet){
		canTalon.changeControlMode(CANTalon.TalonControlMode.Position);
		canTalon.set(feetToEncoder(feet));
	}
}
