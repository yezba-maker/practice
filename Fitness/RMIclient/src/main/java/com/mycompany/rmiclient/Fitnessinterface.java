
package com.mycompany.rmiclient;
  import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
public class Fitnessinterface {
public interface FitnessService extends Remote {
    String getPlan() throws RemoteException;
    void addRecord(String user, String date, int steps, double weight) throws RemoteException;

    List<String> getRecords(String user) throws RemoteException;

    double getAverageSteps(String user) throws RemoteException;

    double getLatestWeight(String user) throws RemoteException;
}
}
