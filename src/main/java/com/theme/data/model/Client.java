package com.theme.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection = "clients")
public class Client {
    @Id
    private String clientId;
    private String clientName;
    private Instant clientCreateDate;
    private Instant clientModifiedDate;
    private List<String> formIds; // List of associated Form IDs
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
	public Client(String clientId, String clientName, Instant clientCreateDate, Instant clientModifiedDate,
			List<String> formIds) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientCreateDate = clientCreateDate;
		this.clientModifiedDate = clientModifiedDate;
		this.formIds = formIds;
	}
	public Client() {
	
	}
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", clientCreateDate=" + clientCreateDate
				+ ", clientModifiedDate=" + clientModifiedDate + ", formIds=" + formIds + "]";
	}

}