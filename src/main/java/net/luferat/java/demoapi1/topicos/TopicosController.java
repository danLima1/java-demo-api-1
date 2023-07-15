package net.luferat.java.demoapi1.topicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicosRepository topicosrepository;

	@GetMapping
	public List<Topicos> getAll() {
		return topicosrepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Topicos getOne(@PathVariable Long id) {
		return topicosrepository.findById(id).orElse(null);
	}

	@GetMapping(path = "/views/{limit}")
	public List<Topicos> getByViews(@PathVariable int limit) {
		return topicosrepository.findMostViewedTopics(limit);
	}

	@PatchMapping(path = "/{id}", produces = "application/json")
	public String updateViews(@PathVariable Long id) {
		topicosrepository.updateViews(id);
		return "{\"status\": \"success\"}";
	}

	@GetMapping(path = "/author")
	public List<Topicos> getByAuthor(@RequestParam("uid") Long uid, @RequestParam("art") Long articleId,
			@RequestParam("lim") int limit) {
		return topicosrepository.findAllByAuthor(uid, articleId, limit);
	}

	@GetMapping(path = "/find")
	public List<Topicos> findTopicByWord(@RequestParam("q") String q) {
		return topicosrepository.findByWord(q);
	}
}
