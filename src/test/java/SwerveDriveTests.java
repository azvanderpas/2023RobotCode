import static org.junit.Assert.*;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.simulation.*;

import org.junit.*;

import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.SwerveSubsystem;


public class SwerveDriveTests {

  //DUT -> Device Under Test
  private SwerveSubsystem dut;


  @Before // this method will run before each test
  public void setup() {
    assert HAL.initialize(500, 0); // initialize the HAL, crash if failed
    dut = new SwerveSubsystem();
  }

  @After // this method will run after each test
  public void shutdown() throws Exception {
    dut.close(); // destroy our subsystem object so we do each test from a clean slate
  }

  @Test // marks this method as a test
  public void testSetModuleStates() {
    ChassisSpeeds speed = new ChassisSpeeds();
    // Create chassis speed that will be too fast
    speed.omegaRadiansPerSecond = Math.PI;
    speed.vxMetersPerSecond = DriveConstants.kPhysicalMaxSpeed*2;
    speed.vyMetersPerSecond = DriveConstants.kPhysicalMaxSpeed*2;
    SwerveModuleState [] desiredStates = DriveConstants.kDriveKinematics.toSwerveModuleStates(speed);
    dut.setModuleStates(desiredStates);

    // Print resulting values for debug
    // TODO remove when done debugging
    for (SwerveModuleState s : desiredStates) {
      System.out.print("\n" + s.toString()); 
    }


    // Validate module speeds are below the maximum after normalizeDrive gets run
    for (int i = 0; i < desiredStates.length; i++) {
      assertTrue(desiredStates[i].speedMetersPerSecond <= DriveConstants.kPhysicalMaxSpeed);
    }

    // Print result of desaturateWheelsSpeeds for debug comparison 
    // TODO remove when done debugging
    desiredStates = DriveConstants.kDriveKinematics.toSwerveModuleStates(speed);
    SwerveDriveKinematics.desaturateWheelSpeeds(desiredStates, DriveConstants.kPhysicalMaxSpeed);
    for (SwerveModuleState s : desiredStates) {
      System.out.print("\n" + s.toString()); 
    }
    System.out.println();

  }


  // Add more @Test tagged methods to test other things...
}
