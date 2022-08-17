package com.example.connectionsservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConnectionsNumberDTO {
    private int connectionsNum;

	public int getConnectionsNum() {
		return connectionsNum;
	}

	public void setConnectionsNum(int connectionsNum) {
		this.connectionsNum = connectionsNum;
	}

	public ConnectionsNumberDTO(int connectionsNum) {
		super();
		this.connectionsNum = connectionsNum;
	}
	public ConnectionsNumberDTO() {}
}
