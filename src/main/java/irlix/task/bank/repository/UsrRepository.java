package irlix.task.bank.repository;

import irlix.task.bank.models.entity.Usr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsrRepository extends JpaRepository<Usr, Integer> {
}