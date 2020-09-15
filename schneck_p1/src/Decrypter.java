public class Decrypter {
    public String decrypt(String toDecrypt) {
        char pos;
        char [] tmp = toDecrypt.toCharArray();
        char [] toReturn = new char[4];
        int i = 0;

        while (i < 4) {
            pos = convert(tmp[i]);

            if (i == 0) toReturn[2] = pos;
            if (i == 1) toReturn[3] = pos;
            if (i == 2) toReturn[0] = pos;
            if (i == 3) toReturn[1] = pos;

            i++;
        }

        toDecrypt = String.valueOf(toReturn);
        return toDecrypt;
    }

    private char convert(char Char) {
        char ret;
        int num = (int) Char;
        int diff = num -'0' - 7;

        if (diff < 0) {
            Char = (char) (diff + 10 + '0');
            return Char;
        }

        Char = (char) (diff + '0');
        return Char;
    }

}
