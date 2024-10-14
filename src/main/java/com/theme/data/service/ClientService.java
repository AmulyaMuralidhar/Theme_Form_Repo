package com.theme.data.service;

import com.theme.data.dto.ClientDTO;
import com.theme.data.exception.ClientCustomException;
import com.theme.data.model.Client;
import com.theme.data.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    public ClientDTO getClientById(String clientId) {
        Client client = clientRepository.findByClientId(clientId);
        if (client == null) {
            throw new ClientCustomException("Client with ID " + clientId + " not found");
        }
        return convertToDTO(client);
    }

    public ClientDTO createClient(ClientDTO clientDTO) {
        if (clientRepository.findByClientId(clientDTO.getClientId()) != null) {
            throw new ClientCustomException("Client with ID " + clientDTO.getClientId() + " already exists");
        }

        Client client = new Client();
        client.setClientId(clientDTO.getClientId());
        client.setClientName(clientDTO.getClientName());
        client.setClientCreateDate(Instant.now());
        client.setFormIds(clientDTO.getFormIds());
        client = clientRepository.save(client);
        return convertToDTO(client);
    }

    public ClientDTO updateClient(String clientId, ClientDTO clientDTO) {
        Client existingClient = clientRepository.findByClientId(clientId);
        if (existingClient == null) {
            throw new ClientCustomException("Client with ID " + clientId + " not found");
        }
        existingClient.setClientName(clientDTO.getClientName());
        existingClient.setFormIds(clientDTO.getFormIds());
        existingClient.setClientModifiedDate(Instant.now());
        existingClient = clientRepository.save(existingClient);
        return convertToDTO(existingClient);
    }

    public void deleteClient(String clientId) {
        Client existingClient = clientRepository.findByClientId(clientId);
        if (existingClient == null) {
            throw new ClientCustomException("Client with ID " + clientId + " not found");
        }
        clientRepository.delete(existingClient);
    }

    private ClientDTO convertToDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setClientId(client.getClientId());
        dto.setClientName(client.getClientName());
        dto.setClientCreateDate(client.getClientCreateDate());
        dto.setClientModifiedDate(client.getClientModifiedDate());
        dto.setFormIds(client.getFormIds());
        return dto;
    }
}
