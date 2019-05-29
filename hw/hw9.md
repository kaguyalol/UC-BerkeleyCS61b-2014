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
  * _How would your algorithm ensure that there is a path between every pair of
     cells, but no more than one path between any pair of cells (i.e., no
     cycles)?_
     ```
     All walls will be initialized as true, and all cells will be traversed to check whether 
     need to unblock the wall.
     dfs will ensures there is no loop existing.
     ```
  * _How does your algorithm use random numbers to generate a different maze
     each time?  Specifically, what decision should be made by random numbers
     at each recursive invocation of the depth-first search method?_
     ```
     By generating a random number for determining the direction of traverse,
     then invoking dfs method randomly
     ```
  **Algorithm**
   ```
   1. Randomly choose start cell
   2. Randomly permutate the sequence of available directions
   3. Invoke dfs method towards each direction recursively
    3.1. Check whether out of bound or the next cell is unvisited
      3.1.1 Mark the cell as visited 
      3.1.2 Block the wall
   ```
