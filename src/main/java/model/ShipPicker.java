package model;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ShipPicker extends VBox {
    private ImageView circleImage;
    private ImageView shipImage;

    private String circleNotChoosen = "C:\\Users\\petko.lyutskanov\\Desktop\\Student\\IdeaProjects\\GalaxyDodger\\GalaxyDodger\\src\\main\\java\\view\\resources\\shipchooser\\grey_circle.png";
    private String circleChoosen = "C:\\Users\\petko.lyutskanov\\Desktop\\Student\\IdeaProjects\\GalaxyDodger\\GalaxyDodger\\src\\main\\java\\view\\resources\\shipchooser\\yellow_boxTick.png";

    private Ship ship;

    private boolean isCircleChosen;

    public ShipPicker(Ship ship) {
        circleImage = new ImageView(circleNotChoosen);
        shipImage = new ImageView(ship.getUrl());
        this.ship = ship;
        isCircleChosen = false;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.getChildren().add(circleImage);
        this.getChildren().add(shipImage);
    }

    public Ship getShip() {
        return this.ship;
    }

    public boolean getIsCircleChosen() {
        return isCircleChosen;
    }

    public void setIsCircleChosen(boolean isCircleChosen) {
        this.isCircleChosen = isCircleChosen;
        String imageToSet = this.isCircleChosen ? circleChoosen : circleNotChoosen;
        circleImage.setImage(new Image(imageToSet));

    }
}
