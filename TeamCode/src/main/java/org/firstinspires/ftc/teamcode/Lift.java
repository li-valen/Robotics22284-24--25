package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

class Lift{
    private Servo boostLeft;
    private Servo boostRight;
    private Servo claw;

    public Lift(HardwareMap hardwareMap) {
        boostLeft = hardwareMap.get(Servo.class, "boostLeft");
        boostRight = hardwareMap.get(Servo.class, "boostRight");
        claw = hardwareMap.get(Servo.class, "claw");

    }

    public Action initClaw() {
        return new Action() {
            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                boostLeft.setPosition(0.25);
                boostRight.setPosition(0.25);
                claw.setPosition(0.25);

                double left = boostLeft.getPosition();
                double right = boostRight.getPosition();
                double grab = claw.getPosition();
                packet.put("leftPos", left);
                packet.put("rightPos", right);
                packet.put("clawPos", grab);

                return false;
            }
        };
    }
}
