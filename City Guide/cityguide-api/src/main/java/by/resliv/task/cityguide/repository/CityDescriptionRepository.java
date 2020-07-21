package by.resliv.task.cityguide.repository;

import by.resliv.task.cityguide.model.CityDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDescriptionRepository extends JpaRepository<CityDescription, Long> {
}
