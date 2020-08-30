package model;

import java.io.PrintWriter;
import java.util.ArrayList;
import model.InventoryItem;
import persistence.Reader;
import persistence.Saveable;
import rooms.Room;
import rooms.Room1;


public class Player implements Saveable {
    int health;
    public ArrayList<InventoryItem> inventory;
    Room location;
//    Room initRoom = new Room1();


    public Player() {
        health = 100;
        inventory = new ArrayList<>();
//        location = initRoom;
    }


    // MODIFIES: this
    // EFFECTS: adds an InventoryItem to inventory
    public void addInventoryItem(InventoryItem i) {
        inventory.add(i);
    }

    // MODIFIES: this
    // EFFECTS: changes rooms to the one given in the parameter
    public void changeLoc(Room loc) {
        location = loc;
    }

    // REQUIRES: a non-empty inventory
    // EFFECTS: produces a list of all items in the inventory
    public String printInventory() {
        if (inventory.size() == 0) {
            return "Your inventory is empty";
        }
        String str = "";
        for (InventoryItem i : inventory) {
            str = str + i.getName() + "\n";
        }
        System.out.println(str);
        return "The items currently in your inventory are:\n" + str;
    }

    // REQUIRES: newHealth < 100
    // MODIFIES: this
    // EFFECTS: changes health to match a given integer
    public void changeHealth(int newHealth) {
        health = newHealth;
    }

    //getters
    public int getHealth() {
        return health;
    }

    public ArrayList getInventory() {
        return inventory;
    }

    public Room getLocation() {
        return location;
    }

    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(health);
        printWriter.print(Reader.DELIMITER);
        for (InventoryItem i : inventory) {
            printWriter.print(i.name);
            printWriter.print(Reader.INVEN_DELIMITER);
        }
        printWriter.print(Reader.DELIMITER);
        printWriter.print(location.getRoomNumber());
    }
}
