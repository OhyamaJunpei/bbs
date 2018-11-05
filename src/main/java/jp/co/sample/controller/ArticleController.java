package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Article;
import jp.co.sample.form.ArticleForm;
import jp.co.sample.form.CommentForm;
import jp.co.sample.repository.ArticleRepository;
import jp.co.sample.repository.CommentRepository;


/**
 * articleの情報をフォワードするcontroller.
 * 
 * @author junpei.oyama
 *
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private CommentRepository commentRepository;
	
	@ModelAttribute
	public ArticleForm setUpForm() {
		return new ArticleForm();
	}
	@ModelAttribute
	public CommentForm setUpForm1() {
		return new CommentForm();
	}
	
	/**
	 * 初期画面へフォワードするメソッド.
	 * 
	 * @param model モデル
	 * @return　初期画面
	 */
	@RequestMapping("/bbs")
	public String bbs(Model model) {
		
		List<Article> articleList = articleRepository.findAll();
		model.addAttribute("articleList", articleList);
		
		return "bbs";
		
	}
	
	/**
	 * articleを投稿するメソッド.
	 * 
	 * @param articleForm 記事のform情報
	 * @param model　モデル
	 * @return　トップページにリダイレクト
	 */
	@RequestMapping("/insertArticle")
	public String insertArticle(ArticleForm articleForm, Model model) {
		
		Article article = new Article();
		article.setName(articleForm.getName());
		article.setContent(articleForm.getContent());
		
		articleRepository.insert(article);
		
		model.addAttribute("article", article);
		
		return "redirect:/article/bbs";
	}
	
	
}
