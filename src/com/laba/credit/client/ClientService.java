package com.laba.credit.client;

/**
 *
 */
public interface ClientService {

     void saveClient(Client client);

     boolean findDuplicate(Client client);
}
