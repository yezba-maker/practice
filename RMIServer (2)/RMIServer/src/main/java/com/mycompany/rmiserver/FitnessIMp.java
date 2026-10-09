
package com.mycompany.rmiserver;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.*;
public class FitnessIMp extends UnicastRemoteObject implements FitnessINTe {
    private Map<String, List<String>> records;
    protected FitnessIMp() throws RemoteException {
        super();
        records = new HashMap<>();
    }
    @Override
    public synchronized void addRecords(String user, String date, int steps, double weight) throws RemoteException {
        String record = date + " | Steps: " + steps + " | Weight: " + weight;

        records.putIfAbsent(user, new ArrayList<>());
        records.get(user).add(record);

        System.out.println("Added: " + record);
    }

    @Override
    public List<String> getRecords(String user) throws RemoteException {
        return records.getOrDefault(user, new ArrayList<>());
    }

   @Override
    public double getAverageSteps(String user) throws RemoteException {
        List<String> userRecords = records.get(user);
        if (userRecords == null || userRecords.isEmpty()) return 0;

        int total = 0;
        for (String r : userRecords) {
            String[] parts = r.split("\\|");
            String stepsPart = parts[1].trim().split(":")[1].trim();
            total += Integer.parseInt(stepsPart);
        }
        return (double) total / userRecords.size();
    }

    @Override
    public double getLatestWeight(String user) throws RemoteException {
        List<String> userRecords = records.get(user);
        if (userRecords == null || userRecords.isEmpty()) return 0;

        String last = userRecords.get(userRecords.size() - 1);
        String[] parts = last.split("\\|");
        String weightPart = parts[2].trim().split(":")[1].trim();

        return Double.parseDouble(weightPart);
    }
}


