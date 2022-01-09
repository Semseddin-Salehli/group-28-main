package az.developia.course.qrup28.repository;

import az.developia.course.qrup28.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "select s from Student s where s.id = :studentId ")
    Student getById(@Param("studentId") Long studentId);
}
