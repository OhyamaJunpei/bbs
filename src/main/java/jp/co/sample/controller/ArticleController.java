package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Article;
import jp.co.sample.form.ArticleForm;
import jp.co.sample.repository.ArticleRepository;


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
	
	@ModelAttribute
	public ArticleForm setUpForm() {
		return new ArticleForm();
	}
	
	@RequestMapping("/bbs")
	public String bbs(Model model) {
		
		List<Article> articleList = articleRepository.findAll();
		model.addAttribute("articleList", articleList);
		
		return "bbs";
		
	}
	
}
