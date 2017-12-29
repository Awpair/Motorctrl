package org.usfirst.frc.team6325.robot;
import edu.wpi.first.wpilibj.Joystick;import edu.wpi.first.wpilibj.RobotDrive;import edu.wpi.first.wpilibj.RobotDrive.MotorType;import edu.wpi.first.wpilibj.SampleRobot;import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {
     RobotDrive myRobot;
     Joystick stick;
     Timer timer;
     public void robotInit() {
          myRobot = new RobotDrive(0,1);
          stick = new Joystick(1);
          timer = new Timer();
     }
	RobotDrive rDrv;
	final int kFLeftChannel = 2;
	final int kRearLeftChannel = 3;
	final int kFrCh = 1;
	final int kRearrCh = 0;
	final int kJoystickChannel = 0;
	Joystick stk1 = new Joystick(kJoystickChannel);

	public Robot() {
		rDrv = new RobotDrive(kFLeftChannel, kRearLeftChannel, kFrCh, kRearrCh);
		rDrv.setInvertedMotor(MotorType.kFrontLeft, true);
		rDrv.setInvertedMotor(MotorType.kRearLeft, true);
		rDrv.setExpiration(0.1);
	}
	public void operatorControl() {
		rDrv.setSafetyEnabled(true);
		while (isOperatorControl() && isEnabled()) {
			rDrv.mecanumDrive_Cartesian(stk1.getX(), stk1.getY(), stk1.getZ(), 0);

			Timer.delay(0.005);
		}
	}
	public void testPeriodic() {
		LiveWindow.run();
	}
}

