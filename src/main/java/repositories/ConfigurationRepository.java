
package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Configuration;
import domain.Message;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, Integer> {

	@Query("select s from Configuration c join c.spamWords s")
	public List<String> spamWords();

	@Query("select c.goodWords from Configuration c")
	public String goodWords();

	@Query("select c.badWords from Configuration c")
	public String badWords();

	@Query("select c from Configuration c")
	public Configuration configuration();

	@Query("select m from Actor a join a.messages m join a.userAccount u where a.id = ?1 and m.sender = u.username")
	public List<Message> messagesSendedByActor(int actorId);

}
