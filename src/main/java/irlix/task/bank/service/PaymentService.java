package irlix.task.bank.service;

import irlix.task.bank.models.dto.payment.PaymentDto;
import irlix.task.bank.models.entity.Payment;
import irlix.task.bank.models.entity.Usr;
import irlix.task.bank.repository.PaymentRepository;
import irlix.task.bank.repository.UsrRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Component
public class PaymentService {
    private final PaymentRepository repository;
    private final UsrRepository userRepository;

    public PaymentDto getPaymentDto(int id) {
        Usr sender = getOneUser(id);
        List<Usr> users = userRepository.findAll();
        users.remove(sender);


        return new PaymentDto(sender, users);
    }

    private Usr getOneUser(int id) {
        return userRepository.findById(id).get();
    }

    public void addPayment(PaymentDto dto) {
        Payment payment = new Payment();
        Usr sender = userRepository.getReferenceById(dto.getSender().getId());
        Usr recipient = userRepository.getReferenceById(dto.getRecipient_id());

        sender.setBalance(sender.getBalance() - dto.getSum());
        recipient.setBalance(recipient.getBalance() + dto.getSum());

        Date date = Date.valueOf(LocalDate.now());
        payment.setDate(date);
        payment.setSender(sender);
        payment.setSum(dto.getSum());
        payment.setRecipient(recipient);

        repository.save(payment);
    }
}
