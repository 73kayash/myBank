package irlix.task.bank.service;

import irlix.task.bank.models.dto.user.ListUsersDto;
import irlix.task.bank.models.dto.user.UserCreateEditDto;
import irlix.task.bank.models.entity.Usr;
import irlix.task.bank.repository.UsrRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private final UsrRepository repository;

    public ListUsersDto getAllUserDto() {
        return new ListUsersDto(repository.findAll());
    }

    public void saveNewUser(UserCreateEditDto userDto) {
        Usr user = new Usr();
        user.setName(userDto.getName());
        user.setNumber(userDto.getNumber());
        user.setBalance(userDto.getBalance());
        repository.save(user);
    }

    private Usr getOneUser(int id) {
        return repository.getReferenceById(id);
    }

    public UserCreateEditDto getOneUserDto(int id) {
        Usr user = getOneUser(id);
        return new UserCreateEditDto(user.getName(), user.getNumber(), user.getBalance());
    }

    public void editUser(UserCreateEditDto userDto, int id) {
        Usr user = getOneUser(id);
        user.setBalance(userDto.getBalance());
        user.setName(userDto.getName());
        user.setNumber(userDto.getNumber()
        );
        repository.save(user);
    }

    public void deleteUser(int id) {
        Usr user = getOneUser(id);
        repository.delete(user);
    }
}
