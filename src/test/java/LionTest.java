import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittenTest() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        int testKittens = 1;
        Mockito.when(feline.getKittens()).thenReturn(testKittens);
        assertEquals(testKittens, lion.getKittens());
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        List<String> testFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(testFood);
        assertEquals(testFood, lion.getFood());
    }

    @Test
    public void incorrectSexTest() {

        Exception exception = assertThrows(Exception.class, () -> {
            Lion lion = new Lion(feline, "Тест");
        });
        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
