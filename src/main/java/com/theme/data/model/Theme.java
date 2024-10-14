package com.theme.data.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

	@Data
	@Document(collection = "ThemeSchema")
	public class Theme {
	    @Id
	    private String id;
	    @NotBlank(message = "Theme Id cannot not be empty")
	    private String themeId;
	    @NotBlank(message = "Theme Name cannot not be empty")
	    private String themeName;
	    @NotBlank(message = "Theme Data cannot not be empty")
	    private Object themeData; // Object to save column data in JSON format
	    private Date Date = new Date();
	    private Date modifyDate = new Date();
	    private String clientId;
	    
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getThemeName() {
			return themeName;
		}
		public void setThemeName(String themeName) {
			this.themeName = themeName;
		}
		public Object getThemeData() {
			return themeData;
		}
		public void setThemeData(Object themeData) {
			this.themeData = themeData;
		}
		public Date getCreateDate() {
			return Date;
		}
		public void setCreateDate(Date date) {
			this.Date = date;
		}
		public Date getModifyDate() {
			return modifyDate;
		}
		public void setModifyDate(Date modifyDate) {
			this.modifyDate = modifyDate;
		}

		public Date getDate() {
			return Date;
		}
		public void setDate(Date date) {
			Date = date;
		}
		public String getClientId() {
			return clientId;
		}
		public void setClientId(String clientId) {
			this.clientId = clientId;
		}
		
		public String getThemeId() {
			return themeId;
		}
		public void setThemeId(String themeId) {
			this.themeId = themeId;
		}
		public Theme() {
			// TODO Auto-generated constructor stub
		}

	}
