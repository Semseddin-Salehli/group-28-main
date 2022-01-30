package az.developia.course.qrup28.repository;

import az.developia.course.qrup28.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass , Long> {
}
