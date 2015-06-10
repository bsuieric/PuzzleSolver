PuzzleSolver: project

project: shared server client

shared: Puzzle.class Tile.class SolverAlgorithm.class

server: PuzzleToSolve.class PuzzleSolverServer.class

client: IOReader.class IOWriter.class PuzzleSolverClient.class

clean:
	rm -f shared/*.class
	rm -f client/*.class
	rm -f server/*.class



# shared package

Puzzle.class:
	javac shared/Puzzle.java

Tile.class:
	javac shared/Tile.java

SolverAlgorithm.class:
	javac shared/SolverAlgorithm.java


# server package

PuzzleToSolve.class:
	javac server/PuzzleToSolve.java

PuzzleSolverServer.class:
	javac server/PuzzleSolverServer.java



# client package

IOReader.class: 
	javac client/IOReader.java

IOWriter.class: 
	javac client/IOWriter.java

PuzzleSolverClient.class: 
	javac client/PuzzleSolverClient.java
