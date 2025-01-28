package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Drawing;
import org.firstinspires.ftc.teamcode.MecanumDrive;


@Config
@TeleOp(name = "BLUE_TEST_AUTO_PIXEL", group = "Autonomous")
public class ValenTeleOp extends LinearOpMode {

    public void runOpMode() throws InterruptedException {

        Servo boostLeft = hardwareMap.get(Servo.class, "boostLeft");
        Servo boostRight = hardwareMap.get(Servo.class, "boostRight");
        Servo liftLeft = hardwareMap.get(Servo.class, "liftLeft");
        Servo liftRight = hardwareMap.get(Servo.class, "liftRight");

        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));

        waitForStart();

        while (opModeIsActive()) {
            drive.setDrivePowers(new PoseVelocity2d(
                    new Vector2d(
                            -gamepad1.left_stick_y,
                            -gamepad1.left_stick_x
                    ),
                    -gamepad1.right_stick_x
            ));
            //valen smells like stinky feet
            drive.updatePoseEstimate();

            if (gamepad2.a){
                boostLeft.setPosition(1);
                boostRight.setPosition(1);
            }

            if (gamepad2.b){
                boostLeft.setPosition(0);
                boostRight.setPosition(0);
            }

            if (gamepad2.y){
                liftLeft.setPosition(0);
                liftRight.setPosition(1);
            }

            if (gamepad2.x){
                liftLeft.setPosition(0.5);
                liftRight.setPosition(0.5);
                boostLeft.setPosition(0);
                boostRight.setPosition(0);
            }

            telemetry.addData("x", drive.pose.position.x);
            telemetry.addData("y", drive.pose.position.y);
            telemetry.addData("heading (deg)", Math.toDegrees(drive.pose.heading.toDouble()));
            telemetry.addData("VALEN SMELLS LIKE?", "STINKY FEET");
            telemetry.update();

        }
    }
}