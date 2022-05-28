package irlix.task.bank.models.dto.payment;

import irlix.task.bank.annotation.payment.AssertMore;
import irlix.task.bank.models.entity.Usr;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
//    private Usr sender;
    private String name;
    private String number;
    private float balance;
    private int recipient_id;
    private List<Usr> users;

//    @AssertMore(message = "Вы не можете перевести больше, чем у вас есть")
    private float sum;

    public PaymentDto(Usr sender, List<Usr> users) {
//        this.sender = sender;
        name = sender.getName();
        number = sender.getNumber();
        balance = sender.getBalance();
        this.users = users;
        sum = 0;
        recipient_id = 0;
    }
}
