package irlix.task.bank.controller;

import irlix.task.bank.models.dto.payment.PaymentDto;
import irlix.task.bank.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public String addNewPayment(@PathVariable("id") int id, @ModelAttribute("payDto") @Valid PaymentDto dto, BindingResult bindingResult) {
        bindingResult = paymentService.getAllowPayment(bindingResult, dto);
        if(bindingResult.hasErrors()){
            return "payment";
        }
        paymentService.addPayment(dto, id);
        return "redirect:/user";
    }

    @GetMapping("/history/{id}")
    public String historyPayment(@PathVariable("id") int id, Model model, @RequestParam(name = "filter_id" , defaultValue = "0") int filter) {

        model.addAttribute("payments", paymentService.getHistoryDto(id, filter));
        return "history";
    }

}
