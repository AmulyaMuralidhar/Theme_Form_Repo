package com.theme.data.controller;

import com.theme.data.dto.FormDataDTO;
import com.theme.data.service.FormDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/form/data")
public class FormDataController {

    @Autowired
    private FormDataService formDataService;

    @GetMapping("/list")
    public ResponseEntity<List<FormDataDTO>> getAllFormData() {
        List<FormDataDTO> formDataList = formDataService.getAllFormData();
        return formDataList != null && !formDataList.isEmpty() ? new ResponseEntity<>(formDataList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{formId}")
    public ResponseEntity<FormDataDTO> getFormDataByFormId(@PathVariable String formId) {
        FormDataDTO formDataDTO = formDataService.getFormDataByFormId(formId);
        return new ResponseEntity<>(formDataDTO, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<FormDataDTO> createFormData(@Valid @RequestBody FormDataDTO formDataDTO) {
        FormDataDTO createdFormData = formDataService.createFormData(formDataDTO);
        return new ResponseEntity<>(createdFormData, HttpStatus.CREATED);
    }

    @PutMapping("/{formId}")
    public ResponseEntity<FormDataDTO> updateFormData(@PathVariable String formId, @Valid @RequestBody FormDataDTO formDataDTO) {
        FormDataDTO updatedFormData = formDataService.updateFormData(formId, formDataDTO);
        return new ResponseEntity<>(updatedFormData, HttpStatus.OK);
    }

}
