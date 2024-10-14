package com.theme.data.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.Date;

public class FormDataDTO {

    @NotBlank(message = "Form Id cannot be empty")
    private String formId;
    @NotBlank(message = "Form Name cannot be empty")
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
	public FormDataDTO() {
		
	}
    
    
}
