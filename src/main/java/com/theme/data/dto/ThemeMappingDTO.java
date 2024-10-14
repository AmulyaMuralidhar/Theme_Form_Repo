package com.theme.data.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThemeMappingDTO {
    private String id;
    private String formId;  // Foreign key from Form
    private String themeId; // Foreign key from Theme
    private Date createStamp;
    private Date modifyStamp;
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
	public ThemeMappingDTO() {

	}
	
   
}
