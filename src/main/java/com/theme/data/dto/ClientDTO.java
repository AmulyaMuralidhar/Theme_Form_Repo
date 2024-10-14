package com.theme.data.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;

public class ClientDTO {
    @NotBlank(message = "Client ID cannot be empty")
    private String clientId;
    
    @NotBlank(message = "Client Name cannot be empty")
    private String clientName;
    
    private Instant clientCreateDate;
    private Instant clientModifiedDate;
    private List<String> formIds;
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public Instant getClientCreateDate() {
		return clientCreateDate;
	}
	public void setClientCreateDate(Instant clientCreateDate) {
		this.clientCreateDate = clientCreateDate;
	}
	public Instant getClientModifiedDate() {
		return clientModifiedDate;
	}
	public void setClientModifiedDate(Instant clientModifiedDate) {
		this.clientModifiedDate = clientModifiedDate;
	}
	public List<String> getFormIds() {
		return formIds;
	}
	public void setFormIds(List<String> formIds) {
		this.formIds = formIds;
	}
	public ClientDTO() {
		
	}

   
}