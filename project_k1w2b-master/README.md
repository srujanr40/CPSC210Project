# My Personal Project

## A Primitive Story-Driven Mystery Game

I'm hoping to make a mystery and exploration based story driven game.
 
It would involve interactions between players and other NPCs as well as inanimate objects as the player moves around 
between different rooms trying to figure out the way out.

By the end of the project I'd like to implement:

- A functioning health and inventory system.
- A bunch of items that have actual affect in game-play and other characters that the player can interact with.
- Graphic User elements and sounds that help make the player feel more involved


## Audience

Considering its a very basic game, I wouldn't expect many people to play it for fun (although I'd like to build it up
enough for that to happen one day). At this point I'd like people who come across it to get an idea of how games (albeit
very rudimentary) can be made easily and encourage them to work on some projects themselves.

## My Interest in this project

I've always been interested in playing games and wondered what happened behind the scenes to make one. I guess I'd like
to use this opportunity to learn that first hand.

## User Stories

####As a User, I want to be able to:

- Pick up objects I find in rooms and add them to my inventory.
- Move from room to room.
- Check my health.
- Select items in my inventory and see descriptions about them.
- See all items in the room that I can interact with.
- Save my inventory state and position on the map when I quit.
- Reload at exactly the same point in the game when I relaunch it.

##Instructions for Grader

_Note: Run the Program from the Menu class, not Main. 
Also, on some devices, the window loads with the menu off center. Simply resizing the window should fix this issue_


- To add something to the inventory, click on Menu Button 4 "Look Around for Item" and select an item from the room. To find more items to add to the inventory, move to a different room from the Menu (notice how the background of the Menu changes depending on the room that you're in)
- To view your inventory, click on Menu Button 1 "See your inventory"
- The audiovisual component of my project is the image background on the menu. It changes depending on the room you're in. The buttons for the items also have their own little icons.
- Hitting the "Save" button on the Menu will save the current state of the game.
- Selecting "Load Progress" button on the Menu will load the progress. To check what's been loaded, check the inventory of the player as well as the look for the change in the items in the room and the output for the "Look Around for Clues" button.

_Another Note: I haven't implemented button 8 yet. It isn't necessary for the project but I thought I'd leave it in if I wanted to work on making my project better_

##Phase 4
###Phase 4: Task 2
The option I've chosen is the **Type Hierarchy**. In the rooms package, the abstract class "Room" is extended by all the other rooms in the package. All the overridden methods from Room in all the 3 other classes have their own distinct functionalities. I've set it up so that any of the rooms can be passed into the same methods and have different outputs based on the Room.

###Phase 4: Task 3

1) In the Player class in the model package (./src/main/model/Player), having a field for Room1 is unnecessary and increases coupling. The location of the player could be initialized in Menu instead. So, the **Room1** field has been removed from Player and the location is instead initialized in Menu.

2) Having the getSpecificItem() and getSpecificRoom() methods in the Reader class in the persistence package (./src/main/persistence/Reader) reduced cohesion as the methods were not directly related to the function being performed by the class. It also increased coupling as the methods needed instances of Room1, Room2, and Room3, and also needed fields from these classes. In this change, I've moved these methods to Main and have an instance of Main in Reader to perform the same function. This way, there is less coupling between the classes and Reader is more cohesive as all the methods in it now directly relate to its intended function.

