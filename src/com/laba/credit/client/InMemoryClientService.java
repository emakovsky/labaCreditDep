package com.laba.credit.client;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class InMemoryClientService implements ClientService {
    private Set<Client> clients = new HashSet<Client>();

    @Override
    public void saveClient(Client client) {
        clients.add(client);
    }

    @Override
    public boolean findDuplicate(Client client) {
        return false;
    }
}
