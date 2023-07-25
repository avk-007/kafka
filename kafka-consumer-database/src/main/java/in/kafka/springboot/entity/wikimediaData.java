package in.kafka.springboot.entity;
import lombok.*;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.*;
@Entity
@Data
@Getter
@Setter
@Table(name = "wikimediaRecentChange")
public class wikimediaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Lob
    private String wikiEventData;

    //@now create jpaRepository
}
