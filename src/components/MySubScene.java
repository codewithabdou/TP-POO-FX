package components;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class MySubScene extends SubScene {
    private final String BACKGROUND_PATH ="file:ressources/yellow_panel.png";
    private  boolean isHidden;
    public MySubScene(int x , int y ,int w,int h) {
        super(new AnchorPane(),w,h);
        prefHeight(h);
        prefWidth(w);
        setLayoutX(x);
        setLayoutY(y);
        isHidden=true;
        Image image = new Image(BACKGROUND_PATH,w,h,true,false);
        BackgroundImage background= new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);
        AnchorPane root = (AnchorPane) this.getRoot();
        root.setBackground(new Background(background));
    }

    public void move(int x){
        TranslateTransition transition= new TranslateTransition();
        transition.setDuration(Duration.seconds(0.5));
        transition.setNode(this);
        if(isHidden){
            transition.setToX(450-x);
            isHidden=false;
        }
        else{
            transition.setToX(0);
            isHidden=true;
        }
        transition.play();
    }

    public  boolean getIsHidden(){
        return  isHidden;
    }

    public void addToPane(Node n){
        AnchorPane root = (AnchorPane) this.getRoot();
        root.getChildren().add(n);
    }

    public  AnchorPane getPane(){
        return  (AnchorPane) this.getRoot();
    }
}
