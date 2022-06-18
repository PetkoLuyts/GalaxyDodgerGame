package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class ViewManager extends Label {
    private static final int HEIGHT = 768;
    private static final int WIDTH = 1024;

    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    private final static int MENU_BUTTONS_START_X = 100;
    private final static int MENU_BUTTONS_START_Y = 150;

    private GalaxyDodgerSubScene creditsSubScene;
    private GalaxyDodgerSubScene helpSubScene;
    private GalaxyDodgerSubScene shipChooserScene;

    private GalaxyDodgerSubScene sceneToHide;

    List<GalaxyDodgerButton> menuButtons;

    List<ShipPicker> shipsList;
    private Ship chosenShip;

    public ViewManager()  {
        menuButtons = new ArrayList<>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createSubScenes();
        createButtons();
        createBackground();
        createLogo();
    }

    private void showSubScene(GalaxyDodgerSubScene subScene) {
        if (sceneToHide != null) {
            sceneToHide.moveSubScene();
        }

        subScene.moveSubScene();
        sceneToHide = subScene;
    }

    private void createSubScenes() {
        createCreditsSubScene();
        helpSubScene();
        createShipChooserSubScene();
    }

    private void helpSubScene() {
        helpSubScene = new GalaxyDodgerSubScene();
        mainPane.getChildren().add(helpSubScene);

        Text helpText = new Text("You are a galaxy dodger!\nYour job is really responsible!\nBecause of you a whole another planet\n" +
                "receive their deliveries at time!\nWatch out for the dangerous meteors!\nYou can hit a maximum of three\nand your spaceship " +
                "will explode!\nCollect stars for a higher score!");
        Font font = Font.font("Comic Sans MS", FontWeight.EXTRA_BOLD, 25);
        helpText.setFont(font);

        helpText.setLayoutX(50);
        helpText.setLayoutY(80);
        helpSubScene.getPane().getChildren().add(helpText);
    }

    private void createCreditsSubScene() {
        creditsSubScene = new GalaxyDodgerSubScene();
        mainPane.getChildren().add(creditsSubScene);

        Text creditsText = new Text("Game created by: Petko Lyutskanov");
        Font font = Font.font("Comic Sans MS", FontWeight.EXTRA_BOLD, 25);
        creditsText.setFont(font);

        creditsText.setLayoutX(80);
        creditsText.setLayoutY(100);
        creditsSubScene.getPane().getChildren().add(creditsText);
    }

    private void createShipChooserSubScene() {
        shipChooserScene = new GalaxyDodgerSubScene();
        mainPane.getChildren().add(shipChooserScene);

        InfoLabel chooseShipLabel = new InfoLabel("CHOOSE YOUR SHIP");
        chooseShipLabel.setLayoutX(110);
        chooseShipLabel.setLayoutY(25);
        shipChooserScene.getPane().getChildren().add(chooseShipLabel);
        shipChooserScene.getPane().getChildren().add(createShipsToChoose());
        shipChooserScene.getPane().getChildren().add(createButtonToStart());

    }

    private HBox createShipsToChoose() {
        HBox box = new HBox();
        box.setSpacing(20);
        shipsList = new ArrayList<>();

        for (Ship ship : Ship.values()) {
            ShipPicker shipToPick = new ShipPicker(ship);
            shipsList.add(shipToPick);
            box.getChildren().add(shipToPick);
            shipToPick.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    for (ShipPicker ship : shipsList) {
                        ship.setIsCircleChosen(false);
                    }

                    shipToPick.setIsCircleChosen(true);
                    chosenShip = shipToPick.getShip();
                }
            });
        }

        box.setLayoutX(300 - (118 * 2));
        box.setLayoutY(100);
        return box;
    }

    private GalaxyDodgerButton createButtonToStart() {
        GalaxyDodgerButton startButton = new GalaxyDodgerButton("START");
        startButton.setLayoutX(350);
        startButton.setLayoutY(300);

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (chosenShip != null) {
                    GameViewManager gameManager = new GameViewManager();
                    gameManager.createNewGame(mainStage, chosenShip);
                }
            }
        });

        return startButton;
    }

    public Stage getMainStage() {
        return mainStage;
    }

    private void addMenuButton(GalaxyDodgerButton button) {
        button.setLayoutX(MENU_BUTTONS_START_X);
        button.setLayoutY(MENU_BUTTONS_START_Y + menuButtons.size() * 100);
        menuButtons.add(button);
        mainPane.getChildren().add(button);
    }

    private void createButtons() {
        createStartButton();
        createHelpButton();
        createCreditsButton();
        createExitButton();
    }

    private void createStartButton() {
        GalaxyDodgerButton startButton = new GalaxyDodgerButton("PLAY");
        addMenuButton(startButton);

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showSubScene(shipChooserScene);
            }
        });
    }

    private void createHelpButton() {
        GalaxyDodgerButton helpButton = new GalaxyDodgerButton("HELP");
        addMenuButton(helpButton);

        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showSubScene(helpSubScene);
            }
        });
    }

    private void createCreditsButton() {
        GalaxyDodgerButton creditsButton = new GalaxyDodgerButton("CREDITS");
        addMenuButton(creditsButton);

        creditsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showSubScene(creditsSubScene);
            }
        });
    }

    private void createExitButton() {
        GalaxyDodgerButton exitButton = new GalaxyDodgerButton("EXIT");
        addMenuButton(exitButton);

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainStage.close();
            }
        });
    }

    private void createBackground() {
        Image backgroundImage = new Image("C:\\Users\\petko.lyutskanov\\Desktop\\Student\\IdeaProjects\\GalaxyDodger\\GalaxyDodger\\src\\main\\java\\view\\resources\\purple.png",
                256, 256, false, true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(background));
    }

    private void createLogo() {
        ImageView logo = new ImageView("C:\\Users\\petko.lyutskanov\\Desktop\\Student\\IdeaProjects\\GalaxyDodger\\GalaxyDodger\\src\\main\\java\\view\\resources\\galaxy.png");
        logo.setLayoutX(800);
        logo.setLayoutY(25);

        logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                logo.setEffect(new DropShadow());
            }
        });

        logo.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                logo.setEffect(null);
            }
        });

        mainPane.getChildren().add(logo);
    }
}
