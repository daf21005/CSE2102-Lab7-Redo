package com.example.demo.controller;

import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Greeting;
import com.example.demo.model.MyString;
import com.example.demo.model.GetQuestion;
import com.example.demo.model.Count;
import com.example.demo.model.MyString;
import jakarta.servlet.http.HttpSession;
import com.example.demo.model.questions.*;



@Controller 
public class HomeController { 

	@GetMapping("/") 
	public String home() { 
		return "home";  // for home.html 
	} 

	@GetMapping("/greeting")
		public String greetingForm(Model model, HttpSession session) {
			Count count = (Count) session.getAttribute("count");
			if (count == null) {
				count = new Count();
			}
			count.increment();
			session.setAttribute("count", count);
			model.addAttribute("greeting", new Greeting());
			model.addAttribute("count", count);
			return "greeting";
	}

	@PostMapping("/greeting")
	public String greetingSubmit(@ModelAttribute Greeting greeting, Model model, HttpSession session) {
		Count count = (Count) session.getAttribute("count");
		if (count == null) {
			count = new Count();
			session.setAttribute("count", count);
		}
		model.addAttribute("greeting", greeting);
		model.addAttribute("count", count);
		return "result";
	}

	@GetMapping({"/get_question", "/get-question"})
	public String questionForm(Model model, HttpSession session) {
		Count count = (Count) session.getAttribute("count");
		if (count == null) {
			count = new Count();
		}
		count.increment();
		session.setAttribute("count", count);

		Integer currentIndex = (Integer) session.getAttribute("currentIndex");
		if (currentIndex == null) {
			currentIndex = 0;
			session.setAttribute("currentIndex", currentIndex);
		}

		GetQuestion getQuestion = new GetQuestion();
		QuestionTrueFalse q = getQuestion.nextQuestion(currentIndex);
		MyString myString = new MyString();
		myString.setMyString(q.getQuestion());
		model.addAttribute("myString", myString );
		model.addAttribute("count", count);

		return "question";
	}

	@PostMapping({"/get_question", "/get-question"})
	public String questionFormPOST(String answer, Model model, HttpSession session) {
		if (answer == null || answer.trim().isEmpty()) {
			return "redirect:/get-question";
		}

		Integer currentIndex = (Integer) session.getAttribute("currentIndex");
		if (currentIndex == null) {
			currentIndex = 0;
		}

		GetQuestion getQuestion = new GetQuestion();
		QuestionTrueFalse qtf = getQuestion.nextQuestion(currentIndex);

		// Check answer and store result in session
		Boolean answerBool = Boolean.valueOf(answer);
		boolean isCorrect = answerBool.equals(qtf.getAnswer());
		model.addAttribute("lastAnswerCorrect", isCorrect);

		// Update score in session
		Integer score = (Integer) session.getAttribute("score");
		if (score == null) {
			score = 0;
		}
		if (isCorrect) {
			score++;
		}
		session.setAttribute("score", score);
		model.addAttribute("score", score);

		// Update question counter
		Count count = (Count) session.getAttribute("count");
		if (count == null) {
			count = new Count();
		}
		count.increment();
		session.setAttribute("count", count);
		model.addAttribute("count", count);

		// Move to next question
		currentIndex = (currentIndex + 1);
		session.setAttribute("currentIndex", currentIndex);

		// Get next question
		QuestionTrueFalse nextQuestion = getQuestion.nextQuestion(currentIndex);
		MyString myString = new MyString();
		myString.setMyString(nextQuestion.getQuestion());
		model.addAttribute("myString", myString);

		return "question";
	}

  
}
