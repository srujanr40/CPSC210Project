package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import model.Player;
import persistence.Reader;
import persistence.Writer;
import rooms.Room;
import rooms.Room1;
import rooms.Room2;
import rooms.Room3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Menu extends Application {
    Scanner scan = new Scanner(System.in);
    public Room1 room1;
    public Room2 room2;
    public Room3 room3;
    public Player gamePlayer;
    private static final String PROGRESS_FILE = "./data/progress.txt";
    Stage window;
    Scene menuScene;
    Scene roomInven1;
    Scene roomInven2;
    Scene roomInven3;
    Scene roomInteract1;
    Scene roomInteract2;
    Scene roomInteract3;
    Scene interRoom;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b8;
    Button b9;
    Button b10;
    Button bquit;

    // creating an image for all the doors
    Image door = new Image("file:./src/images/pngwave.png", 60, 120, false, false);
    ImageView door1 = new ImageView(door);
    ImageView door2 = new ImageView(door);
    ImageView door3 = new ImageView(door);

    // images for all the menu for all rooms
    Image backgroundRoom1 = new Image("https://cache.desktopnexus.com/cropped-wallpapers/2352/2352873-1440x900-[DesktopNexus.com].jpg?st=_kio-eiS4ea_uvg6FAkAnA&e=1583713668");
    ImagePattern br1 = new ImagePattern(backgroundRoom1);

    Image backgroundRoom2 = new Image("file:./src/images/R2_Background.jpg");
    ImagePattern br2 = new ImagePattern(backgroundRoom2);

    Image backgroundRoom3 = new Image("file:./src/images/R3_Background.jpg");
    ImagePattern br3 = new ImagePattern(backgroundRoom3);

    public Menu() {
        room1 = new Room1();
        room2 = new Room2();
        room3 = new Room3();
        gamePlayer = new Player();
        gamePlayer.changeLoc(room1);

        buildSceneInven1();
        buildSceneInven2();
        buildSceneInven3();
        buildSwitchRoomScene();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Welcome");
        VBox centeredMenu = addMenuToScene();
        centeredMenu.setTranslateX(900);
        centeredMenu.setAlignment(Pos.TOP_CENTER);
        menuScene = new Scene(centeredMenu, 1280, 720);

        // setting the background initially
        menuScene.setFill(br1);

        window.setScene(menuScene);
        window.show();
        AlertBox.display("Introduction", intro());
    }

    // MODIFIES: this
    // EFFECTS: returns a VBox Menu that can be added to the scene
    public VBox addMenuToScene() {
        // VBox
        VBox layout1 = new VBox(20);
        layout1.setPadding(new Insets(15, 12, 15, 12));
        b1 = new Button("1. See your Inventory");
        b2 = new Button("2. Look at a particular item in the Room");
        b3 = new Button("3. Check Health");
        b4 = new Button("4. Look Around for Items");
        b5 = new Button("5. Look Around for Clues");
        b6 = new Button("6. Move to a different room");
        b8 = new Button("8. Interact with the clues in the room");
        b9 = new Button("9. Load Progress from Saved File");
        b10 = new Button("10. Save Progress");
        bquit = new Button("-1. Quit");

        assignButtons();

        // Adding all the buttons to the layout
        layout1.getChildren().addAll(b1, b2, b3, b4, b5, b6, b8, b9, b10, bquit);
        return layout1;
    }

    // EFFECTS: returns the intro text
    private String intro() {
        return "You wake up\nYour eyes are still adjusting to the darkness\nYou try remember the events "
                + "leading up to this situation but your memory is fuzzy.\nYou realize the room is pitch black but you"
                + " can make out the faint outline of a lamp on a desk in front of you";
    }

    // MODIFIES: this
    // EFFECTS: assigns all the menu buttons to their required values
    public void assignButtons() {
        b1.setOnAction(e -> runMenu1(1));
        b2.setOnAction(e -> runMenu1(2));
        b3.setOnAction(e -> AlertBox.display("Health", "Your health is at " + gamePlayer.getHealth() + " %"));
        b4.setOnAction(e -> runMenu1(4));
        b5.setOnAction(e -> runMenu1(5));
        b6.setOnAction(e -> runMenu1(6));
        b8.setOnAction(e -> runMenu1(8));
        b9.setOnAction(e -> runMenu1(9));
        b10.setOnAction(e -> runMenu1(10));
        bquit.setOnAction(e -> runMenu1(-1));
    }

    // EFFECTS: displays all the choices the player can choose from
//    public void choice() {
//        System.out.println("--------------------------------------------------------");
//        System.out.println("\nActions:\n");
//        System.out.println("1. See your Inventory\n");
//        System.out.println("2. Look at a particular item in your Inventory\n");
//        System.out.println("3. Check Health\n");
//        System.out.println("4. Look Around for Items\n");
//        System.out.println("5. Look Around for Clues\n");
//        System.out.println("6. Move to a different room\n");
//        System.out.println("7. Add an item to your inventory\n");
//        System.out.println("8. Interact with the clues in the room\n");
//        System.out.println("9. Load Progress from Saved File\n");
//        System.out.println("10. Save Progress\n");
//        System.out.println("-1. Quit\n");
//    }

    // MODIFIES: this
    // EFFECTS: processes user input and moves gamePlayer to the right room
    public void moveRoom(int newRoom) {
        switch (newRoom) {
            case 1: gamePlayer.changeLoc(room1);
                menuScene.setFill(br1);
                // return "Moved to the First Room";
            case 2: if (gamePlayer.inventory.contains(Room1.KEROSENE_LAMP)) {
                    gamePlayer.changeLoc(room2);
                    menuScene.setFill(br2);
                    // return "Moved to the Second Room";
                } else {
                    gamePlayer.changeLoc(room2);     //should find work-arounds for this one
                    menuScene.setFill(br2);
                    // return "You can't enter this room because it's too dark";
                }
            case 3: if (gamePlayer.inventory.contains(Room2.ANCIENT_KEY)) {
                    gamePlayer.changeLoc(room3);
                    menuScene.setFill(br3);
                    // return "Moved to the third Room";
                } else {
                    gamePlayer.changeLoc(room3);    //should find work-arounds for this one
                    menuScene.setFill(br3);
                    // return "This room is locked with a giant brass padlock";
                }
        }
    }

    // MODIFIES: this
    // EFFECTS: builds the scene for inventory items in room1
    private void buildSceneInven1() {
        // creating a button for Kerosene Lamp
        Image keroseneLamp = new Image("file:./src/images/Kerosene_Lamp.png", 100, 100, false, false);
        ImageView kl = new ImageView(keroseneLamp);
        Button lamp = new Button("Kerosene Lamp", kl);
        lamp.setOnAction(e -> {
            gamePlayer.addInventoryItem(Room1.KEROSENE_LAMP);
            AlertBox.display("Description", Room1.KEROSENE_LAMP.getDescription());
            lamp.setText("Kerosene Lamp Added");
        });

        // creating a Return to the Menu button
        Button returnToMenu  = new Button("Return to the Menu");
        returnToMenu.setOnAction(e -> window.setScene(menuScene));

        // creating a new VBox Layout
        VBox layout = new VBox();
        layout.getChildren().addAll(lamp, returnToMenu);

        // allignment of the button
        layout.setAlignment(Pos.CENTER);

        // setting the layout to the scene
        roomInven1 = new Scene(layout, 1280, 720);
    }

    // MODIFIES: this
    // EFFECTS: builds the scene for inventory items in room2
    private void buildSceneInven2() {
        // creating a button for Ancient Key
        Image ancientKey = new Image("file:./src/images/Ancient_Key.png", 100, 100, false, false);
        ImageView ak = new ImageView(ancientKey);
        Button key = new Button("Ancient Key", ak);
        key.setOnAction(e -> {
            gamePlayer.addInventoryItem(Room2.ANCIENT_KEY);
            AlertBox.display("Description", Room2.ANCIENT_KEY.getDescription());
            key.setText("Ancient Key Added");
        });

        // creating a button for Laptop
        Image laptop = new Image("file:./src/images/Laptop.png", 100, 100, false, false);
        ImageView lp = new ImageView(laptop);
        Button lptp = new Button("Laptop", lp);
        lptp.setOnAction(e -> {
            gamePlayer.addInventoryItem(Room2.LAPTOP);
            AlertBox.display("Description", Room2.LAPTOP.getDescription());
            lptp.setText("Laptop Added");
        });

        // creating a Return to the Menu button
        Button returnToMenu  = new Button("Return to the Menu");
        returnToMenu.setOnAction(e -> window.setScene(menuScene));

        // creating a new HBox layout
        HBox layout = new HBox();
        layout.getChildren().addAll(key, lptp, returnToMenu);

        // allign the buttons in the center
        layout.setAlignment(Pos.CENTER);

        // setting the layout to the scene
        roomInven2 = new Scene(layout, 1280, 720);
    }

    // MODIFIES: this
    // EFFECTS: builds the scene for inventory items in room1
    private void buildSceneInven3() {
        // creating a button for Monogrammed Journal
        Image mjournal = new Image("file:./src/images/Journal.jpg", 100, 100, false, false);
        ImageView mj = new ImageView(mjournal);
        Button journal = new Button("Monogrammed Journal", mj);
        journal.setOnAction(e -> {
            gamePlayer.addInventoryItem(Room3.MONOGRAMMED_JOURNAL);
            AlertBox.display("Description", Room3.MONOGRAMMED_JOURNAL.getDescription());
            journal.setText("Monogrammed Journal Added");
        });

        // creating a Return to the Menu button
        Button returnToMenu  = new Button("Return to the Menu");
        returnToMenu.setOnAction(e -> window.setScene(menuScene));

        // creating a new HBox layout
        HBox layout = new HBox();
        layout.getChildren().addAll(journal, returnToMenu);

        //allign buttons to the center
        layout.setAlignment(Pos.CENTER);

        //setting the layout to the scene
        roomInven3 = new Scene(layout, 1280, 720);
    }

    // MODIFIES: this
    // EFFECTS: builds the scene for room changes
    private void buildSwitchRoomScene() {
        // creating a VBox and adding all the buttons to it
        Button d1 = new Button("Door 1", door1);
        d1.setOnAction(e -> {
            moveRoom(1);
            menuScene.setFill(br1);
        });
        Button d2 = new Button("Door 2", door2);
        d2.setOnAction(e -> {
            moveRoom(2);
            menuScene.setFill(br2);
        });
        Button d3 = new Button("Door 3", door3);
        d3.setOnAction(e -> {
            moveRoom(3);
            menuScene.setFill(br3);
        });

        // creating a Return to the Menu button
        Button returnToMenu  = new Button("Return to the Menu");
        returnToMenu.setOnAction(e -> window.setScene(menuScene));

        // creating a VBox
        VBox layout = new VBox();
        layout.getChildren().addAll(d1, d2, d3, returnToMenu);
        layout.setAlignment(Pos.CENTER);

        // setting the layout to the scene
        interRoom = new Scene(layout, 1280, 720);
    }

    // MODIFIES: this
    // EFFECTS: changes scene to the current room's InventoryScene
    public void changeInventoryScene(Room room) {
        if (room.equals(room1)) {
            window.setScene(roomInven1);
        } else if (room.equals(room2)) {
            window.setScene(roomInven2);
        } else if (room.equals(room3)) {
            window.setScene(roomInven3);
        }
    }

    public void changeInteractiveScene(Room room) {
        if (room.equals(room1)) {
            window.setScene(roomInteract1);
        } else if (room.equals(room2)) {
            window.setScene(roomInteract2);
        } else if (room.equals(room3)) {
            window.setScene(menuScene);
        }
    }


    // EFFECTS: saves progress of the player to PROGRESS_FILE
    private void saveProgress() {
        try {
            Writer writer = new Writer(new File(PROGRESS_FILE));
            writer.write(gamePlayer);
            writer.close();
            System.out.println("Progress saved to file " + PROGRESS_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save progress to " + PROGRESS_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // this is due to a programming error
        }
    }

    // MODIFIES: this
    // EFFECTS: loads progress from PROGRESS_FILE, if that exists;
    // otherwise initializes player with default values
    private void loadProgress() {
        try {
            Player loadPlayer = Reader.readPlayer(new File(PROGRESS_FILE));
            this.gamePlayer = loadPlayer;
            // move player to the right room
            moveRoom(loadPlayer.getLocation().getRoomNumber());
        } catch (IOException e) {
            gamePlayer = new Player();
            gamePlayer.changeLoc(room1);
        }
    }

    // MODIFIES: this
    // EFFECTS: runs the operations based on the choices from the menu
    public void runMenu1(int choice) {
        switch (choice) {
            case 1: AlertBox.display("As you rummage through....", gamePlayer.printInventory());
                break;
            case 2: changeInventoryScene(gamePlayer.getLocation());
                break;
            case 4: changeInventoryScene(gamePlayer.getLocation());
                break;
            case 9: loadProgress();
                    break;
            case 10: saveProgress();
                    break;
            default: runMenu2(choice);
                    break;
        }
//        window.setScene(menuScene);

    }

    // MODIFIES: this
    // EFFECTS: second part of the menu (because of the method limit)
    private void runMenu2(int choice) {
        switch (choice) {
            case 5: AlertBox.display("At a brief glance...", gamePlayer.getLocation().printInteractionsInRoom());
            break;
            case 8: changeInteractiveScene(gamePlayer.getLocation());
                break;
            case 6: window.setScene(interRoom);
                break;
            case -1: window.close();
            break;
        }
    }
}
