package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


@Config
@TeleOp(name = "BLUE_TEST_AUTO_PIXEL", group = "Autonomous")
public class ValenTeleOp extends LinearOpMode {

    public void runOpMode() throws InterruptedException {

        Servo boostLeft = hardwareMap.get(Servo.class, "boostLeft");
        Servo boostRight = hardwareMap.get(Servo.class, "boostRight");
        Servo liftLeft = hardwareMap.get(Servo.class, "liftLeft");
        Servo liftRight = hardwareMap.get(Servo.class, "liftRight");
        Servo claw = hardwareMap.get(Servo.class, "claw");
        ElapsedTime runtime = new ElapsedTime();

        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));

        waitForStart();
        runtime.reset();
        double t  = -9.0;
        int stage = 0;
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

            //raise just boosters
            if (gamepad2.a){
                boostLeft.setPosition(1);
                boostRight.setPosition(1);
                stage = 1;
            }

            //retract just boosters
            if (gamepad2.b){
                boostLeft.setPosition(0);
                boostRight.setPosition(0);
                stage = 0;
            }

            //retract just lifts
            if (gamepad2.y){
                liftLeft.setPosition(0);
                liftRight.setPosition(1);
            }

            //extend lifts, drop boosts
            if (gamepad2.x){
                liftLeft.setPosition(0.5);
                liftRight.setPosition(0.5);
                boostLeft.setPosition(0);
                boostRight.setPosition(0);
                stage = 3;
            }

            //start lift autostage
            if (t+5 < runtime.seconds() && runtime.seconds() < t+5.5){
                liftLeft.setPosition(0.5);
                liftRight.setPosition(0.5);
                stage = 2;
            }

            //drop boost autostage
            if (t+7.5 < runtime.seconds() && runtime.seconds() < t+8){
                boostLeft.setPosition(0);
                boostRight.setPosition(0);
                stage = 3;
            }
            //init autostage
            if (gamepad2.dpad_up){
                boostLeft.setPosition(1);
                boostRight.setPosition(1);
                stage = 1;
                t = runtime.seconds();
            }

            //universal reset
            if (gamepad2.dpad_down){
                boostLeft.setPosition(0);
                boostRight.setPosition(0);
                liftLeft.setPosition(0);
                claw.setPosition(1);
                stage = 0;
            }

            //grab
            if (gamepad2.right_bumper){
                claw.setPosition(0.25);
            }

            //let go
            if (gamepad2.left_bumper){
                claw.setPosition(1);
            }


            telemetry.addData("x", drive.pose.position.x);
            telemetry.addData("y", drive.pose.position.y);
            telemetry.addData("heading (deg)", Math.toDegrees(drive.pose.heading.toDouble()));
            telemetry.addData("VALEN SMELLS LIKE?", "STINKY FEET");
            telemetry.addData("Stage:", stage);
            telemetry.update();

        }
    }
}