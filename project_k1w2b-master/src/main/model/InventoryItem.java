package model;

public class InventoryItem {
    String name;
    String description;

    public InventoryItem(String name, String description) {
        this.name = name;
        this.description = description;
    }



    //getters
    public String getDescription() {
        System.out.println(description);
        return description;
    }

    public String getName() {
        return name;
    }
}
