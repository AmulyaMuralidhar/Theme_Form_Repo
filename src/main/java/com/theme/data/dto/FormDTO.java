package com.theme.data.dto;

import java.util.Date;

public class FormDTO {
    private String formId;
    private String formName;
    private Object formSchema;
    private Date date;
    private Date modifiedDate;
    private String clientId;

    // Getters and Setters
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

    public Object getFormSchema() {
        return formSchema;
    }

    public void setFormSchema(Object formSchema) {
        this.formSchema = formSchema;
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
}
