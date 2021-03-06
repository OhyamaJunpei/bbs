package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Article;

/**
 * articleのDB操作を行うRepository.
 * 
 * @author junpei.oyama
 *
 */
@Repository
public class ArticleRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Article> ARTICLE_ROW_MAPPER = (rs, i) -> {
		Article article = new Article();
		article.setId(rs.getInt("id"));
		article.setName(rs.getString("name"));
		article.setContent(rs.getString("content"));
		return article;
	};
	
	/**
	 * 記事一覧を表示するメソッド.
	 * 
	 * @return 記事一覧が格納されたリスト
	 */
	public List<Article> findAll(){
		String sql = "SELECT id,name,content FROM articles ORDER BY id DESC";
		
		List<Article> articleList = template.query(sql, ARTICLE_ROW_MAPPER);
		
		return articleList;
	}
	
	
	/**
	 * 記事を投稿するメソッド.
	 * 
	 * @param article 記事情報
	 */
	public void insert(Article article) {
		String sql = "INSERT INTO articles(name, content) VALUES(:name, :content)";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", article.getName()).addValue("content", article.getContent());
		
		//.addValue省略
//		SqlParameterSource param = new BeaPropertySqlParameterSource(article);
		
		template.update(sql, param);
		
	}
}
