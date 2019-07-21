package massiv_4x4;

public class Main {


    public static void main(String[] args) {
        String s = "1 3 1 2\\n2 3 2 2\\n5 6 7 1\\n3 3 1 0"; // OK
//        String s = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0\n5 6 6 66"; // ArrayException: NOT 4x4 ARRAY Exception
//      String s = "1 a 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0"; // NumberFormatException

        String[][] stringArray = convertStringToArray(s);
        System.out.println(calculate(stringArray));
    }

    static String[][] convertStringToArray(String s) {
        String tmp = s + "\n";
        for (int i = 0, space = 0, n = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == ' ') space++;
            if (tmp.charAt(i) == '\n') {
                if (space == 3) space = 0;
                else throw new ArrayException("размер матрицы, полученной из строки, не равен 4x4");
            }
        }

        int length = s.split("\n").length;
        String[][] result = new String[length][length];
        String[] clearN = s.split("\n");

        for (int i = 0; i < length; i++) {
            String[] clearSpaces = clearN[i].split(" ");
            for (int j = 0; j < length; j++) {
                result[i][j] = clearSpaces[j];
            }
        }

        return result;
    }

    static double calculate(String[][] s) {
        int sum = 0;

        for (String[] s1 : s) {
            for (String s2 : s1) {
                try {
                    sum += Integer.parseInt(s2);
                } catch (NumberFormatException e) {
                    System.out.println("в одной из ячеек полученной матрицы не число");
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }

        return sum / 2;
    }
}

