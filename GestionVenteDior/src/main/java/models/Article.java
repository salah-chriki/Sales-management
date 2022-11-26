package models;

public class Article {
	private int codeArt;
	private String nomArt;
	private int prixArt;
	private int qteArt;
	
	
	public Article() {
		super();
	}
	public Article(int codeArt, String nomArt, int prixArt, int qteArt) {
		super();
		this.codeArt = codeArt;
		this.nomArt = nomArt;
		this.prixArt = prixArt;
		this.qteArt = qteArt;
	}
	public int getCodeArt() {
		return codeArt;
	}
	public void setCodeArt(int codeArt) {
		this.codeArt = codeArt;
	}
	public String getNomArt() {
		return nomArt;
	}
	public void setNomArt(String nomArt) {
		this.nomArt = nomArt;
	}
	public int getPrixArt() {
		return prixArt;
	}
	public void setPrixArt(int prixArt) {
		this.prixArt = prixArt;
	}
	public int getQteArt() {
		return qteArt;
	}
	public void setQteArt(int qteArt) {
		this.qteArt = qteArt;
	}
	@Override
	public String toString() {
		return "Article [codeArt=" + codeArt + ", nomArt=" + nomArt + ", prixArt=" + prixArt + ", qteArt=" + qteArt
				+ "]";
	}
	
	
	

}
