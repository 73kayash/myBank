package irlix.task.bank.util;

import irlix.task.bank.models.entity.Payment;
import irlix.task.bank.models.entity.Usr;
import irlix.task.bank.repository.PaymentRepository;
import irlix.task.bank.repository.UsrRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Component
public class InitDb {
    private UsrRepository userRepository;
    private PaymentRepository paymentRepository;

    @Autowired
    public InitDb(UsrRepository userRepository, PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        List<Usr> list = new ArrayList<>();
        list.add(new Usr(1, "Сергей", "+79033334533", 45000));
        list.add(new Usr(3, "Олег", "+79033334533", 54250));
        list.add(new Usr(4, "Михаил", "+79033334533", 11000));

        List<Payment> paymentList = new ArrayList<>();

        paymentList.add(new Payment(1, 200f, Date.valueOf(LocalDate.of(2022,5,12)), list.get(0), list.get(1)));
        paymentList.add(new Payment(2, 615f, Date.valueOf(LocalDate.of(2022,5,11)), list.get(1), list.get(2)));
        paymentList.add(new Payment(3, 1235f, Date.valueOf(LocalDate.of(2022,5,9)), list.get(2), list.get(0)));
        paymentList.add(new Payment(4, 200f, Date.valueOf(LocalDate.of(2022,5,7)), list.get(1), list.get(0)));
        paymentList.add(new Payment(5, 350f, Date.valueOf(LocalDate.of(2022,4,29)), list.get(0), list.get(2)));
        paymentList.add(new Payment(6, 240f, Date.valueOf(LocalDate.of(2022,4,19)), list.get(2), list.get(1)));
        paymentList.add(new Payment(7, 43f, Date.valueOf(LocalDate.of(2022,4,11)), list.get(1), list.get(0)));
        paymentList.add(new Payment(8, 20f, Date.valueOf(LocalDate.of(2022,4,1)), list.get(2), list.get(1)));
        paymentList.add(new Payment(9, 215f, Date.valueOf(LocalDate.of(2022,3,21)), list.get(0), list.get(2)));
        paymentList.add(new Payment(10, 2000f, Date.valueOf(LocalDate.of(2022,3,15)), list.get(2), list.get(1)));
        paymentList.add(new Payment(11, 45f, Date.valueOf(LocalDate.of(2022,3,9)), list.get(1), list.get(0)));
        paymentList.add(new Payment(12, 753f, Date.valueOf(LocalDate.of(2022,3,7)), list.get(0), list.get(2)));
        paymentList.add(new Payment(13, 1662f, Date.valueOf(LocalDate.of(2022,3,3)), list.get(2), list.get(1)));
        paymentList.add(new Payment(14, 1235f, Date.valueOf(LocalDate.of(2022,2,27)), list.get(0), list.get(2)));
        paymentList.add(new Payment(15, 1245f, Date.valueOf(LocalDate.of(2022,2,29)), list.get(1), list.get(0)));
        paymentList.add(new Payment(16, 125f, Date.valueOf(LocalDate.of(2022,2,13)), list.get(0), list.get(2)));
        paymentList.add(new Payment(17, 358f, Date.valueOf(LocalDate.of(2022,2,5)), list.get(1), list.get(0)));
        paymentList.add(new Payment(18, 46f, Date.valueOf(LocalDate.of(2022,2,1)), list.get(2), list.get(1)));
        paymentList.add(new Payment(19, 68f, Date.valueOf(LocalDate.of(2022,1,27)), list.get(2), list.get(0)));
        paymentList.add(new Payment(20, 4654f, Date.valueOf(LocalDate.of(2022,1,21)), list.get(0), list.get(1)));
        paymentList.add(new Payment(21, 5645f, Date.valueOf(LocalDate.of(2022,1,19)), list.get(1), list.get(2)));
        paymentList.add(new Payment(22, 456f, Date.valueOf(LocalDate.of(2022,1,15)), list.get(1), list.get(0)));
        paymentList.add(new Payment(23, 132f, Date.valueOf(LocalDate.of(2022,1,12)), list.get(0), list.get(2)));
        paymentList.add(new Payment(24, 897f, Date.valueOf(LocalDate.of(2022,1,7)), list.get(2), list.get(1)));

        for (Usr user : list) {
            if (!userRepository.existsById(user.getId())) {
                userRepository.save(user);
            }
        }
        for (Payment pay : paymentList) {
            if(!paymentRepository.existsById(pay.getId())) {
                paymentRepository.save(pay);
            }
        }
    }

}
