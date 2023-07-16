package net.dn.java.demoapi1.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	@Query(value = "SELECT * FROM USUARIO WHERE USER_NOME  LIKE '%:nome%' OR USER_EMAIL LIKE '%:nome%'",nativeQuery = true)
	List <Usuario> listaPAdd(@Param ("nome") String nome);
	
	@Query(value = "SELECT * FROM USUARIO WHERE USER_ID = user1",nativeQuery = true)
	Usuario sendUser(@Param ("user1") Long user1);
}
