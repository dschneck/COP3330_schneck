public class Encrypter {

    public String encrypt(String toEncrypt) {
        char pos;
        char [] tmp = toEncrypt.toCharArray();
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

        toEncrypt = String.valueOf(toReturn);
        return toEncrypt;
    }

    private char convert(char Char) {
        int num = (int) Char;

        num = (num - '0' + 7) % 10;
        Char = (char) (num + '0');

        return Char;

    }
}
