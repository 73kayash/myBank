package irlix.task.bank.models.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateEditDto {
    @Size(min = 2, max = 15, message = "Длина имени далжна находиться в диапазоне от 2 до 15 символов!")
    @Pattern(regexp = "[А-Яа-яA-Za-z]", message = "Имя должно состоять из букв")
    private String name;
    @Pattern(regexp = "\\+7[0-9]{10}", message = "Номер должен начинаться с +7, затем 10 цифр")
    private String number;
    @PositiveOrZero(message = "Баланс не может быть меньше 0")
    private float balance;
}
