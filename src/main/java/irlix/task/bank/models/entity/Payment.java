package irlix.task.bank.models.entity;


import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float sum;
    private Date date;

    @OneToOne
    private Usr recipient;

    @OneToOne
    private Usr sender;

}
