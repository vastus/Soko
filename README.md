# Sokoban &mdash; Joululabra
> Sokoban is a type of transport puzzle, in which the player pushes boxes or 
> crates around in a warehouse, trying to get them to storage locations.

Source: [wikipedia/Sokoban](http://en.wikipedia.org/wiki/Sokoban).

## Testing
Test coverage has been generated using [Cobertura](http://cobertura.github.io/cobertura/)
and mutation test reports by [PIT](http://pitest.org/). These can be found in the documentation
folder.


## Design
This is a rough draft of the design in a class diagram. The idea is to have
different elements (player, boxes, walls etc) in a level; elements can be
static (by default) or movable.

[![Sokoban UML Class Diagram](http://www.yuml.me/34c0ff36)](http://www.yuml.me/edit/34c0ff36)

Initial class diagram of the game design.

