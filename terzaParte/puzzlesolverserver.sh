#!bin/bash

	killall rmiregistry
	rmiregistry& java server/PuzzleSolverServer $1
	killall rmiregistry
