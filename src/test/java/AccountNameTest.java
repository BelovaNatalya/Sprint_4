import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class AccountNameTest {
    String name;
    boolean expectedResult;

    public AccountNameTest(String name, boolean expectedResult) {
        this.name = name;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] nameOptions() {
        return new Object[][]{
                {"Альбус Дамблдор", true},//длина строки находится в диапазоне от 3 до 19 символов, содержит 1 пробел не в начале и не в конце строки
                {"Я Я", true},//длина строки находится на нижней допустимой границе
                {"Минерва Макгонагалл", true},//длина строки находится на верхней допустимой границе
                {"ЯЯ", false},//длина строки на 1 единицу меньше нижней допустимой границы
                {"ЯЯ Я", true},//длина строки на 1 единицу больше нижней допустимой границы
                {"Невилл Долгопупс", true},//длина строки на 1 единицу меньше верхней допустимой границы
                {"Белатриса Лестрейндж", false},//длина строки на 1 единицу больше верхней допустимой границы
                {"ГарриПоттер", false},//в строке нет пробелов
                {"Гарри  Поттер", false},//в строке есть два пробела подряд
                {"Гарри Джеймс Поттер", false},//в строке есть два пробела не подряд
                {" ГарриПоттер", false},//пробел в начале строки
                {"ГарриПоттер ", false},//пробел в конце строки
                {"    ", false},//строка состоит только из пробелов
                {"4815162342", false},//строка состоит из цифр
                {"^_^", false},//строка состоит из спецсимволов
                {"", false},//нулевая строка
                {null, false},//пустой ввод
        };
    }

    @Test
    public void shouldNameBeEmbossed() {
        Account account = new Account(name);
        boolean actualResult = account.checkNameToEmboss();
        assertThat("Фактический результат не совпал с ожидаемым", actualResult, equalTo(expectedResult));
    }
}
