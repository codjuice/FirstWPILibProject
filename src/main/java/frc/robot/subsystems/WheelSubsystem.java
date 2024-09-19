// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.CANcoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class WheelSubsystem extends SubsystemBase {
    // Thread-safe singleton design pattern.
    private static volatile WheelSubsystem instance;
    private static Object mutex = new Object();
    private static CANSparkMax m_Motor = new CANSparkMax(2, MotorType.kBrushless);
    private final CANSparkMax motor1 = new CANSparkMax(4, MotorType.kBrushless);
    private final CANSparkMax motor2 = new CANSparkMax(5, MotorType.kBrushless);
    private final CANcoder sensor1 = new CANcoder(4);
    private final CANcoder sensor2 = new CANcoder(5);

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
        super("ExampleSubsystem");
    }

    public static void setspeed(double speed) {
        m_Motor.set(speed);
    }



    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
    

}
