import java.util.Scanner;

public interface App{
    // Fields
    //public String appName;
    //public T list;
    //public static Scanner scanner ;//= new Scanner(System.in);

    // Methods
    public void Start();

    public void MainMenu();

    public void printMainMenu();

    public void ListOperationsMenu();

    public void printListOperationsMenu();

    // Operations
    public void AddItem();
    public void EditItem();
    public void RemoveItem();
    public void ViewList();
    public void ClearList();

    public void SaveCurrentList();
    public void LoadFile(String filename);
}