import java.io.FileNotFoundException;
import java.util.Scanner;

public interface App {

    /* Fields */
    public Scanner scanner = new Scanner(System.in);

    /* Methods */
    void MainMenu();
    void printMainMenu();
    void ListOperationsMenu();
    void printListOperations();

    void AddItem();
    void EditItem();
    void RemoveItem();

    void ClearList();
    void ViewList();

    void SaveCurrentList();
    void loadFile();

}