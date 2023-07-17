package net.dn.java.demoapi1.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class UsuarioController {
	@Autowired 
	private UsuarioRepository usuarioRepository;

	@GetMapping("/{uNom}")
	public List<Usuario> getAll(@PathVariable String uNom){
		return usuarioRepository.listaPAdd(uNom);
		}

	@GetMapping(path = "/{userId}/one")
	public Usuario getOne(@PathVariable Long userId) {
			return usuarioRepository.sendUser(userId);
	}

	@PostMapping
	public Usuario post(@RequestBody Usuario user) {
		return usuarioRepository.save(user);
	}

	@PatchMapping(path = "/{userId}")
	public Usuario patch(@PathVariable Long id, @RequestBody Usuario user) {
		return null;
	}
}
