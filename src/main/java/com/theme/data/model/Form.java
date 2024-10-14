package com.theme.data.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;

@Document(collection = "FormSchema")
public class Form {
    @Id
    @NotBlank(message = "Form ID cannot not be empty")
    private String formId; // Primary Key
    @NotBlank(message = "Form Name cannot not be empty")
    private String formName;
    private Object formSchema;
    private Date date;
    private Date modifiedDate;
    private String clientId;
    
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	// Getters and Setters
    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public Object getFormSchema() {
		return formSchema;
	}

	public void setFormSchema(Object formSchema) {
		this.formSchema = formSchema;
	}

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}
    
    
}
