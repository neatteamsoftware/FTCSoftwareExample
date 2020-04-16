package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Example Auto OpMode", group = "Example")
public class ExampleAutoOp extends LinearOpMode {

    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private ElapsedTime runtime;

    private static final double TURN_SPEED = 0.4;
    private static final double FORWARD_SPEED = 0.6;

    @Override
    public void runOpMode() {
        runtime = new ElapsedTime();
        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Auto ready");

        waitForStart();

        runtime.reset();
        leftDrive.setPower(FORWARD_SPEED);
        rightDrive.setPower(FORWARD_SPEED);
        while (opModeIsActive() && runtime.seconds() < 2.0) {
            telemetry.addData("Auto", "Part 1: %2.5f / 2.0s", runtime.seconds());
            telemetry.update();
        }

        runtime.reset();
        leftDrive.setPower(TURN_SPEED);
        rightDrive.setPower(-TURN_SPEED);
        while (opModeIsActive() && runtime.seconds() < 1.0) {
            telemetry.addData("Auto", "Part 2: %2.5f / 1.0s", runtime.seconds());
            telemetry.update();
        }

        runtime.reset();
        leftDrive.setPower(FORWARD_SPEED);
        rightDrive.setPower(FORWARD_SPEED);
        while (opModeIsActive() && runtime.seconds() < 2.0) {
            telemetry.addData("Auto", "Part 3: %2.5f / 2.0s", runtime.seconds());
            telemetry.update();
        }

        leftDrive.setPower(0.0);
        rightDrive.setPower(0.0);

        telemetry.addData("Status", "Auto complete");
    }
}
