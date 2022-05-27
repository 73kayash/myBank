package irlix.task.bank.models.dto.payment;

import irlix.task.bank.models.entity.Payment;
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
public class PaymentHistoryDto {
    List<Payment> inPay;
    List<Payment> outPay;
    List<Usr> users;
    int filter_id;

}
