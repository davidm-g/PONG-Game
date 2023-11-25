# Java Pong Game

## Description
For this project, our group decided to make a spin-off of the classic and revolutionary Pong, made by Atari in 1972.
We decided on this game because although it is simple, allowing us to focus on following good object-oriented design practices,
with close attention to the use of appropriate design patterns and complete testing, it also is different from previous projects and exercises we have done,
in the sense that we need to implement some features that were not formerly explored in our lectures, like the physics of the ball.
## List Of Features
For this project we are aiming to use five Design Patterns:
### Game Loop Pattern
The game loop pattern is essentially a loop that repeats at a consistent rate, ensuring that the game progresses smoothly over time. For our work, this pattern will be implemented in the "State" class, and with each iteration the position of the paddles, ball, and potentially the score of the game will all be updated.  
### State Pattern
This pattern is set to be implemented for the Game and Menu states. Resorting to the State class, we will be able to change between the aforementioned Game and Menu states in run-time. Initially we start in the MenuState then, when we start a new game of pong, we switch to the GameState and when the game ends we go back to MenuState again, changing the State behavior each time.
### Factory Method Pattern
Because the State class wants the subclasses(GameState and MenuState) to specify the Controller and Viewer objects it creates, we will implement the Factory Method Pattern to make this happen.
### Model-View-Controller
In order to deal with the architectural style of the software, we need to resort to this architectural pattern as a means to develop our user interfaces in a way that divides our project in three parts:
  #### Model
The model only represents the data of the classes that will be displayed.
  #### View
The view displays in the screen the data that is given to us from the model, and also sends the user inputs to the Controller.
  #### Controller
The controller modifies the data from the Model based on the user inputs given by the View.
### Strategy Pattern
We needed to find a way to make the ElementViewer class have different behaviors, depending on the Element object to view. To sort this out, we are bound to implement the Strategy Pattern.
## Pattern Consequences
 By implementing the patterns mentioned before, our code is bound to be built different.
 ### Positive Consequences
 Design Patterns offered many benefits in regard to our project design. For example, due to the use of Strategy Pattern, flexibility and extensibility is promoted since we are separating the draw() algorithms belonging to the different implementations of ElementViewer. The MVC Pattern, on the other hand, promotes reusability, as it makes it easier to scale and reuse components independently. For instance, you can have multiple views for the same model. Another benefit of using these patterns would be the ability to make clean state transitions between GameState and MenuState with the principles of the State Pattern. 
 ### Negative Consequences
 Because not everything is perfect, we have also came up with some situations where Design Patterns have given us headaches. We have found that some Design Patterns make the code more challenging to navigate, due to the increased number of classes. The learning curve to these concepts is also quite present, as we took some time to get familiarized with all of them. Despite these and some more minor setbacks, we have every reason to support the implementation of the aforementioned Design Patterns.

## Mockup
![Pong Game Mockup](Mockup.png)
## UML Diagram
![UML Diagram](UML_Diagram.png)

