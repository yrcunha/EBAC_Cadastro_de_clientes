package br.com.yrcunha.dao;

import br.com.yrcunha.domain.Client;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClientMapDao implements ClientDao {
    private final Map<String, Client> mapping;

    public ClientMapDao() {
        this.mapping = new HashMap<>();
    }

    @Override
    public boolean create(Client client) {
        if (this.mapping.containsKey(client.getDocument())) return false;
        this.mapping.put(client.getDocument(), client);
        return true;
    }

    @Override
    public boolean delete(String document) {
        Client found = this.mapping.get(document);
        if (found != null) {
            this.mapping.remove(found.getDocument(), found);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Client client) {
        Client found = this.mapping.get(client.getDocument());
        if (found != null) {
            found.setName(client.getName());
            found.setDocument(client.getDocument());
            found.setPhone(client.getPhone());
            found.setAddress(client.getAddress());
            found.setHouseNumber(client.getHouseNumber());
            found.setCity(client.getCity());
            found.setState(client.getState());
            return true;
        }
        return false;
    }

    @Override
    public Client finByDocument(String document) {
        return this.mapping.get(document);
    }

    @Override
    public Collection<Client> find() {
        return this.mapping.values();
    }
}
