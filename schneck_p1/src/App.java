import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Encrypter myEncrypter = new Encrypter();
        Decrypter myDecrypter = new Decrypter();

        System.out.println("Input 4 digits (NO SPACES): ");
        String x = scanner.nextLine();

        String encryptedValue = myEncrypter.encrypt(x);
        System.out.println( "Encrypted Value = " + encryptedValue);

        String decryptedValue = myDecrypter.decrypt(encryptedValue);
        System.out.println( "Decrypted Value = " + decryptedValue);

        System.out.println("Input 4 digits (NO SPACES): ");
        String y = scanner.nextLine();

        String a = myDecrypter.decrypt(y);
        System.out.println(a);

        String b = myEncrypter.encrypt(a);
        System.out.println(b);


    }
}


