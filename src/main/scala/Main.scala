package com.jacopocav.countdown

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout.{HBox, VBox}
import scalafx.scene.paint.Color._
import scalafx.scene.paint._
import scalafx.scene.text.Text

object Main extends JFXApp {
    stage = new PrimaryStage {
        title = "ScalaFX Hello World"
        scene = new Scene {
            fill = Color.rgb(38, 38, 38)
            content = new VBox(
                new HBox {
                    padding = Insets(50, 80, 0, 80)
                    children = Seq(
                        new Text {
                            text = "Final"
                            style = "-fx-font: normal bold 100pt sans-serif"
                            fill = new LinearGradient(
                                endX = 0,
                                stops = Stops(Red, DarkRed))
                        },
                        new Text {
                            text = "Countdown"
                            style = "-fx-font: italic bold 100pt sans-serif"
                            fill = new LinearGradient(
                                endX = 0,
                                stops = Stops(White, DarkGray)
                            )
                            effect = new DropShadow {
                                color = DarkGray
                                radius = 15
                                spread = 0.25
                            }
                        }
                    )
                },
                new HBox {
                    padding = Insets(0, 80, 50, 80)
                    children = Seq(new Text {
                        text = "by CeeJay"
                        style = "-fx-font: normal bold 36pt sans-serif"
                        fill = new LinearGradient(
                            endX = 0,
                            stops = Stops(Yellow, Orange))
                    })
                })
        }

    }
}