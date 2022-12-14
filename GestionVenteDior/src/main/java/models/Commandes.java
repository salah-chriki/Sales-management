package models;
// Generated Jun 1, 2022, 2:02:09 PM by Hibernate Tools 5.4.33.Final

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Commandes generated by hbm2java
 */
@Entity
public class Commandes implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codeCmd;
	@Column
	private String client;
	@Column
	private int codeArt;
	@Column
	private int qteCmd;
	@Column
	private Date dateCmd;

	public Commandes() {
	}

	public Commandes(String client, int codeArt, int qteCmd, Date dateCmd) {
		this.client = client;
		this.codeArt = codeArt;
		this.qteCmd = qteCmd;
		this.dateCmd = dateCmd;
	}

	public Integer getCodeCmd() {
		return this.codeCmd;
	}

	public void setCodeCmd(Integer codeCmd) {
		this.codeCmd = codeCmd;
	}

	public String getClient() {
		return this.client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public int getCodeArt() {
		return this.codeArt;
	}

	public void setCodeArt(int codeArt) {
		this.codeArt = codeArt;
	}

	public int getQteCmd() {
		return this.qteCmd;
	}

	public void setQteCmd(int qteCmd) {
		this.qteCmd = qteCmd;
	}

	public Date getDateCmd() {
		return this.dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

}
