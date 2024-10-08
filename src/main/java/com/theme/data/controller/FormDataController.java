package com.theme.data.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.theme.data.model.FormData;
import com.theme.data.service.FormDataService;
import java.util.List;

@RestController
@RequestMapping("/form-data")
public class FormDataController {
    @Autowired
    private FormDataService formDataService;

    @GetMapping("/forms/data/list")
    public ResponseEntity<List<FormData>> getAllFormData() {
        return ResponseEntity.ok(formDataService.getAllFormData());
    }
    
    @PostMapping("/form/data/save")
    public ResponseEntity<FormData> createFormData(@RequestBody FormData formData) {
        return ResponseEntity.ok(formDataService.createFormData(formData));
    }

    @GetMapping("/form/data/{formId}")
    public ResponseEntity<List<FormData>> getFormDataByFormId(@PathVariable String formId) {
        return ResponseEntity.ok(formDataService.getFormDataByFormId(formId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormData> updateFormData(@PathVariable String id, @RequestBody FormData formData) {
        formData.setId(id);
        return ResponseEntity.ok(formDataService.updateFormData(formData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormData(@PathVariable String id) {
        formDataService.deleteFormData(id);
        return ResponseEntity.noContent().build();
    }
}
