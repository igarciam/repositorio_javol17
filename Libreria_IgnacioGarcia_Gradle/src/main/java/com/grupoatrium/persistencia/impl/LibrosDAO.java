package com.grupoatrium.persistencia.impl;

public class LibrosDAO {
	private ConnectionMgr connMgr;
	
	public LibrosDAO(){
		
	}
	
	public void setconnMgr(ConnectionMgr connectionMgr){
		this.connMgr = connectionMgr;
	}

	@Override
	public String toString() {
		return "LibrosDAO [connMgr=" + connMgr + "]";
	}
	
	
}
