package com.theme.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "themeMapping")
public class ThemeMapping {
    @Id
    private String id;
    private Object formId; // Object to save column data in JSON format
    private String themeId;
    private Date createStamp = new Date();
    private Date modifyStamp = new Date();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Object getFormId() {
		return formId;
	}
	public void setFormId(Object formId) {
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
	@Override
	public String toString() {
		return "ThemeMapping [id=" + id + ", formId=" + formId + ", themeId=" + themeId + ", createStamp=" + createStamp
				+ ", modifyStamp=" + modifyStamp + "]";
	}
	public ThemeMapping(String id, Object formId, String themeId, Date createStamp, Date modifyStamp) {
		super();
		this.id = id;
		this.formId = formId;
		this.themeId = themeId;
		this.createStamp = createStamp;
		this.modifyStamp = modifyStamp;
	}
    
    
}
