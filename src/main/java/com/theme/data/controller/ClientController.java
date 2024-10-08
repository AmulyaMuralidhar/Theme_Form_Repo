package com.theme.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.theme.data.model.Client;
import com.theme.data.repository.ClientRepository;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        client.setClientCreateDate(Instant.now());
        client.setClientModifiedDate(Instant.now());
        return clientRepository.save(client);
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable String id) {
        return clientRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable String id, @RequestBody Client client) {
        client.setClientId(id);
        client.setClientModifiedDate(Instant.now());
        return clientRepository.save(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable String id) {
        clientRepository.deleteById(id);
    }
    
    @GetMapping("/name/{clientName}")
    public List<Client> getClientsByName(@PathVariable String clientName) {
        return clientRepository.findByClientName(clientName);
    }
    
    @PutMapping("/name/{clientName}")
    public Client updateClientByName(@PathVariable String clientName, @RequestBody Client updatedClient) {
        List<Client> clients = clientRepository.findByClientName(clientName);
        if (clients.isEmpty()) {
            return null; 
        }
        Client clientToUpdate = clients.get(0);
        clientToUpdate.setClientName(updatedClient.getClientName());
        clientToUpdate.setFormIds(updatedClient.getFormIds());
        clientToUpdate.setClientModifiedDate(Instant.now());
        
        return clientRepository.save(clientToUpdate);
    }
    
    @DeleteMapping("/name/{clientName}")
    public void deleteClientByName(@PathVariable String clientName) {
        List<Client> clients = clientRepository.findByClientName(clientName);

        if (clients.isEmpty()) {
            throw new RuntimeException("Client not found with name: " + clientName); 
        }

        for (Client client : clients) {
            clientRepository.deleteById(client.getClientId());
        }
    }
}