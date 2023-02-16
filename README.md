<!-- BACK TO TOP -->
<a name="readme-top"></a>

<!-- TITLE AND OVERVIEW -->
# Labyrinth Game

This is a 2D game created using Java Swing. The game features a player that can move using the arrow keys, and obstacles that the player cannot cross.

<!-- TABLE OF CONTENTS -->
<details>
  <summary><h3>Table of Contents<h3></summary>
  <ol>
    <li>
      <a href="#about">About</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#setup">Setup</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#license">License</a></li>
  </ol>
</details>

## About

This is a 2D game created using Java Swing. The game features a player that can move using the arrow keys, and obstacles that the player cannot cross. The player must navigate through the obstacles to reach the end of the level. The game uses a custom `GameComponent` class to manage the game state and draw the graphics, and a `Player` class to manage the player's movement and collision detection.

The `GameComponent` class uses `BufferedImage` to load and draw textures for the obstacles. The `Box` class extends Rectangle and holds a reference to its texture, which is a `BufferedImage`. The `GameComponent` class creates instances of the `Box` class to generate the obstacles for the level. The `GameComponent` class also has a draw method that draws the player and obstacles onto the screen.

The `Player` class handles keyboard events for moving the player, and collision detection with the obstacles. The `Player` class also has a `draw` method that draws the player onto the screen.

This project is intended as an educational resource for learning about game development in Java. It demonstrates how to use Java Swing to create a 2D game, and covers topics such as collision detection, keyboard input, and level design.


### Screenshots

![image](https://user-images.githubusercontent.com/101121453/219332087-972af9bd-27fb-458a-8317-15ab53af0a75.png)

### Built With

- Java Swing
- Java 2D Graphics
- BufferedImage

<!-- GETTING STARTED -->
## Setup

To run the game, you will need to have Java installed on your computer. 

### Prerequisites

- Java Development Kit (JDK) version 8 or later
- Download source code or pre-compiled JAR file from the GitHub repository

### Run

Run the game using pre-compiled JAR file.
In the project directory run following command:
```
java -jar ./dist/java-labyrinth-game.jar
```

<!-- LICENSE -->
## License

Distributed under the MIT License. See [LICESNE](LICENSE) for more information.

<!-- BACK TO TOP -->
<p><a href="#readme-top">↑ back to top</a></p>
