package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.Trajectory;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;


import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueLight;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedLight;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class TestBot {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity leftBot = new DefaultBotBuilder(meepMeep)
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .setColorScheme(new ColorSchemeBlueDark())
                .build();

        leftBot.runAction(leftBot.getDrive().actionBuilder(new Pose2d(-10, -64.25, Math.toRadians(90)))
                .setReversed(true)
                .strafeToLinearHeading(new Vector2d(-24, -64.25), Math.toRadians(90))
                .strafeToLinearHeading(new Vector2d(-50, -9), Math.toRadians(90))
                .strafeToLinearHeading(new Vector2d(-30, -9), Math.toRadians(90))
                .build());

        RoadRunnerBotEntity rightBot = new DefaultBotBuilder(meepMeep)
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .setColorScheme(new ColorSchemeBlueDark())
                .build();

        rightBot.runAction(rightBot.getDrive().actionBuilder(new Pose2d(10, -62.25, Math.toRadians(90)))
                .setReversed(true)
                .strafeToLinearHeading(new Vector2d(37, -62.25), Math.toRadians(90))
                .strafeToLinearHeading(new Vector2d(37, -24), Math.toRadians(270))
                .strafeToLinearHeading(new Vector2d(47, -8), Math.toRadians(270))
                .strafeToLinearHeading(new Vector2d(47, -62.25), Math.toRadians(270))
                .strafeToLinearHeading(new Vector2d(47, -8), Math.toRadians(270))
                .strafeToLinearHeading(new Vector2d(57, -8), Math.toRadians(270))
                .strafeToLinearHeading(new Vector2d(57, -62.25), Math.toRadians(270))
                .strafeToLinearHeading(new Vector2d(57, -8), Math.toRadians(270))
                .strafeToLinearHeading(new Vector2d(67, -8), Math.toRadians(270))
                .strafeToLinearHeading(new Vector2d(67, -62.25), Math.toRadians(270))

                .build());
        
        leftBot.setDimensions(18, 18);
        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(leftBot)
                .addEntity(rightBot)
                .start();
    }
}