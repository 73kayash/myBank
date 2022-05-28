package irlix.task.bank.service;

import irlix.task.bank.models.dto.user.IndexUserDto;
import irlix.task.bank.models.dto.user.UserCreateEditDto;
import irlix.task.bank.models.entity.Usr;
import irlix.task.bank.repository.UsrRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    //private final UserRepository repository;
    private final UsrRepository repository;

    public IndexUserDto getAllUserDto(){
        return new IndexUserDto(repository.findAll());
    }

    public void saveNewUser(UserCreateEditDto userDto) {
        Usr user = new Usr();
        user.setName(userDto.getName());
        user.setNumber(userDto.getNumber());
        user.setBalance(userDto.getBalance());
        repository.save(user);
    }

    private Usr getOneUser(int id){
        return repository.findById(id).get();
    }

    public UserCreateEditDto getOneUserDto(int id) {
        Usr user = getOneUser(id);
        return new UserCreateEditDto(user.getName(), user.getNumber(), user.getBalance());
    }

    public void editUser(UserCreateEditDto userDto, int id) {
        Usr user = getOneUser(id);
        user.setBalance(userDto.getBalance());
        user.setName(userDto.getName());
        user.setBalance(userDto.getBalance());
        repository.save(user);
    }

    public void deleteUser(int id) {
        Usr user = getOneUser(id);
        repository.delete(user);
    }
}
