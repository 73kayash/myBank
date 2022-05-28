package irlix.task.bank.service;

import irlix.task.bank.models.dto.payment.PaymentDto;
import irlix.task.bank.models.dto.payment.PaymentHistoryDto;
import irlix.task.bank.models.entity.Payment;
import irlix.task.bank.models.entity.Usr;
import irlix.task.bank.repository.PaymentRepository;
import irlix.task.bank.repository.UsrRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingErrorProcessor;
import org.springframework.validation.BindingResult;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@Component
public class PaymentService {
    private final PaymentRepository repository;
    private final UsrRepository userRepository;

    public PaymentDto getPaymentDto(int id) {
        Usr sender = getOneUser(id);
        List<Usr> users = getUsersWithoutOwner(id);

        return new PaymentDto(sender, users);
    }

    private List<Usr> getUsersWithoutOwner(int id){
        List<Usr> users = userRepository.findAll();
        users.remove(getOneUser(id));
        return users;
    }

    private Usr getOneUser(int id) {
        return userRepository.findById(id).get();
    }

    public void addPayment(PaymentDto dto, int id) {
        Payment payment = new Payment();
        Usr sender = userRepository.getReferenceById(id);
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

    public PaymentHistoryDto getHistoryDto(int id, int filter) {
        List<Payment> inPay;
        List<Payment> outPay;
        List<Payment> allPayments = repository.findAll();

        inPay = allPayments.stream().
                filter(p -> p.getRecipient().getId() == id).
                collect(Collectors.toList());
        outPay = allPayments.stream().
                filter(payment -> payment.getSender().getId() == id).
                collect(Collectors.toList());

        if(filter != 0){
            inPay = inPay.stream().
                    filter(p -> p.getSender().getId() == filter).
                    collect(Collectors.toList());
            outPay = outPay.stream().
                    filter(payment -> payment.getRecipient().getId() == filter).
                    collect(Collectors.toList());
        }
        return new PaymentHistoryDto(inPay, outPay, getUsersWithoutOwner(id), filter);
    }

    public BindingResult getAllowPayment(BindingResult bindingResult, PaymentDto paymentDto) {
        if(paymentDto.getBalance()-paymentDto.getSum() > 0){
            return bindingResult;
        }
        bindingResult.rejectValue("sum", "Not Enough Cash", "Недостаточно средств для перевода");
        return bindingResult;
    }
}
