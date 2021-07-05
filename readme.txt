# Stickman

## How to Run
To run the program, go to the root of the folder and type the command `gradle run` in the terminal. 
The game window will pop up.
When touched by the slime, the stickman will lose a life. There are 3 lives in the beginning 
of each level. When touching the flag, you win the game and the game will exit.

## JSON Format
You can configure many things of the game, but a special format is required.
The JSON files are placed in `src/main/resources/`.
The JSON file should contain the following attributes: 
settings, stickman, cloud1, enemy1, enemy2, platformHeight, platformWidth, platform1,
platform2, platform3, flag, mushroom.
You can set the numerical values to different number.
The size of the stickman `stickmanSize` can be changed to normal, large or small.
The movement ways of the enemy `enemyMove` can be changed to noMovement, rightToLeft or leftToRight.
An example json file is attached below.


## Configuration Files
There are two JSON files by now, one is "level1.json" and the other is "level2.json".

## To Load Different Levels
To load a different level, please move to the GameEngineImpl class in the model package.
At the 10th line of the code, you will see 
`URL url = Thread.currentThread().getContextClassLoader().getResource("level1.json");`.
Pleases change  "level1.json" to "level2.json".
Then use `gradle run`, a new level will be loaded.

## Keys
To move the stickman, press arrow keys `left` and `right` to control stickman's direction.
Press arrow key `up` to jump. After touching the mushroom in the game, the stickman can shoot
bullets by pressing `space` key.




`EXAMPLE JSON File`

{
  "setting": {
    "height": 1000,
    "width": 500,
    "floorHeight": 300
  },
  "stickman": {
    "x": 20.0,
    "stickmanSize": "normal"
  },

"cloud1": {
  "cloudVelocity": 0.1,
  "cloudX": 30,
  "cloudY": 60,
  "cloudHeight": 10,
  "cloudWidth": 40
},

  "enemy1": {
    "enemyVelocity": 0.5,
    "enemyX": 100,
    "enemyY": 300,
    "enemyHeight": 17,
    "enemyWidth": 23 ,
    "enemyColor": "red",
    "enemyMove": "noMovement"
  },
  "enemy2": {
    "enemyVelocity": 0.3,
    "enemyX": 300,
    "enemyY": 300,
    "enemyHeight": 17,
    "enemyWidth": 23 ,
    "enemyColor": "blue",
    "enemyMove": "rightToLeft"
  },

  "platformHeight": 9,
  "platformWidth": 80,
  "platform1": {
      "x": 100,
      "y": 240
  },
  "platform2": {
    "x": 260,
    "y": 240
  },
  "platform3": {
    "x": 310,
    "y": 150
  },

  "flag": {
    "x": 355,
    "y": 127,
    "Height": 24,
    "Width":48
  },

  "mushroom": {
    "x": 260,
    "y": 200,
    "Height": 22.5,
    "Width": 28
  }
}