package br.com.yrcunha.dao;

import br.com.yrcunha.domain.Client;

import java.util.Collection;

public interface ClientDao {
    boolean create(Client client);

    boolean delete(String CPF);

    boolean update(Client client);

    Client finByDocument(String CPF);

    Collection<Client> find();
}
