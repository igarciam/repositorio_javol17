package com.grupoatrium.persistencia.impl;

public class EditorialesDAO {
	private ConnectionMgr connMgr;
	
	public EditorialesDAO(){
		
	}
	
	public void setconnMgr(ConnectionMgr connectionMgr){
		this.connMgr = connectionMgr;
	}

	@Override
	public String toString() {
		return "EditorialesDAO [connMgr=" + connMgr + "]";
	}
	
	
}
