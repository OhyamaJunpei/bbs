package jp.co.sample.form;

/**
 * commentのform情報を表すform.
 * 
 * @author junpei.oyama
 *
 */
public class CommentForm {
	
	/** 記事id */
	private String articleId;
	/** commentした人の名前 */
	private String name;
	/** comment内容 */
	private String content;
	
	/** getter,setter */
	
	/** articleId を Integer型に変換 */
	public Integer getIntArticleId() {
		return Integer.parseInt(articleId);
	}
	
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
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
	
}
