package com.theme.data.service;

import com.theme.data.dto.FormDTO;
import com.theme.data.exception.FormCustomException;
import com.theme.data.model.Form;
import com.theme.data.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;

    public List<FormDTO> getAllForms() {
        return formRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    public FormDTO getFormByFormId(String formId) {
        Form form = formRepository.findByFormId(formId);
        if (form == null) {
            throw new FormCustomException("Form with ID " + formId + " not found");
        }
        return convertToDTO(form);
    }

    public FormDTO createForm(FormDTO formDTO) {
        if (formRepository.existsById(formDTO.getFormId())) {
            throw new FormCustomException("Form with ID " + formDTO.getFormId() + " already exists");
        }

        Form form = new Form();
        form.setFormId(formDTO.getFormId());
        form.setFormName(formDTO.getFormName());
        form.setFormSchema(formDTO.getFormSchema());
        form.setDate(new Date());
        form.setModifiedDate(new Date());
        form.setClientId(formDTO.getClientId());
        form = formRepository.save(form);
        return convertToDTO(form);
    }

    public FormDTO updateForm(String formId, FormDTO formDTO) {
        Form existingForm = formRepository.findById(formId)
                .orElseThrow(() -> new FormCustomException("Form with ID " + formId + " not found"));
        existingForm.setFormName(formDTO.getFormName());
        existingForm.setFormSchema(formDTO.getFormSchema());
        existingForm.setModifiedDate(new Date());
        existingForm.setClientId(formDTO.getClientId());
        existingForm = formRepository.save(existingForm);
        return convertToDTO(existingForm);
    }

    private FormDTO convertToDTO(Form form) {
        FormDTO dto = new FormDTO();
        dto.setFormId(form.getFormId());
        dto.setFormName(form.getFormName());
        dto.setFormSchema(form.getFormSchema());
        dto.setDate(form.getDate());
        dto.setModifiedDate(form.getModifiedDate());
        dto.setClientId(form.getClientId());
        return dto;
    }
}
