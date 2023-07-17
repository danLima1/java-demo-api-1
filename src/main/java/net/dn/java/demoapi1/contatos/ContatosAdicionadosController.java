package net.dn.java.demoapi1.contatos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contatosadicionados")
@CrossOrigin
public class ContatosAdicionadosController {
	@Autowired
	private ContatosAdicionadosRepository contatosAdicionadosRepository ;

	@GetMapping("/{uId}")
	public List<ContatosAdicionados> getAll(@PathVariable Long uId) {
		return contatosAdicionadosRepository.listaCont(uId);
	}

	@GetMapping("/{uId1}/{uId2}")
	public ContatosAdicionados get(@PathVariable Long uId1, @PathVariable Long uId2) {
		return contatosAdicionadosRepository.existId(uId1, uId2);
	}

	@PostMapping
	public ContatosAdicionados post(@RequestBody ContatosAdicionados contatosAdicionados) {
		return contatosAdicionadosRepository.save(contatosAdicionados);
	}
}
