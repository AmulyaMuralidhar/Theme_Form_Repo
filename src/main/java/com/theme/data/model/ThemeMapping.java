package com.theme.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

@Data
@Document(collection = "ThemeMappingSchema")
public class ThemeMapping {
    @Id
    private String id;
    @NotBlank(message = "FormId cannot not be empty")
    private String formId; // Object to save column data in JSON format
    @NotBlank(message = "ThemeId cannot not be empty")
    private String themeId;
    private Date createStamp = new Date();
    private Date modifyStamp = new Date();
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
	public String getThemeId() {
		return themeId;
	}
	public void setThemeId(String themeId) {
		this.themeId = themeId;
	}
	public Date getCreateStamp() {
		return createStamp;
	}
	public void setCreateStamp(Date createStamp) {
		this.createStamp = createStamp;
	}
	public Date getModifyStamp() {
		return modifyStamp;
	}
	public void setModifyStamp(Date modifyStamp) {
		this.modifyStamp = modifyStamp;
	}

	public ThemeMapping() {
		// TODO Auto-generated constructor stub
	}
    
    
}
