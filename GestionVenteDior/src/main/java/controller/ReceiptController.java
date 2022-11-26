package controller;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

import dataAccessObject.ArticleAction;
import dataAccessObject.ClientsAction;
import models.Articlesprix;
import models.Clients;

public class ReceiptController extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Articlesprix article=new Articlesprix();
	private Clients clientBill=new Clients();
	private int codeCmd;
	private String client;
	private int codeArt;
	private int qteCmd;
	private Date dateCmd;
	private int total=0;
	
	

	public String getClient() {
		return client;
	}



	public void setClient(String client) {
		this.client = client;
	}



	public Articlesprix getArticle() {
		return article;
	}



	public void setArticle(Articlesprix article) {
		this.article = article;
	}


	public int getCodeArt() {
		return codeArt;
	}



	public void setCodeArt(int codeArt) {
		this.codeArt = codeArt;
	}



	



	public int getQteCmd() {
		return qteCmd;
	}



	public void setQteCmd(int qteCmd) {
		this.qteCmd = qteCmd;
	}


	public Date getDateCmd() {
		return dateCmd;
	}



	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}



	public int getCodeCmd() {
		return codeCmd;
	}



	public void setCodeCmd(int codeCmd) {
		this.codeCmd = codeCmd;
	}



	public Clients getClientBill() {
		return clientBill;
	}



	public void setClientBill(Clients clientBill) {
		this.clientBill = clientBill;
	}

	@Override
	public String execute() throws Exception {
		ArticleAction aa=new ArticleAction();
		this.article=aa.getArticleById(codeArt);
		
		ClientsAction ca=new ClientsAction();
		this.clientBill=ca.getClientByEmail(client);
		
		setTotal(article.getPrixArt()*qteCmd);
		
		return SUCCESS;
	}



	public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}
	
	
	

}
