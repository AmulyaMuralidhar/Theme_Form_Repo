package com.theme.data.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.theme.data.model.Form;


public interface FormRepository extends MongoRepository<Form, String> {
    Form findByFormName(String formName);
}
