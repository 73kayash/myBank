package irlix.task.bank.service;

import irlix.task.bank.models.dto.user.IndexUserDto;
import irlix.task.bank.models.dto.user.WorkingUserDto;
import irlix.task.bank.models.entity.Usr;
import irlix.task.bank.repository.UsrRepository;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    //private final UserRepository repository;
    private final UsrRepository repository;

    public IndexUserDto getAllUserDto(){
        return new IndexUserDto(repository.findAll(), new Usr());
    }

    public void saveNewUser(@NotNull IndexUserDto userDto) {
        Usr user = userDto.getUserForAdd();
        repository.save(user);
    }

    private Usr getOneUser(int id){
        return repository.findById(id).get();
    }

    public WorkingUserDto getOneUserDto(int id) {
        return new WorkingUserDto(getOneUser(id));
    }

    public void editUser(WorkingUserDto userDto) {
        repository.save(userDto.getUser());
    }

    public void deleteUser(int id) {
        Usr user = getOneUser(id);
        repository.delete(user);
    }
}
