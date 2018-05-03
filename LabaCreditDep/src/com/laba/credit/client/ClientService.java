package com.laba.credit.client;

import com.laba.credit.employee.Employee;

/**
 *
 */
public interface ClientService {

     void saveClient(Client client);

     boolean findDuplicate(Client client);

     Client findByName(String name);
}
