package irlix.task.bank.controller;

import irlix.task.bank.models.dto.payment.PaymentDto;
import irlix.task.bank.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/{id}")
    public String createPayment(@PathVariable("id") int id, Model model){
        model.addAttribute("payDto", paymentService.getPaymentDto(id));
        return "payment";
    }

    @PostMapping("/{id}")
    public String addNewPayment(@ModelAttribute("payment") PaymentDto dto) {
        paymentService.addPayment(dto);
        return "redirect:/user";
    }

}
