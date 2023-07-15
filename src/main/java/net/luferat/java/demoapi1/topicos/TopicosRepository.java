package net.luferat.java.demoapi1.topicos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface TopicosRepository extends JpaRepository<Topicos, Long> {

	// Constante de busca por tópicos.
	final String DEFAULTPARAMS = "status = 'on'";

	// Obtém todos os tópicos ordenados pela data decrescente.
	@Query(value = "SELECT * FROM topicos WHERE " + DEFAULTPARAMS + " ORDER BY data DESC", nativeQuery = true)
	List<Topicos> findAll();

	// Obtém os tópicos mais visualizados decrescente.
	@Query(value = "SELECT * FROM topicos WHERE " + DEFAULTPARAMS + " ORDER BY views DESC LIMIT :limit", nativeQuery = true)
	List<Topicos> findMostViewedTopics(@Param("limit") int limit);

	// Obtém um tópico pelo Id.
	@Query(value = "SELECT * FROM topicos WHERE " + DEFAULTPARAMS + " AND id = :id", nativeQuery = true)
	Topicos findaById(@Param("id") Long id);

	// Obtém os tópicos de um autor, exceto o tópico com "id", em ordem aleatória.
	@Query(value = "SELECT * FROM topicos WHERE " + DEFAULTPARAMS
			+ " AND author = :uid AND id != :topicId ORDER BY RAND() LIMIT :limit", nativeQuery = true)
	List<Topicos> findAllByAuthor(@Param("uid") Long uid, @Param("topicId") Long topicId, @Param("limit") int limit);

	// Verifica se um tópico existe ou é ativo.
	@Query(value = "SELECT CASE WHEN COUNT(id) > 0 THEN true ELSE false END FROM topicos WHERE " + DEFAULTPARAMS
			+ " AND id = :id", nativeQuery = true)
	boolean existsById(@Param("id") Long id);

	// Atualiza a quantidade de visualizações do tópico pelo Id.
	@Modifying
	@Query(value = "UPDATE topicos SET views = views + 1 WHERE " + DEFAULTPARAMS + " AND id = :id", nativeQuery = true)
	void updateViews(@Param("id") Long id);

	// Busca por uma palavra ou termo nos campos "title", "resume" e "content".
	@Query(value = "SELECT * FROM topicos WHERE " + DEFAULTPARAMS
			+ " AND (UPPER(title) LIKE UPPER(CONCAT('%', :query, '%')) OR UPPER(resume) LIKE UPPER(CONCAT('%', :query, '%')) OR UPPER(content) LIKE UPPER(CONCAT('%', :query, '%')))", nativeQuery = true)
	List<Topicos> findByWord(@Param("query") String query);
}
