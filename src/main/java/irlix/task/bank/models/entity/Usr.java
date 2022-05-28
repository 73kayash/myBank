package irlix.task.bank.models.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usr {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Не должно быть пустым")
    private String name;
    private String number;
    private float balance;
}
