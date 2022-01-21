package az.developia.course.qrup28.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private Integer age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seriesId" , referencedColumnName = "id")
    private Series series;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private SchoolClass schoolClass;

    @ManyToMany(mappedBy = "students" , fetch = FetchType.LAZY)
    private List<Teacher> teachers;
}
