package com.theme.data.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.theme.data.model.Form;
import com.theme.data.repository.FormRepository;
import com.theme.data.service.FormService;
import java.util.List;

@RestController
@RequestMapping("/forms")
public class FormController {
    @Autowired
    private FormService formService;
    
    @Autowired
    FormRepository formRepository;
    

    @GetMapping
    public ResponseEntity<List<Form>> getAllForms() {
        return ResponseEntity.ok(formService.getAllForms());
    }
    
    @GetMapping("/form/{formId}")
    public ResponseEntity<Form> getFormById(@PathVariable String formId) {
        return ResponseEntity.ok(formService.getFormById(formId));
    }
    
    @PostMapping("/form/save")
    public ResponseEntity<Form> createForm(@RequestBody Form form) {
        return ResponseEntity.ok(formService.createForm(form));
    }

    @PutMapping("/form/update/{formId}")
    public ResponseEntity<Form> updateForm(@PathVariable String formId, @RequestBody Form form) {
        form.setFormId(formId);
        return ResponseEntity.ok(formService.updateForm(form));
    }

    @DeleteMapping("/form/{formId}")
    public ResponseEntity<Void> deleteForm(@PathVariable String formId) {
        formService.deleteForm(formId);
        return ResponseEntity.noContent().build();
    }

    
    @GetMapping("/{formName}")
    public ResponseEntity<Form> getFormsByName(@RequestParam String formName) {
        return ResponseEntity.ok(formService.getFormByName(formName));
    }
    
    @DeleteMapping("/search")
    public ResponseEntity<Void> deleteFormsByName(@RequestParam String formName) {
        formService.deleteForm(formName);
        return ResponseEntity.noContent().build();
    }
  

}
