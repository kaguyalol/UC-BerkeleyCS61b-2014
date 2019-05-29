- Part I
  ```shell
  $ java Maze 5 6
  -----------
  |         |
  + +-+-+-+ +
  |     |   |
  + + + + +-+
  | | | | | |
  +-+-+-+ + +
  | |     | |
  + +-+-+ + +
  |   |     |
  + +-+ +-+ +
  |     |   |
  +----------
  What a fine maze you've created!
  ```

- Part II
  * How would your algorithm ensure that there is a path between every pair of
     cells, but no more than one path between any pair of cells (i.e., no
     cycles)?
     ```
     If the cell has not been visited, then set the value of the wall to false, 
     and maintaining an array to record the visit status of all cells, if the cell
     has been visited, then there is a cycle in the path, then go back to block 
     all walls between source cell and destination cell
     ```
  * How does your algorithm use random numbers to generate a different maze
     each time?  Specifically, what decision should be made by random numbers
     at each recursive invocation of the depth-first search method?
     ```
     ```
