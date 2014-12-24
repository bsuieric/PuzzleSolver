JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC)	$*.java

CLASSES = \
	puzzle/Puzzle.java \
	puzzle/Tile.java \
	puzzle/SolverAlgorithm.java\
	puzzle/PuzzleToSolve.java\
	puzzle/IOReader.java\
	puzzle/IOWriter.java\
	puzzle/PuzzleSolver.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
