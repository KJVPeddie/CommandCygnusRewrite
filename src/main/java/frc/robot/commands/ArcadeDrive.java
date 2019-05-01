/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Drive;
import frc.robot.Robot;

public class ArcadeDrive extends Command {
  Drive drive; 


  public ArcadeDrive() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    drive = new Drive();
    requires(drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    DriverStation.reportError("okay we send command",false);
    drive.arcadeDrive(Robot.m_oi.leftjoystick.getRawAxis(1), Robot.m_oi.rightjoystick.getRawAxis(0));
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
