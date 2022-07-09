import org.apache.commons.lang3.StringUtils;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
        try {
            //подсчет количества пробелов в строке имени
            int countSpaces = StringUtils.countMatches(name, " ");
            //поиск индекса пробела
            int indexSpace = name.indexOf(" ");
            //вынесла длину имени в отдельную переменную для красоты )
            int nameLength = name.length();

            //проверка всех требований
            //проверка на соответствие диапазону длины от 3 до 19 символов
            if (nameLength >= 3 && nameLength <= 19) {
                //проверка на наличие одного пробела
                if (countSpaces == 1) {
                    //проверка на положение пробела: не в начале и не в конце строки
                    if (indexSpace != 0 && indexSpace != nameLength-1) {
                        return true;
                    }
                }
            }
            return false;
        }
        catch (NullPointerException exception) {
            return false;
            }
        }
    }