package shared;
import java.rmi.*;

public interface SolverAlgorithm extends Remote{
	public Puzzle solve(Puzzle p)throws RemoteException;
}
