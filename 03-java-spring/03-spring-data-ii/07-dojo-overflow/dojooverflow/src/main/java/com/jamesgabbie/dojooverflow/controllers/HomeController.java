package com.jamesgabbie.dojooverflow.controllers;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jamesgabbie.dojooverflow.models.Answer;
import com.jamesgabbie.dojooverflow.models.Question;
import com.jamesgabbie.dojooverflow.models.Tag;
import com.jamesgabbie.dojooverflow.services.AnswerService;
import com.jamesgabbie.dojooverflow.services.QuestionService;
import com.jamesgabbie.dojooverflow.services.TagService;

@Controller
public class HomeController {
	@Autowired
	private QuestionService qService;
	@Autowired
	private AnswerService aService;
	@Autowired
	private TagService tService;

	
	// JSP Dashboard Page
	@GetMapping("/questions")
	public String dashboard(Model viewModel) {
		
		List <Question> questions = qService.getAllQuestions();
		viewModel.addAttribute("questions", questions);
		
		return "dashboard.jsp";
	}
	
	// JSP View Question Page
	@GetMapping("/questions/{id}")
	public String viewQuestion(@PathVariable("id")Long id,Model viewModel ) {
		
		Question showQuestion = qService.getQuestion(id);
		viewModel.addAttribute("showQuestion", showQuestion);
		
		List <Tag> tagsToQuestion = tService.tagsOfQuestion(showQuestion);
		viewModel.addAttribute("tagsToQuestion", tagsToQuestion);
		
		List<Answer> answersToQuestion = aService.answersOfQuestion(showQuestion);
		viewModel.addAttribute("answersToQuestion", answersToQuestion);
		
		return "show.jsp";
	}
	
	// JSP CreateQuestion Page
	@GetMapping("/questions/new")
	public String createPage() {
		return "createQuestion.jsp";
	}
	
				///////////////////////////////////////	
	

	
	//New ArrayList to add to Question Objects
	public ArrayList<Tag> splitTags(String string){
		String[] splitStrings = new String[3];
		
		for(int i = 0; i < string.length(); i++) {
			String result = string.trim();
			splitStrings = result.split(",");
		}
		ArrayList<Tag> tags = new ArrayList<Tag>();
		for(int i = 0; i < splitStrings.length; i++) {
			Tag newTag = new Tag();
			tService.createTag(newTag);
			newTag.setTag(splitStrings[i]);
			tags.add(newTag);
		}
		return tags;
	}
		
	//POST Create Question and Tags
	@PostMapping("/questions/create") 
	public String createQuestion(@RequestParam(value="question") String question, @RequestParam(value="tag") String tags, RedirectAttributes redirectAttr) {
		ArrayList<String> errors = new ArrayList<String>();
		
		//Check Question Validation
		if(question.equals("")) {
			errors.add("*Question field must be present*");
		}
		//Check Tag Validation Casing
		char currentLetter;
		for(int i = 0; i< tags.length(); i++) {
			currentLetter = tags.charAt(i);
			if(Character.isUpperCase(currentLetter)) {
				errors.add("*All tags must be lowercase*");
			}
		}
		if(errors.size()>0) {
			for(String e:errors) {
				redirectAttr.addFlashAttribute("error", e);
			}
			return "redirect:/questions/new";
		}
		//Create Question
		Question newQuestion= new Question();
		newQuestion.setQuestion(question);
		this.qService.createQuestion(newQuestion);
		
		ArrayList<Tag> dividedTags = splitTags(tags);
		for(Tag tag : dividedTags) {
			if(newQuestion.getTags() != null) {
				newQuestion.getTags().add(tag);
			} else {
				newQuestion.setTags(dividedTags);
				qService.createQuestion(newQuestion);
				System.out.println("dividedTags = "+ dividedTags.toString());
			return "redirect:/questions";	
			}
		}
		return "redirect:/questions";
	}
	
	//POST Add Answer to Question
	@PostMapping("/questions/addAnswer/{id}")
	public String addAnswer(@PathVariable("id")Long id, @RequestParam(value="answer")String answer, RedirectAttributes redirectAttr){
		ArrayList<String> errors = new ArrayList<String>();
		//Check Answer Validation
		if(answer.equals("")) {
			errors.add("*Answer field must be present*");
		}
		if(errors.size()>0) {
			for(String e:errors) {
				redirectAttr.addFlashAttribute("error", e);
			}
			return "redirect:/questions/{id}";
		}
		Question questionToAnswer = qService.getQuestion(id);
		Answer newAnswer = new Answer(answer, questionToAnswer);
		this.aService.createAnswer(newAnswer);
		return "redirect:/questions/{id}";
	}
	
}
