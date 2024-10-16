package com.theme.data.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;

@Document(collection = "FormDataModel")
public class FormData {
  
    @NotBlank(message = "Form Id cannot not be empty")
    private String formId; // Foreign Key
    @NotBlank(message = "Form Name cannot not be empty")
    private String formName;
    private Object formData;
    private Date date;
    private Date modifiedDate;
    private String clientId;
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
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
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public FormData() {

	}
}
