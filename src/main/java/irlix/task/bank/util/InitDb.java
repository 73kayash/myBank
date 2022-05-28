package irlix.task.bank.util;

import irlix.task.bank.models.entity.Usr;
import irlix.task.bank.repository.UsrRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Component
public class InitDb {
    private UsrRepository repository;

    @Autowired
    public InitDb(UsrRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        List<Usr> list = new ArrayList<>();
        list.add(new Usr(1, "Сергей", "+79033334533", 45000));
        list.add(new Usr(3, "Олег", "+79033334533", 54250));
        list.add(new Usr(4, "Михаил", "+79033334533", 11000));

        for (Usr user : list) {
            if (!repository.existsById(user.getId())) {
                repository.save(user);
            }
        }
    }

}
