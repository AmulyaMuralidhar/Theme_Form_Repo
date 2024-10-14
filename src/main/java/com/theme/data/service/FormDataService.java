package com.theme.data.service;

import com.theme.data.dto.FormDataDTO;
import com.theme.data.exception.FormCustomException;
import com.theme.data.model.FormData;
import com.theme.data.repository.FormDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FormDataService {

    @Autowired
    private FormDataRepository formDataRepository;

    public List<FormDataDTO> getAllFormData() {
        return formDataRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    public FormDataDTO getFormDataByFormId(String formId) {
        FormData formData = formDataRepository.findByFormId(formId);
        if (formData == null) {
            throw new FormCustomException("Form with ID " + formId + " not found");
        }
        return convertToDTO(formData);
    }

    public FormDataDTO createFormData(FormDataDTO formDataDTO) {
        if (formDataRepository.findByFormId(formDataDTO.getFormId()) != null) {
            throw new FormCustomException("Form with ID " + formDataDTO.getFormId() + " already exists");
        }

        FormData formData = new FormData();
        formData.setFormId(formDataDTO.getFormId());
        formData.setFormName(formDataDTO.getFormName());
        formData.setFormData(formDataDTO.getFormData());
        formData.setDate(new Date());
        formData.setModifiedDate(new Date());
        formData.setClientId(formDataDTO.getClientId());
        formData = formDataRepository.save(formData);
        return convertToDTO(formData);
    }

    public FormDataDTO updateFormData(String formId, FormDataDTO formDataDTO) {
        FormData existingFormData = formDataRepository.findByFormId(formId);
        if (existingFormData == null) {
            throw new FormCustomException("Form with ID " + formId + " not found");
        }
        existingFormData.setFormName(formDataDTO.getFormName());
        existingFormData.setFormData(formDataDTO.getFormData());
        existingFormData.setModifiedDate(new Date());
        existingFormData.setClientId(formDataDTO.getClientId());
        existingFormData = formDataRepository.save(existingFormData);
        return convertToDTO(existingFormData);
    }

    public void deleteFormData(String formId) {
        FormData existingFormData = formDataRepository.findByFormId(formId);
        if (existingFormData == null) {
            throw new FormCustomException("Form with ID " + formId + " not found");
        }
        formDataRepository.delete(existingFormData);
    }

    private FormDataDTO convertToDTO(FormData formData) {
        FormDataDTO dto = new FormDataDTO();
        dto.setFormId(formData.getFormId());
        dto.setFormName(formData.getFormName());
        dto.setFormData(formData.getFormData());
        dto.setDate(formData.getDate());
        dto.setModifiedDate(formData.getModifiedDate());
        dto.setClientId(formData.getClientId());
        return dto;
    }
}
