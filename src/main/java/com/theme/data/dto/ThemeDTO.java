package com.theme.data.dto;
import java.util.Date;
import lombok.Data;

@Data
public class ThemeDTO {
	
		private String themeId;
		private String themeName;
	    private Object themeData; // Object to save column data in JSON format
	    private Date Date = new Date();
	    private Date modifyDate = new Date();
	    private String clientId;
	    
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
			return Date;
		}
		public void setDate(Date date) {
			Date = date;
		}
		public Date getModifyDate() {
			return modifyDate;
		}
		public void setModifyDate(Date modifyDate) {
			this.modifyDate = modifyDate;
		}

		public ThemeDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
	
}
