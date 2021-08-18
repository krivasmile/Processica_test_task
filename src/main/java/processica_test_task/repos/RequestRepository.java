package processica_test_task.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import processica_test_task.data_stats.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
}
