package com.theme.data.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.Date;
import java.util.List;


@Data
@Document(collection = "ThemeSchema")
public class Theme {
	
	@Id
	@Indexed(unique = true)
	private String themeId;
	
	@Indexed(unique = true)
	@NotBlank(message = "Theme Name cannot not be empty")
	private String themeName;
	
	@NotBlank(message = "Theme Data cannot not be empty")
    private Object themeData; // Field for JSON data
	
	private Date Date = new Date();
	
	private Date modifyDate = new Date();
	
	private String clientId;
	
    private List<String> formIds; // List of associated Form IDs

	
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
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	public List<String> getFormIds() {
		return formIds;
	}
	public void setFormIds(List<String> formIds) {
		this.formIds = formIds;
	}
	public Theme() {

	}
}
