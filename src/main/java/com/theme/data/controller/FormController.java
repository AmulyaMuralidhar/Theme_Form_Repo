package com.theme.data.controller;

import com.theme.data.dto.FormDTO;
import com.theme.data.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/form")
public class FormController {

    @Autowired
    private FormService formService;

    @GetMapping("/forms")
    public ResponseEntity<List<FormDTO>> getAllForms() {
        List<FormDTO> forms = formService.getAllForms();
        return (forms != null && !forms.isEmpty())? new ResponseEntity<>(forms, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping("/save")
    public ResponseEntity<FormDTO> createForm(@Valid @RequestBody FormDTO formDTO) {
        FormDTO createdForm = formService.createForm(formDTO);
        return new ResponseEntity<>(createdForm, HttpStatus.CREATED);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<FormDTO> getFormByFormId(@PathVariable String Id) {
        FormDTO formDTO = formService.getFormByFormId(Id);
        return new ResponseEntity<>(formDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{formId}")
    public ResponseEntity<FormDTO> updateForm(@PathVariable String formId, @Valid @RequestBody FormDTO formDTO) {
        FormDTO updatedForm = formService.updateForm(formId, formDTO);
        return new ResponseEntity<>(updatedForm, HttpStatus.OK);
    }

}
