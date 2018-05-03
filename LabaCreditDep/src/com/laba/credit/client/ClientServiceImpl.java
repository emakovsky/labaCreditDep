package com.laba.credit.client;

import com.laba.credit.employee.Employee;
import com.laba.credit.util.SerializationUtils;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class ClientServiceImpl implements ClientService {
    private static final String FILE = "SerializedClients.dat";

    private HashSet<Client> clients = new HashSet<Client>();

    public ClientServiceImpl() {
        Object restored = new SerializationUtils().restoreObjectFromFile(FILE);
        if (restored != null && restored instanceof HashSet) {
            clients = (HashSet<Client>) restored;
            System.out.println("restored clients: " + clients.size());
        }
    }

    @Override
    public void saveClient(Client client) {
        clients.add(client);
        persist();
    }

    @Override
    public boolean findDuplicate(Client client) {
        return false;
    }

    @Override
    public Client findByName(String name) {
        for (Client client : clients) {
            if (client.getName().equalsIgnoreCase(name)) {
                return client;
            }
        }
        return null;
    }

    private void persist() {
        new SerializationUtils().saveObjectToFile(FILE, clients);
        System.out.println("saved: " + clients.size());
    }
}
