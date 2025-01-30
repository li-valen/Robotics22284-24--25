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
@Autonomous(name = "RIGHT_AUTON", group = "Autonomous")
public class RightAuton extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        Servo boostLeft = hardwareMap.get(Servo.class, "boostLeft");
        Servo boostRight = hardwareMap.get(Servo.class, "boostRight");
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(10, -62.25, Math.toRadians(90)));
        Lift lift = new Lift(hardwareMap);

        waitForStart();


        Actions.runBlocking(new SequentialAction(
                lift.initClaw(),

                drive.actionBuilder(new Pose2d(10, -62.25, Math.toRadians(90)))
                        .setReversed(true)
                        .strafeToLinearHeading(new Vector2d(40, 0), Math.toRadians(90))
                        .build()));
    }

}
