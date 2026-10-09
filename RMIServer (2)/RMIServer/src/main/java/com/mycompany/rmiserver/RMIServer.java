

package com.mycompany.rmiserver;

 import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
public class RMIServer {

    public static void main(String[] args) { try {
            // Set hostname (make sure this IP is correct and reachable)
            System.setProperty("java.rmi.server.hostname", "172.16.82.112");
            // Create RMI registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            // Bind service to registry
            registry.rebind("FitnessService",new FitnessIMp());
            System.out.println("Fitness RMI Server is running...");
        } catch (RemoteException e) {
            System.err.println("RMI Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("General Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    }

