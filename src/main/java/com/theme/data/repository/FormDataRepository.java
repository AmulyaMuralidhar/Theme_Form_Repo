package com.theme.data.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.theme.data.model.FormData;

public interface FormDataRepository extends MongoRepository<FormData, String> {
	
    FormData findByFormId(String formId);
	
}
