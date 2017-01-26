package com.ciberdix.model;

import java.sql.Timestamp;

public class LDAPUser {
    private String ldapUsername;
    private String ldapPassword;
    private boolean isAccepted;
    private String token;
    Timestamp Timestamp;
	public String getLdapUsername() {
		return ldapUsername;
	}
	public void setLdapUsername(String ldapUsername) {
		this.ldapUsername = ldapUsername;
	}
	public String getLdapPassword() {
		return ldapPassword;
	}
	public void setLdapPassword(String ldapPassword) {
		this.ldapPassword = ldapPassword;
	}
	public boolean isAccepted() {
		return isAccepted;
	}
	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	public void setToken(String token){
		this.token = token;
	}
	public String getToken(){
		return token;
	}
	public Timestamp getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		Timestamp = timestamp;
	}		
}
