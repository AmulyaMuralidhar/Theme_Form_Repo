package com.theme.data.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.theme.data.model.FormData;
import java.util.List;

public interface FormDataRepository extends MongoRepository<FormData, String> {
    List<FormData> findByFormId(String formId);
}
