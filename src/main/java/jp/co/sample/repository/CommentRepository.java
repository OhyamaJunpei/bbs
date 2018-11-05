package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Comment;

/**
 * commentのDB操作を行うメソッドを持つrepository.
 * 
 * @author junpei.oyama
 *
 */
@Repository
public class CommentRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public static final RowMapper<Comment> COMMENT_ROW_MAPPER = (rs,i) -> {
		Comment comment = new Comment();
		comment.setId(rs.getInt("id"));
		comment.setName(rs.getString("name"));
		comment.setContent(rs.getString("content"));
		comment.setArticleId(rs.getInt("article_id"));
		return comment;
	};
	
	/**
	 * article_idでarticleに対するcommentを検索するメソッド.
	 * 
	 * @param articleId 記事id
	 * @return article_idに対するcommentList
	 */
	public List<Comment> findByArticleId(int articleId){
		String sql = "SELECT id,name,content,article_id FROM comments WHERE article_id = :articleId";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("articleId", articleId);
		
		List<Comment> commentList = template.query(sql, param, COMMENT_ROW_MAPPER);
		
		return commentList;
	}
	
}
