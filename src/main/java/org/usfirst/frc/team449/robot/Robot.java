package org.usfirst.frc.team449.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * The main class of the robot, constructs all the subsystems and initializes default commands.
 */
public class Robot extends IterativeRobot {

	/**
	 * The absolute filepath to the resources folder containing the config files.
	 */
	@NotNull
	public static final String RESOURCES_PATH = "/home/lvuser/449_resources/";

	/**
	 * The current time in milliseconds as it was stored the last time a method in robot was run.
	 */
	private static long currentTimeMillis;

	/**
	 * The time robotInit started running.
	 */
	private static long startTime;
	/**
	 * The object constructed directly from the yaml map.
	 */
	private RobotMapRiabPID robotMap;
	/**
	 * The Notifier running the logging thread.
	 */
	private Notifier loggerNotifier;

	/**
	 * Get the current time, in milliseconds, since startup.
	 *
	 * @return current time in milliseconds.
	 */
	@Contract(pure = true)
	public static long currentTimeMillis() {
		return currentTimeMillis - startTime;
	}

	/**
	 * The method that runs when the robot is turned on. Initializes all subsystems from the map.
	 */
	public void robotInit() {

	}

	/**
	 * Run when we first enable in teleop.
	 */
	@Override
	public void teleopInit() {
		//Refresh the current time.
		currentTimeMillis = System.currentTimeMillis();
	}

	/**
	 * Run every tick in teleop.
	 */
	@Override
	public void teleopPeriodic() {
		//Refresh the current time.
		currentTimeMillis = System.currentTimeMillis();
		//Run all commands. This is a WPILib thing you don't really have to worry about.
		Scheduler.getInstance().run();
	}
}
