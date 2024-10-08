package com.theme.data.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.theme.data.model.Form;
import com.theme.data.repository.FormRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class FormService {
    @Autowired
    private FormRepository formRepository;

    public Form createForm(Form form) {
        return formRepository.save(form);
    }

    public List<Form> getAllForms() {
        return formRepository.findAll();
    }

    public Form updateForm(Form form) {
        form.setModifiedDate(new Date()); // Update modified date
        return formRepository.save(form);
    }

    public void deleteForm(String formName) {
        formRepository.deleteById(formName);
    }

    public Form getFormById(String formId) {
        return formRepository.findById(formId).orElse(null);
    }

	public Form getFormByName(String formName) {
		// TODO Auto-generated method stub
        return formRepository.findByFormName(formName);

	}
}
