# Labyrinth Game

This is a 2D game created using Java Swing. The game features a player that can move using the arrow keys, and obstacles that the player cannot cross.

<!-- TABLE OF CONTENTS -->
<details>
  <summary><span>Table of Contents<span></summary>
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

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

This is an example of how to list things you need to use the software and how to install them.
* npm
  ```sh
  npm install npm@latest -g
  ```

### Installation

_Below is an example of how you can instruct your audience on installing and setting up your app. This template doesn't rely on any external dependencies or services._

1. Get a free API Key at [https://example.com](https://example.com)
2. Clone the repo
   ```sh
   git clone https://github.com/your_username_/Project-Name.git
   ```
3. Install NPM packages
   ```sh
   npm install
   ```
4. Enter your API in `config.js`
   ```js
   const API_KEY = 'ENTER YOUR API';
   ```

<!-- LICENSE -->
## License

Distributed under the MIT License. See [LICESNE](LICENSE) for more information.

<!-- BACK TO TOP -->
<p><a href="#readme-top">↑ back to top</a></p>
