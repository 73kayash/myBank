package irlix.task.bank.models.dto.user;


import irlix.task.bank.models.entity.Usr;
import lombok.*;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
public class ListUsersDto {
    private List<Usr> users;
}
