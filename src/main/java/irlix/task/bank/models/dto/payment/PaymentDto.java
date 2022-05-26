package irlix.task.bank.models.dto.payment;

import irlix.task.bank.models.entity.Payment;
import irlix.task.bank.models.entity.Usr;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private Usr sender;
    private int recipient_id;
    private List<Usr> users;
    private float sum;

    public PaymentDto(Usr sender, List<Usr> users) {
        this.sender = sender;
        this.users = users;
        sum = 0;
        recipient_id = 0;
    }
}
