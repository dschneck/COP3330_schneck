// This class contains the instance method
// used to decrypt a 4-digit string
public class Decrypter {

    public String decrypt(String toDecrypt) {
        char pos; // Holds the value of the encrypted digit
        char [] tmp = toDecrypt.toCharArray();  // Converts the string into an array
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

        toDecrypt = String.valueOf(toReturn);   // Converts the array of characters back to
                                                // a string
        return toDecrypt;
    }

    // Method that decrypts an individual
    // digit
    private char convert(char Char) {
        int num = (int) Char;
        int diff = num -'0' - 7;    //Subtracts '0' to get the integer value and the
                                    // rest is as instructed

        if (diff < 0) { // We can only work with digits from 0 to 9
            Char = (char) (diff + 10 + '0');    // Translates it back to ASCII value by adding '0'
                                                // and the 10 offsets it back to something within
                                                // our range
            return Char;
        }

        Char = (char) (diff + '0'); // Translates it back to ASCII value by adding '0'
        return Char;
    }

}
