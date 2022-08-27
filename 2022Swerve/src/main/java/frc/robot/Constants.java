// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class DriveConstants{ //TODO: Update these constants with physical values
        public static final double kPhysicalMaxSpeed = 0; //Max drivebase speed in meters per second

        public static final class frontLeftModule{
            public static final int driveMotorID = 0;
            public static final int turningMotorID = 0;
            public static final boolean driveMotorReversed = false;
            public static final boolean turningMotorReversed = false;
            public static final int absoluteEncoderID = 0;
            public static final double absoluteEncoderOffset = 0; 
            public static final boolean absoluteEncoderReversed = false;
        }

        public static final class frontRightModule{
            public static final int driveMotorID = 0;
            public static final int turningMotorID = 0;
            public static final boolean driveMotorReversed = false;
            public static final boolean turningMotorReversed = false;
            public static final int absoluteEncoderID = 0;
            public static final double absoluteEncoderOffset = 0; 
            public static final boolean absoluteEncoderReversed = false; 
        }

        public static final class backLeftModule{
            public static final int driveMotorID = 0;
            public static final int turningMotorID = 0;
            public static final boolean driveMotorReversed = false;
            public static final boolean turningMotorReversed = false;
            public static final int absoluteEncoderID = 0;
            public static final double absoluteEncoderOffset = 0; 
            public static final boolean absoluteEncoderReversed = false;
        }

        public static final class backRightModule{
            public static final int driveMotorID = 0;
            public static final int turningMotorID = 0;
            public static final boolean driveMotorReversed = false;
            public static final boolean turningMotorReversed = false;
            public static final int absoluteEncoderID = 0;
            public static final double absoluteEncoderOffset = 0; 
            public static final boolean absoluteEncoderReversed = false;
        }
    }

    public static final class SwerveModuleConstants{ //TODO: Update these constants with physical values
        public static final double kWheelDiameterMeters = Units.inchesToMeters(4);
        public static final double kDriveMotorGearRatio = 1 / 1;
        public static final double kTurningMotorGearRatio = 1 / 1;
        public static final double kDriveEncoderRotFactor = kDriveMotorGearRatio * Math.PI * kWheelDiameterMeters; //Conversion factor converting the Drive Encoder's rotations to meters
        public static final double kDriveEncoderRPMFactor = kDriveEncoderRotFactor / 60; //Conversion factor converting the Drive Encoder's RPM to meters per second
        public static final double kTurningEncoderRotFactor = kTurningMotorGearRatio * 2 * Math.PI; //Conversion factor converting the Turn Encoder's rotations to Radians
        public static final double kTurningEncoderRPMFactor = kTurningEncoderRotFactor / 60; //Conersion factor converting the Turn Encoder's RPM to radians per second
        public static final double kPTurning = 0; //P gain for the turning motor
    }
}
