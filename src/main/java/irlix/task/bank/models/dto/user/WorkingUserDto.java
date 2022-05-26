package irlix.task.bank.models.dto.user;

import irlix.task.bank.models.entity.Usr;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class WorkingUserDto {
    Usr user;
}
