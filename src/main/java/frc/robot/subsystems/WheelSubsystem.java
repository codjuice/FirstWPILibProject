// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import javax.swing.text.Position;

import com.ctre.phoenix6.hardware.CANcoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class WheelSubsystem extends SubsystemBase {
    // Thread-safe singleton design pattern.
    private static volatile WheelSubsystem instance;
    private static Object mutex = new Object();
    private static final CANSparkMax motor1 = new CANSparkMax(3, MotorType.kBrushless);
    private static final CANSparkMax motor2 = new CANSparkMax(2, MotorType.kBrushless);
    private static final CANcoder motor1Encoder = new CANcoder(10,"swerve");

    // private static Level m_Level = Level.LOW;

    public static WheelSubsystem getInstance() {
        WheelSubsystem result = instance;
       
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null) {
                    instance = result = new WheelSubsystem();
                }
            }
        }
        return instance;
    }


    /** Creates a new ExampleSubsystem. */
    public WheelSubsystem() {
        super("WheelSubsystem");
    }

    public void setSpeed1(double speed) {
        motor1.set(speed);
    }

    public void setSpeed2(double speed) {
        motor2.set(speed);
    }
    
    public double getMotor1Position() {
        double position = Units.rotationsToDegrees(motor1Encoder.getAbsolutePosition().getValue());
        return position;

    }
    public void setMotor1Speed(double speed) {
        motor1.set(speed);
    }
    public void setMotor2Speed(double speed) {
        motor2.set(speed);
    }



    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }


}
