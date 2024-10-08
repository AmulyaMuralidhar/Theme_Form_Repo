package com.theme.data.service;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theme.data.model.FormData;
import com.theme.data.repository.FormDataRepository;

@Service
public class FormDataService {
    @Autowired
    private FormDataRepository formDataRepository;

    public FormData createFormData(FormData formData) {
        return formDataRepository.save(formData);
    }

    public List<FormData> getAllFormData() {
        return formDataRepository.findAll();
    }
    
    public List<FormData> getFormDataByFormId(String formId) {
        return formDataRepository.findByFormId(formId);
    }

    public FormData updateFormData(FormData formData) {
        formData.setModifiedDate(new Date()); // Update modified date
        formData.setDate(new java.util.Date());
        return formDataRepository.save(formData);
    }

    public void deleteFormData(String id) {
        formDataRepository.deleteById(id);
    }
}
