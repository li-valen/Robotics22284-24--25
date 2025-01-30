package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@Config
@Autonomous(name = "LEFT_AUTON", group = "Autonomous")
public class LeftAuton extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        Servo boostLeft = hardwareMap.get(Servo.class, "boostLeft");
        Servo boostRight = hardwareMap.get(Servo.class, "boostRight");

        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(-10, -64.25, Math.toRadians(90)));
        Lift lift = new Lift(hardwareMap);

        waitForStart();

        boostRight.setPosition(0.5);
        boostLeft.setPosition(0.5);


        Actions.runBlocking(new SequentialAction(
                lift.initClaw(),

                drive.actionBuilder(new Pose2d(-10, -64.25, Math.toRadians(90)))
                        .setReversed(true)
                        .strafeToLinearHeading(new Vector2d(-24, -64.25), Math.toRadians(90))
                        .strafeToLinearHeading(new Vector2d(-50, -9), Math.toRadians(90))
                        .strafeToLinearHeading(new Vector2d(-30, -9), Math.toRadians(90))
                        .build(),

                lift.releaseSample()

        ));
    }

}
