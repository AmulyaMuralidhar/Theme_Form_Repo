package com.theme.data.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.theme.data.model.Client;

public interface ClientRepository extends MongoRepository<Client, String> {

	Client findByClientId(String clientId);
}

