package irlix.task.bank.models.dto.user;


import irlix.task.bank.models.entity.Usr;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class IndexUserDto {
    private List<Usr> users;
    private Usr userForAdd;
}
