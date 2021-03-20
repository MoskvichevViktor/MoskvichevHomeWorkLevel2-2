package leveltwonumbertwo;
/*Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого
размера необходимо бросить исключение MyArraySizeException.
Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то элементе
массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено
исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException
и вывести результат расчета (сумму элементов, при условии что подали на вход корректный массив).
Заметка: Для преобразования строки к числу используйте статический метод класса Integer:
Integer.parseInt(сюда_подать_строку);
Заметка: Если Java не сможет преобразовать входную строку (в строке число криво написано), то будет сгенерировано
исключение   NumberFormatException*/
public class Main {
    public static void main(String[] args){
        String[][] arr1 = {
                {"5", "4", "3", "2"},
                {"4", "3", "2", "1"},
                {"3", "2", "1", "0"},
                {"2", "1", "0"}
        };
        String[][] arr2 = {
                {"5", "4", "3", "2"},
                {"4", "3", "2", "1"},
                {"3", "2", "1", "0"},
                {"2", "1", "0", "Q"}
        };
        String[][] arr3 = {
                {"5", "4", "3", "2"},
                {"4", "3", "2", "1"},
                {"3", "2", "1", "0"},
                {"2", "1", "0", "10"}
        };

        //method(arr1)
        try {
            try {
                System.out.println("Сумма элементов массива: " + method(arr1));
            } catch (MyArraySizeException e) {
                System.out.println("Размер массива отличается от заданного.");
            }
        }
        catch (MyArrayDataException e) {
            System.out.println("Неправильное значение элемента массива: " +  "строка №" + e.i + ", позиция №" + e.j);
        }
        //method(arr2)
        try {
            try {
                System.out.println("Сумма элементов массива: " + method(arr2));
            } catch (MyArraySizeException e) {
                System.out.println("Размер массива отличается от заданного.");
            }
        }
        catch (MyArrayDataException e) {
            System.out.println("Неправильное значение элемента массива: " +  "строка №" + e.i + ", позиция №" + e.j);
        }
        //method(arr3)
        try {
            try {
                System.out.println("Сумма элементов массива: " + method(arr3));
            } catch (MyArraySizeException e) {
                System.out.println("Размер массива отличается от заданного.");
            }
        }
        catch (MyArrayDataException e) {
            System.out.println("Неправильное значение элемента массива: " +  "строка №" + e.i + ", позиция №" + e.j);
        }

    }

    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
