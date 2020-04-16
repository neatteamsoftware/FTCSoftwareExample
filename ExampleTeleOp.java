package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Example TeleOp", group = "Example")
public class ExampleTeleOp extends OpMode {

    private Servo servo;
    private DcMotor leftDrive;
    private DcMotor rightDrive;

    @Override
    public void init() {
        servo = hardwareMap.get(Servo.class, "servo");
        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        double leftPower = -gamepad1.left_stick_y;
        double rightPower = -gamepad1.right_stick_y;

        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);

        if (gamepad1.a)
            servo.setPosition(0.5);

        telemetry.addData("Left Drive Power", leftDrive.getPower());
        telemetry.addData("Right Drive Power", rightDrive.getPower());
        telemetry.addData("Servo Position", servo.getPosition());
        telemetry.addData("Status", "Running");
    }
}
