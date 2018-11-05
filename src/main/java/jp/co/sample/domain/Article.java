package jp.co.sample.domain;

import java.util.List;

/**
 * article情報を表すdomain.
 * 
 * @author junpei.oyama
 *
 */
public class Article {
	
	/** articleのid */
	private Integer id;
	/** articleを投稿した人の名前 */
	private String name;
	/** articleの内容 */
	private String content;
	/** articleに対するcommentのlist */
	private List<Comment> commentList;
	
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
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	
}
