package com.denis.store;



import com.denis.models.Client;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * Created by Denis on 09.11.2015.
 */
public class UserCache {

    private static UserCache uniqueInstance;

    private UserCache(){}

    private final ConcurrentHashMap<Integer, Client> clients = new ConcurrentHashMap<>();

    public static UserCache getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new UserCache();
        }
        return uniqueInstance;
    }

    public Collection<Client> values() {
        return this.clients.values();
    }

    public void addClient (final Client client){
        this.clients.put(client.getId(), client);
    }

    public void editClient(final Client client) {
        this.clients.replace(client.getId(), client);
    }

    public void deleteClient(final int id) {
        this.clients.remove(id);
    }

    public Client getClient(final int id) {
        return this.clients.get(id);
    }

}
