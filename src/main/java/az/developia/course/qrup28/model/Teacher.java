package az.developia.course.qrup28.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "teacher")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "teacher_students" , joinColumns = @JoinColumn(name = "student_id") ,
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    List<Student> students;
}
