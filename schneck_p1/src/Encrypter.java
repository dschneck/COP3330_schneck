// This class contains the instance method
// used to encrypt a 4-digit string
public class Encrypter {

    public String encrypt(String toEncrypt) {
        char pos; // Holds the value of the encrpted digit
        char [] tmp = toEncrypt.toCharArray();  // Converts the string into an array
                                                // of characters to access individual digits
        char [] toReturn = new char[4]; // Serves as a temporary array for the return string
        int i = 0; // Keeps track of index, corresponds with i+1 digit

        while (i < 4) {
            pos = convert(tmp[i]); // Passes in the i+1th digit to the convert method

            // Swaps the 1st digit with the 3rd
            // and the 2nd digit with the 4th
            if (i == 0) toReturn[2] = pos;
            if (i == 1) toReturn[3] = pos;
            if (i == 2) toReturn[0] = pos;
            if (i == 3) toReturn[1] = pos;

            i++;
        }

        toEncrypt = String.valueOf(toReturn);   // Converts the array of characters back to
                                                // a string
        return toEncrypt;
    }

    // Method that encrypts an individual
    // digit
    private char convert(char Char) {
        int num = (int) Char;

        num = (num - '0' + 7) % 10; // Subtracts '0' to get the integer value and the
                                    // rest is as instructed
        Char = (char) (num + '0'); // Translates it back to ASCII value by adding '0'

        return Char;

    }
}
