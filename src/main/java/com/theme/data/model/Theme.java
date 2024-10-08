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
	    @NotBlank(message = "Theme Name cannot not be empty")
	    private String themeName;
	    @NotBlank(message = "Theme Data cannot not be empty")
	    private Object themeData; // Object to save column data in JSON format
	    private Date Date = new Date();
	    private Date modifyDate = new Date();
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
		@Override
		public String toString() {
			return "Theme [id=" + id + ", themeName=" + themeName + ", themeData=" + themeData + ", date=" + Date
					+ ", modifyDate=" + modifyDate + "]";
		}
		public Theme(String id, String themeName, Object themeData, Date date, Date modifyDate) {
			super();
			this.id = id;
			this.themeName = themeName;
			this.themeData = themeData;
			this.Date = date;
			this.modifyDate = modifyDate;
		}
	    
	    
	}
