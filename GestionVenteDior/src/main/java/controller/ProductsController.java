package controller;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dataAccessObject.ProductsAction;
import models.Article;


public class ProductsController extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Article> listArticles = new ArrayList<Article>();
	private String activeProducts;

	public List<Article> getListArticles() {
		return listArticles;
	}

	public void setListArticles(List<Article> listArticles) {
		this.listArticles = listArticles;
	}

	public String displayProducts() throws Exception {
		activeProducts = "active";
		ProductsAction aa = new ProductsAction();
		this.listArticles = aa.getAllProducts();
		return SUCCESS;
	}

	public String getActiveProducts() {
		return activeProducts;
	}

	public void setActiveProducts(String activeProducts) {
		this.activeProducts = activeProducts;
	}

}
