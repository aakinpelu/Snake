Akinniyi Akinpelu
CSC 171 - MW 12:30 Lab
TA: Yumeng Liu
Project 3

In this assignment I created a Snake program. First, apple classes were created to
make the apples the snake would consume. The classes just defined the dimensions of
the apples and painted them. The SnakeBuild class creates the dimensions of a snake
block and paints it. The SnakeGraphics class is where most of the program is. It
employs the MVC design pattern to separate the clases into distinct categories. The
model contains the apple classes, the controller contains the graphics class
(explained below), which takes input from the apples and modifies the view, and the
view contains the GUI, which creates a frame and paints the game using info from the
model and controller. I also used a Singleton pattern for no particular reason. The
class also builds the snake using the SnakeBuild class and creates and places apples
randomly in the grid. It contains methods to start the program immediately and stop
it whenever the rules are violated. It also contains a key listener to allow
movement of the worm with the arrow keys. Finally, the SnakeGUI class places the
game in the JFrame.

The rule change I made was to introduce bad apples into the game. If the snake eats
a bad apple, the game automatically ends. The twist is that every time a normal
apple is consumed, an additional bad apple appears. I do allow for the snake to
travel through itself, so traversing the grid is somewhat easier.

Tests were done using JUnit, and cannot be run from the command line. I tested all
of the methods in each class to ensure they were functional, by creating an instance
of the class and using the methods on it.

You can run this code by going to command line and entering cd desktop/project3/src/,
then to compile the files enter javac snake/gui/SnakeGUI.java and to run the code,
enter java snake.gui.SnakeGUI. Image does not show when run from command line for
some reason.

The game begins immediately and you use the keyboard arrows to navigate around the
map. Eating red apples increases the length of the snake and causes another red
apple to randomly appear. A black apple is spawned at the beginning of the game and
continue to appear after each red apple is eaten. Eating the black apple, or
running into the walls causes the game to end, and you lose is shown at the bottom.
If you manage to win, the game ends automatically.