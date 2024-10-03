package com.theme.data.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.util.Date;

	@Data
	@Document(collection = "theme")
	public class Theme {
	    @Id
	    private String id;
	    private String themeName;
	    private Object themeData; // Object to save column data in JSON format
	    private Date date = new Date();
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
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public Date getModifyDate() {
			return modifyDate;
		}
		public void setModifyDate(Date modifyDate) {
			this.modifyDate = modifyDate;
		}
		@Override
		public String toString() {
			return "Theme [id=" + id + ", themeName=" + themeName + ", themeData=" + themeData + ", date=" + date
					+ ", modifyDate=" + modifyDate + "]";
		}
		public Theme(String id, String themeName, Object themeData, Date date, Date modifyDate) {
			super();
			this.id = id;
			this.themeName = themeName;
			this.themeData = themeData;
			this.date = date;
			this.modifyDate = modifyDate;
		}
	    
	    
	}
