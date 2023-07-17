package net.dn.java.demoapi1.contatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatosAdicionadosRepository extends JpaRepository<ContatosAdicionados, Long>{
	@Query(value = "SELECT * FROM CONTATOS_ADICIONADOS WHERE CONT_USER_ID_PRIMARY  = :user1", nativeQuery = true)
	List<ContatosAdicionados> listaCont(@Param("user1") Long user);

	@Query(value = "SELECT * FROM CONTATOS_ADICIONADOS WHERE CONT_USER_ID_PRIMARY  = :user AND CONT_USER_ID_CONTATO  = :contato", nativeQuery = true)
	ContatosAdicionados existId(@Param("user") Long user, @Param("contato") Long contato);

	@Query(value = "INSERT INTO CONTATOS_ADICIONADOS  (CONT_USER_ID_PRIMARY , CONT_USER_ID_CONTATO )VALUES (:user, :contato)", nativeQuery = true)
	ContatosAdicionados addCont(@Param("user") Long user, @Param("contato") Long contato);
}
