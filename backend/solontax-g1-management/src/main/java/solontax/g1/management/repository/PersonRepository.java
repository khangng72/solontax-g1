package solontax.g1.management.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solontax.g1.management.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
}
