package processica_test_task.data_stats;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String word;
    @Column
    private Integer entry;
    @ManyToOne
    @JoinColumn(name = "request_id", referencedColumnName = "id")
    @JsonBackReference
    private Request request;
}
