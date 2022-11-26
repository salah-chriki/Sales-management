package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Generated Jun 1, 2022, 2:02:09 PM by Hibernate Tools 5.4.33.Final

/**
 * Users generated by hbm2java
 */
@Entity
public class Users implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codeUser;
	@Column
	private String login;
	@Column
	private String pass;

	public Users() {
	}

	public Users(String login, String pass) {
		this.login = login;
		this.pass = pass;
	}

	public Integer getCodeUser() {
		return this.codeUser;
	}

	public void setCodeUser(Integer codeUser) {
		this.codeUser = codeUser;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
