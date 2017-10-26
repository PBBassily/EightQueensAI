# EightQueensAI
Eight Queens Game solver using Hill Climbing algorithm and some of its variations : 

  1) Naive HillClimber (10%-15% accuracy)
  2) Sideways HillClimber (20%-30% accuracy)
  3) Random Restart HillClimber (40%-65% accuracy)
  4) K-Means HillClimber (80%-95% accuracy)
  
### Board 
Is the wrapper class of the chess boards , every object has useful functions and variables 
ex: numAttacks & calaculateAttacks() & randomize

### HillClimbing 
Abstract class contains the common features and behaviuor between the HillClimbers variations, & extended by the them 

## Usage 
run every HillClimber individually, and maniuplate the varibales of each climber to see the statistics beyond it 

