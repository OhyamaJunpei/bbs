package jp.co.sample.domain;

/**
 * comment情報を表すdomain.
 * 
 * @author junpei.oyama
 *
 */
public class Comment {
	
	/** comment id */
	private Integer id;
	/** commentした人の名前 */
	private String name;
	/** comment内容 */
	private String content;
	/** commentしたarticleのid */
	private Integer articleId;
	
	/** getter,setter */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	
}
