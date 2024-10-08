package com.theme.data.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.theme.data.model.Client;

public interface ClientRepository extends MongoRepository<Client, String> {

	 List<Client> findByClientName(String clientName); // Method to find clients by name
}

