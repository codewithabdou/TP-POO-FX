package components;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MyButton extends Button {
    private final String FONT_PATH ="C:/Users/LENOVO/Desktop/TP-POO-FX/TP/ressources/uipack_fixed/Font/kenvector_future.ttf";
    public MyButton(String text,int x ,int y){
        setText(text);
        setFont();
        setPrefHeight(49);
        setPrefWidth(190);
        setLayoutY(y);
        setLayoutX(x);
        setReleasedStyle();
        eventListenner();
    }


    private void setFont(){
        try {
            setFont(Font.loadFont(new FileInputStream(FONT_PATH),20));
        } catch (FileNotFoundException e) {
            setFont(Font.font("vernada",23));
        }
    }

    private void setPressedStyle(){

        setPrefHeight(45);
        setLayoutY(getLayoutY()+4);
        Image image=new Image("C:/Users/LENOVO/Desktop/TP-POO-FX/TP/ressources/yellow_button01.png");
        Background background=new Background(new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT));
        setBackground(background);
    }

    private void setReleasedStyle(){
        setPrefHeight(49);
        setLayoutY(getLayoutY()-4);
        Image image=new Image("C:/Users/LENOVO/Desktop/TP-POO-FX/TP/ressources/yellow_button00.png");
        Background background=new Background(new BackgroundImage(image,BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT));
        setBackground(background);

    }

    private void eventListenner(){
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent actionEvent) {
                setPressedStyle();
            }
        });
        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent actionEvent) {
                setReleasedStyle();
            }
        });

        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent actionEvent) {
                setEffect(new DropShadow(5,Color.WHITE));
            }
        });

        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent actionEvent) {
                setEffect(null);
            }
        });
    }
}

