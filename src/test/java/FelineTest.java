import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    Feline feline;

    @Before
    public void before() {
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamilyTest() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensNoParamsTest() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithParamsTest() throws Exception {
        assertEquals(10, feline.getKittens(10));
    }
}