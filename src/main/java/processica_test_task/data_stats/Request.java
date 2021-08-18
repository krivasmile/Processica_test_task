package processica_test_task.data_stats;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    @Lob
    private String payload;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Stats> statsList = new ArrayList<>();

}
