package jdkobserver;

import java.util.Observable;

public class Subject extends Observable {

	private String news;

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		//ע����һ��
		setChanged();
		this.news = news;
	}
	
}
