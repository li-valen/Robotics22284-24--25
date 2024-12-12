package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp

public class HomeTest extends LinearOpMode {
    private DcMotor fR;
    private DcMotor bR;
    private DcMotor fL;
    private DcMotor bL;

    private Servo s0;
    private Servo s1;
    private Servo s2;
    private Servo s3;
    private Servo s4;
    private Servo s5;

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        fR = hardwareMap.dcMotor.get("fR");
        bR = hardwareMap.dcMotor.get("bR");
        fL = hardwareMap.dcMotor.get("fL");
        bL = hardwareMap.dcMotor.get("bL");

        s0 = hardwareMap.get(Servo.class, "s0");
        s1 = hardwareMap.get(Servo.class, "s1");
        s2 = hardwareMap.get(Servo.class, "s2");
        s3 = hardwareMap.get(Servo.class, "s3");
        s4 = hardwareMap.get(Servo.class, "s4");
        s5 = hardwareMap.get(Servo.class, "s5");

        waitForStart();
        runtime.reset();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

            fR.setPower(1);
            bR.setPower(1);
            fL.setPower(1);
            bL.setPower(1);

            while (!isStopRequested()){
                s0.setPosition(1);
                s1.setPosition(1);
                s2.setPosition(1);
                s3.setPosition(1);
                s4.setPosition(1);
                s5.setPosition(1);

                telemetry.addData("s0", s0.getPosition());
                telemetry.addData("s1", s0.getPosition());
                telemetry.addData("s2", s0.getPosition());
                telemetry.addData("s3", s0.getPosition());
                telemetry.addData("s4", s0.getPosition());
                telemetry.addData("s5", s0.getPosition());
                telemetry.addData("0", fL.getCurrentPosition());
                telemetry.addData("1", bL.getCurrentPosition());
                telemetry.addData("2", bR.getCurrentPosition());
                telemetry.addData("3", fR.getCurrentPosition());
                telemetry.update();
                sleep(2000);

                s0.setPosition(0);
                s1.setPosition(0);
                s2.setPosition(0);
                s3.setPosition(0);
                s4.setPosition(0);
                s5.setPosition(0);
                telemetry.addData("s0", s0.getPosition());
                telemetry.addData("s1", s0.getPosition());
                telemetry.addData("s2", s0.getPosition());
                telemetry.addData("s3", s0.getPosition());
                telemetry.addData("s4", s0.getPosition());
                telemetry.addData("s5", s0.getPosition());
                telemetry.addData("0", fL.getCurrentPosition());
                telemetry.addData("1", bL.getCurrentPosition());
                telemetry.addData("2", bR.getCurrentPosition());
                telemetry.addData("3", fR.getCurrentPosition());
                telemetry.update();
                sleep(2000);
            }
        }
    }
}
