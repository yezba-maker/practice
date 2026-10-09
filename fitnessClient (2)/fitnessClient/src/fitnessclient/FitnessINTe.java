
package fitnessclient;
 import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface FitnessINTe extends Remote {
     void addRecords(String user, String date, int steps, double weight) throws RemoteException;
    List<String> getRecords(String user) throws RemoteException;
    double getAverageSteps(String user) throws RemoteException;
    double getLatestWeight(String user) throws RemoteException;
}

