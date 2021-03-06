package by.itsparnter.task.repository;

import by.itsparnter.task.model.Bulb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BulbRepository extends JpaRepository<Bulb, Long> {
}
