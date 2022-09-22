<<<<<<< HEAD
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

=======
>>>>>>> cc1a296ffd5ef6ed657219fb8db009d6b26b76fa
package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
<<<<<<< HEAD
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class SwerveSubsystem extends SubsystemBase{
    // int driveMotorID, int turningMotorID, boolean driveMotorReversed, boolean turningMotorReversed,
    //          int absoluteEncoderID, double absoluteEncoderOffset, boolean absoluteEncoderReversed
    private final SwerveModule frontLeft = new SwerveModule(
        DriveConstants.frontLeftModule.driveMotorID, 
        DriveConstants.frontLeftModule.turningMotorID, 
        DriveConstants.frontLeftModule.driveMotorReversed, 
        DriveConstants.frontLeftModule.turningMotorReversed, 
        DriveConstants.frontLeftModule.absoluteEncoderID, 
        DriveConstants.frontLeftModule.absoluteEncoderOffset, 
        DriveConstants.frontLeftModule.absoluteEncoderReversed
        );

    private final SwerveModule frontRight = new SwerveModule(
        DriveConstants.frontRightModule.driveMotorID, 
        DriveConstants.frontRightModule.turningMotorID, 
        DriveConstants.frontRightModule.driveMotorReversed, 
        DriveConstants.frontRightModule.turningMotorReversed, 
        DriveConstants.frontRightModule.absoluteEncoderID, 
        DriveConstants.frontRightModule.absoluteEncoderOffset, 
        DriveConstants.frontRightModule.absoluteEncoderReversed
        );

    private final SwerveModule backLeft = new SwerveModule(
        DriveConstants.backLeftModule.driveMotorID, 
        DriveConstants.backLeftModule.turningMotorID, 
        DriveConstants.backLeftModule.driveMotorReversed, 
        DriveConstants.backLeftModule.turningMotorReversed, 
        DriveConstants.backLeftModule.absoluteEncoderID, 
        DriveConstants.backLeftModule.absoluteEncoderOffset, 
        DriveConstants.backLeftModule.absoluteEncoderReversed
        );

    private final SwerveModule backRight = new SwerveModule(
        DriveConstants.backRightModule.driveMotorID, 
        DriveConstants.backRightModule.turningMotorID, 
        DriveConstants.backRightModule.driveMotorReversed, 
        DriveConstants.backRightModule.turningMotorReversed, 
        DriveConstants.backRightModule.absoluteEncoderID, 
        DriveConstants.backRightModule.absoluteEncoderOffset, 
        DriveConstants.backRightModule.absoluteEncoderReversed
        );

    private AHRS gyro = new AHRS(SPI.Port.kMXP);


    public SwerveSubsystem() {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                zeroHeading();
            } catch (Exception e) {
            }
        }).start();
        
=======
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.Constants.DriveConstants;
import frc.robot.hardware.AbsoluteEncoders;
import frc.robot.hardware.MotorControllers;

public class SwerveSubsystem extends SubsystemBase{
    private final SwerveModule frontLeft = new SwerveModule(
        MotorControllers.FrontLeftModuleDrive.getMotor(),
        MotorControllers.FrontLeftModuleTurn.getMotor(),
        AbsoluteEncoders.FrontLeftModule.getAngleSupplier(),
        "FL");

    private final SwerveModule frontRight = new SwerveModule(
        MotorControllers.FrontRightModuleDrive.getMotor(),
        MotorControllers.FrontRightModuleTurn.getMotor(),
        AbsoluteEncoders.FrontRightModule.getAngleSupplier(),
        "FR");

    private final SwerveModule backLeft = new SwerveModule(
        MotorControllers.BackLeftModuleDrive.getMotor(),
        MotorControllers.BackLeftModuleTurn.getMotor(),
        AbsoluteEncoders.BackLeftModule.getAngleSupplier(),
        "BL");

    private final SwerveModule backRight = new SwerveModule(
        MotorControllers.BackRightModuleDrive.getMotor(),
        MotorControllers.BackRightModuleTurn.getMotor(),
        AbsoluteEncoders.BackRightModule.getAngleSupplier(),
        "BR");

    private AHRS gyro = new AHRS(SPI.Port.kMXP);

    public SwerveSubsystem() {
        new WaitUntilCommand(this::gyroReady)
        .andThen(new InstantCommand(this::zeroHeading,this))
        .schedule();
    }

    public boolean gyroReady() {
        return !gyro.isCalibrating();
>>>>>>> cc1a296ffd5ef6ed657219fb8db009d6b26b76fa
    }

    public void zeroHeading() {
        gyro.reset();
    }

    public double getHeading() {
        return Math.IEEEremainder(gyro.getAngle(), 360); //Clamps angle output between -180 and 180 degrees
    }

    public Rotation2d getRotation2d() {
        return Rotation2d.fromDegrees(getHeading());
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Robot Heading", getHeading());
    }

<<<<<<< HEAD
    @Override
    public void simulationPeriodic() {

    }

=======
>>>>>>> cc1a296ffd5ef6ed657219fb8db009d6b26b76fa
    public void stopModules(){
        frontLeft.stop();
        frontRight.stop();
        backLeft.stop();
        backRight.stop();
    }

    public void setModuleStates(SwerveModuleState[] desiredStates) {
        SwerveDriveKinematics.desaturateWheelSpeeds(desiredStates, DriveConstants.kPhysicalMaxSpeed);
        frontLeft.setDesiredState(desiredStates[0]);
        frontRight.setDesiredState(desiredStates[1]);
        backLeft.setDesiredState(desiredStates[2]);
        backRight.setDesiredState(desiredStates[3]);
    }

<<<<<<< HEAD
    public SwerveModuleState[] getModuleStates() {
        SwerveModuleState[] swerveModuleArray = new SwerveModuleState[4];
        swerveModuleArray[0] = frontLeft.getState();
        swerveModuleArray[1] = frontRight.getState();
        swerveModuleArray[2] = backLeft.getState();
        swerveModuleArray[3] = backRight.getState();

        return swerveModuleArray;
    }
    

=======
>>>>>>> cc1a296ffd5ef6ed657219fb8db009d6b26b76fa
}