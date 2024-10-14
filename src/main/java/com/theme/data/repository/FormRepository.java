package com.theme.data.repository;

import com.theme.data.model.Form;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FormRepository extends MongoRepository<Form, String> {
    Form findByFormId(String formId);
}
