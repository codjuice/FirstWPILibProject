import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.WheelSubsystem;

/** An example command that does nothing. */
public class DrivingCommand extends Command {
    /**
     * Creates a new ExampleCommand.
     */
    double speed;

    public DrivingCommand(double speed) {
        setName("DrivingCommand");
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(WheelSubsystem.getInstance());
        this.speed = speed;

    }


    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        WheelSubsystem.getInstance().setMotor1Speed(speed);
    }


    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {}


    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        WheelSubsystem.getInstance().setMotor1Speed(0);
    }


    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
