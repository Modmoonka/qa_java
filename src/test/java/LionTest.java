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
        int lionKittens = lion.getKittens();
        Mockito.verify(feline).getKittens();

        assertEquals(testKittens, lionKittens);
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(feline, "Самка");

        List<String> testFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(testFood);

        List<String> lionFood = lion.getFood();

        Mockito.verify(feline).getFood("Хищник");

        assertEquals(testFood, lionFood);
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
