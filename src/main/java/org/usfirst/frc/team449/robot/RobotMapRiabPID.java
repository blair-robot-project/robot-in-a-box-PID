package org.usfirst.frc.team449.robot;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.usfirst.frc.team449.robot.oi.buttons.CommandButton;
import org.usfirst.frc.team449.robot.other.Logger;

import java.util.List;

/**
 * The robot map for the Robot In A Box PID module.
 */
public class RobotMapRiabPID {

	/**
	 * The buttons for controlling this robot.
	 */
	@NotNull
	private final List<CommandButton> buttons;

	/**
	 * The logger for recording events and telemetry data.
	 */
	@NotNull
	private final Logger logger;

	/**
	 * Default constructor.
	 *
	 * @param buttons The buttons for controlling this robot.
	 * @param logger The logger for recording events and telemetry data.
	 */
	@JsonCreator
	public RobotMapRiabPID(@NotNull @JsonProperty(required = true) List<CommandButton> buttons,
	                       @NotNull @JsonProperty(required = true) Logger logger) {
		this.buttons = buttons;
		this.logger = logger;
	}

	/**
	 * @return The buttons for controlling this robot.
	 */
	@NotNull
	public List<CommandButton> getButtons() {
		return buttons;
	}

	/**
	 * @return The logger for recording events and telemetry data.
	 */
	@NotNull
	public Logger getLogger() {
		return logger;
	}
}
