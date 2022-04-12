# Colossal Cave Adventure

A recreation of the 1976 text adventure game: Colossal Cave Adventure, written in Java


## Information

When given given the list of directions for your current location, i.e:

```
YOU ARE AT ONE END OF AN IMMENSE NORTH/SOUTH PASSAGE.
Available exits are Q, S, W,
```

The program will recognise, for this example, the inputs _Q, S, W_ when typed in on their own as well as also recognising _Quit, South, West_ (in any text case) when cluttered with other text (the final valid direction will be used) i.e

```
YOU ARE AT ONE END OF AN IMMENSE NORTH/SOUTH PASSAGE.
Available exits are Q, S, W, 
>> I want to go west
YOU ARE IN A MAZE OF TWISTY LITTLE PASSAGES, ALL DIFFERENT.
Available exits are Q, S, SW, NE, SE, U, NW, E, W, N, D, 
```

```
YOU ARE AT ONE END OF AN IMMENSE NORTH/SOUTH PASSAGE.
Available exits are Q, S, W, 
>> I want to try going east
You cannot go in that direction
YOU ARE AT ONE END OF AN IMMENSE NORTH/SOUTH PASSAGE.
Available exits are Q, S, W, 
```

```
YOU ARE AT ONE END OF AN IMMENSE NORTH/SOUTH PASSAGE.
Available exits are Q, S, W, 
>> I want to quit this game
YOU ARE SITTING IN FRONT OF A COMPUTER LEARNING JAVA.

Process finished with exit code 0
```

All the available locations (with description) are in _locations.txt_ and all the directions to another location for each location is in _directions.txt_

The recognised vocabulary can be found the _vocabulary_ hash map in _Mapping.Java_
