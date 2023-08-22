package Model;

import java.util.Locale;

public class Soup {
    public String[][] soup;
    public Constants constants = new Constants();
    public int wordsFound = 0;
    public Soup(){
        soup = new String[constants.getSIZE()][constants.getSIZE()];
    }

    public int getWordsFound() {
        return wordsFound;
    }

    public void wordsPutter(){

        for (int i = 0; i < constants.getWORDS().length; i++) {

            int x = (int) (Math.random() * (constants.getSIZE()-1));
            int y = (int) (Math.random() * (constants.getSIZE()-1));

            int direction = (int) (Math.random() * 7);

            String word = constants.getWORDS()[i];

            // This sout is for evaluation
            // System.out.println(word+" "+x+" "+y+" "+direction);

            switch (direction) {
                case 0 -> {
                    if (x + word.length() < constants.getSIZE()) {
                        for (int j = 0; j < word.length(); j++) {
                            if (soup[x + j][y] == null){
                                soup[x + j][y] = word.substring(j, j + 1);
                            }

                        }
                    } else {
                        i--;
                    }
                }
                case 1 -> {
                    if (x + word.length() < constants.getSIZE() && y + word.length() < constants.getSIZE()) {
                        for (int j = 0; j < word.length(); j++) {
                            if (soup[x + j][y + j] == null){
                                soup[x + j][y + j] = word.substring(j, j + 1);
                            }
                        }
                    } else {
                        i--;
                    }
                }
                case 2 -> {
                    if (y + word.length() < constants.getSIZE()) {
                        for (int j = 0; j < word.length(); j++) {
                            if (soup[x][y + j] == null){
                                soup[x][y + j] = word.substring(j, j + 1);
                            }
                        }
                    } else {
                        i--;
                    }
                }
                case 3 -> {
                    if (x - word.length() > 0 && y + word.length() < constants.getSIZE()) {
                        for (int j = 0; j < word.length(); j++) {
                            if (soup[x - j][y + j] == null){
                                soup[x - j][y + j] = word.substring(j, j + 1);
                            }
                        }
                    } else {
                        i--;
                    }
                }
                case 4 -> {
                    if (x - word.length() > 0) {
                        for (int j = 0; j < word.length(); j++) {
                            if (soup[x - j][y] == null){
                                soup[x - j][y] = word.substring(j, j + 1);
                            }
                        }
                    } else {
                        i--;
                    }
                }
                case 5 -> {
                    if (x - word.length() > 0 && y - word.length() > 0) {
                        for (int j = 0; j < word.length(); j++) {
                            if (soup[x - j][y - j] == null){
                                soup[x - j][y - j] = word.substring(j, j + 1);
                            }
                        }
                    }else{
                        i--;
                    }
                }
                case 6 -> {
                    if (y - word.length() > 0) {
                        for (int j = 0; j < word.length(); j++) {
                            if (soup[x][y - j] == null){
                                soup[x][y - j] = word.substring(j, j + 1);
                            }
                        }
                    } else {
                        i--;
                    }
                }
                case 7 -> {
                    if (x + word.length() < constants.getSIZE() && y - word.length() > 0) {
                        for (int j = 0; j < word.length(); j++) {
                            if (soup[x + j][y - j] == null){
                                soup[x + j][y - j] = word.substring(j, j + 1);
                            }
                        }
                    } else {
                        i--;
                    }
                }
            }
        }
    }
    public void filler () {
        for (int i = 0; i < soup.length; i++) {
            for (int j = 0; j < soup[0].length; j++) {
                if (soup[i][j] == null) {
                    soup[i][j] = constants.getLETTERS()[(int) (Math.random() * 27)];
                }
            }
        }
    }

    public Boolean wordFound(int i, int j, int i2, int j2){
        for (int k = 0; k < constants.getWORDS().length; k++) {
            if (soup[i][j].equals(constants.getWORDS()[k].substring(0,1)) && soup[i2][j2].equals(constants.getWORDS()[k].substring(constants.getWORDS()[k].length()-1))) {
                deleteWord(i,j, i2, j2);
                wordsFound++;
                return true;
            }
        }
        return false;
    }

    public void deleteWord(int i, int j, int i2, int j2) {
        // I need to know the direction of the word to delete it from the array and put it upper case in the soup
        if (i == i2) {
            if (j < j2) {
                for (int k = j; k <= j2; k++) {
                    soup[i][k] = soup[i][k].toUpperCase(Locale.ROOT);
                }
            } else {
                for (int k = j2; k <= j; k++) {
                    soup[i][k] = soup[i][k].toUpperCase(Locale.ROOT);
                }
            }
        } else if (j == j2) {
            if (i < i2) {
                for (int k = i; k <= i2; k++) {
                    soup[k][j] = soup[k][j].toUpperCase(Locale.ROOT);
                }
            } else {
                for (int k = i2; k <= i; k++) {
                    soup[k][j] = soup[k][j].toUpperCase(Locale.ROOT);
                }
            }
        } else if (i < i2 && j < j2) {
            for (int k = 0; k <= i2 - i; k++) {
                soup[i + k][j + k] = soup[i + k][j + k].toUpperCase(Locale.ROOT);
            }
        } else if (i < i2 && j > j2) {
            for (int k = 0; k <= i2 - i; k++) {
                soup[i + k][j - k] = soup[i + k][j - k].toUpperCase(Locale.ROOT);
            }
        } else if (i > i2 && j < j2) {
            for (int k = 0; k <= i - i2; k++) {
                soup[i - k][j + k] = soup[i - k][j + k].toUpperCase(Locale.ROOT);
            }
        } else if (i > i2 && j > j2) {
            for (int k = 0; k <= i - i2; k++) {
                soup[i - k][j - k] = soup[i - k][j - k].toUpperCase(Locale.ROOT);
            }
        }
    }
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < soup.length; i++) {
            for (int j = 0; j < soup[0].length; j++) {
                result += soup[i][j] + " ";
            }
            result += " \n";
        }
        return result;
    }
}