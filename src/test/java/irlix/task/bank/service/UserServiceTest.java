package irlix.task.bank.service;

import irlix.task.bank.models.dto.user.UserCreateEditDto;
import irlix.task.bank.models.entity.Usr;
import irlix.task.bank.repository.UsrRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest extends Assert {

    @Mock
    private UsrRepository userRepository;

    private UserService userService;

    private static Usr user;

    @BeforeClass
    public static void prepareTestData() {
        user = Usr
                .builder()
                .id(45)
                .name("Валера")
                .number("+79655584155")
                .balance(450.45f)
                .build();
    }

    @Before
    public void init() {
        userService = new UserService(userRepository);
    }

    @Test
    public void saveNewUser() {
        UserCreateEditDto userCreateEditDto = UserCreateEditDto.builder()
                .name("Mike")
                .number("+74448885555")
                .balance(450f)
                .build();

        userService.saveNewUser(userCreateEditDto);

        List<Usr> usersResult = userService.getAllUserDto().getUsers();

        assertEquals("not equal size", 1, usersResult.size());

    }


    @Test
    public void getOneUserDto() {
    }

    @Test
    public void editUser() {
    }

    @Test
    public void deleteUser() {
    }
}
