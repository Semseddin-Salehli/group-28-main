package az.developia.course.qrup28.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "series")
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
}
