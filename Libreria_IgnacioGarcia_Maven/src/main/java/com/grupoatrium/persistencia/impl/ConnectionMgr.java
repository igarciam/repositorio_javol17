package com.grupoatrium.persistencia.impl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ConnectionMgr implements InitializingBean, DisposableBean{
	private static ConnectionMgr instance;
	private String driver;
	private String url;
	private String usuario;
	private String password;

	private ConnectionMgr(){
		
	}

	public static ConnectionMgr getInstance(){
		if(instance==null){
			instance = new ConnectionMgr();
		}
		return instance;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ConnectionMgr [driver=" + driver + ", url=" + url + ", usuario=" + usuario + ", password=" + password
				+ "]";
	}

	//@Override
	public void destroy() throws Exception {
		System.out.println("Metodo destroy de ConnectionMgr");
	}

	//@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Se han inyectado las propiedades en ConnectionMgr");
	}

	
}
