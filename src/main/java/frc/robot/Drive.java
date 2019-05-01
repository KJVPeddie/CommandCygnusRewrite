/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc. robot;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.commands.ArcadeDrive;
import edu.wpi.first.wpilibj.DriverStation;

public class Drive extends Subsystem {
  
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

  }
  private double leftSpeed;
  private double rightSpeed;
  private TalonSRX leftDriveMaster;
  private TalonSRX rightDriveMaster;
  private VictorSPX leftDriveFollower1;
  private VictorSPX leftDriveFollower2;
  private VictorSPX rightDriveFollower1;
  private VictorSPX rightDriveFollower2;
  private Encoder leftEncoder;
  private Encoder rightEncoder;



  private enum Mode_Type {TELEOP, AUTO_DRIVE};

  private Mode_Type mode = Mode_Type.TELEOP;
  
  public Drive() {
      leftDriveMaster = new TalonSRX(RobotMap.MOTOR_DRIVE_LEFT_MASTER);
  leftDriveFollower1 = new VictorSPX(RobotMap.MOTOR_DRIVE_LEFT_FOLLOWER_1);
  leftDriveFollower2 = new VictorSPX(RobotMap.MOTOR_DRIVE_LEFT_FOLLOWER_2);
  rightDriveMaster = new TalonSRX(RobotMap.MOTOR_DRIVE_RIGHT_MASTER);
  rightDriveFollower1 = new VictorSPX(RobotMap.MOTOR_DRIVE_RIGHT_FOLLOWER_1);
      rightDriveFollower2 = new VictorSPX(RobotMap.MOTOR_DRIVE_RIGHT_FOLLOWER_2);
      
     }

  public void arcadeDrive(double speed, double turn){
      leftSpeed = -(speed - turn);
      rightSpeed = speed + turn;

      leftDriveMaster.set(ControlMode.PercentOutput, leftSpeed);
  rightDriveMaster.set(ControlMode.PercentOutput, rightSpeed);
  leftDriveFollower1.set(ControlMode.PercentOutput, leftSpeed);
      rightDriveFollower1.set(ControlMode.PercentOutput, rightSpeed);
      leftDriveFollower2.set(ControlMode.PercentOutput, leftSpeed);
  rightDriveFollower2.set(ControlMode.PercentOutput, rightSpeed);
      }
}


