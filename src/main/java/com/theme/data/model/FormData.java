package com.theme.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "FormDataModel")
public class FormData {
    @Id
    private String id; // Primary Key
    @NotBlank(message = "Form Id cannot not be empty")
    private String formId; // Foreign Key
    @NotBlank(message = "Form Name cannot not be empty")
    private String formName;
    private Object formData;
    private Date date;
    private Date modifiedDate;

    public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public Object getFormData() {
		return formData;
	}

	public void setFormData(Object formData) {
		this.formData = formData;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	// Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

	public FormData(String id, @NotBlank(message = "Form Id cannot not be empty") String formId,
			@NotBlank(message = "Form Name cannot not be empty") String formName, Object formData, Date date,
			Date modifiedDate) {
		super();
		this.id = id;
		this.formId = formId;
		this.formName = formName;
		this.formData = formData;
		this.date = date;
		this.modifiedDate = modifiedDate;
	}
    
}
