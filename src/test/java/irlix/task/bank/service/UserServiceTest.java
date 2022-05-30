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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
    public void updateTest() {
        when(userRepository.getReferenceById(any(Integer.class))).thenReturn(user);
//        when(userRepository.save(any(Usr.class))).thenReturn(returnsFirstArg());
        Usr userForUpdate = Usr.builder()
                .name("Александр")
                .number("+79427415401")
                .balance(350.45f)
                .build();
        UserCreateEditDto editDto = UserCreateEditDto.builder()
                .name(userForUpdate.getName())
                .number(userForUpdate.getNumber())
                .balance(userForUpdate.getBalance())
                .build();

        userService.editUser(editDto, user.getId());
        Usr resultUser = userRepository.getReferenceById(user.getId());

        assertNotNull(resultUser);
        assertSame(resultUser.getId(), user.getId());
        assertEquals("name not equal", resultUser.getName(), userForUpdate.getName());
        assertEquals("number not equal", resultUser.getNumber(), userForUpdate.getNumber());
        assertEquals(resultUser.getBalance(), userForUpdate.getBalance(), 0);
    }
}
