import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ToDo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tasks = new String[100];
        int count = 0;

        try {
            File f = new File("tasks.txt");
            if (f.exists()) {
                Scanner fr = new Scanner(f);
                while (fr.hasNextLine()) {
                    String line = fr.nextLine().trim();
                    if (!line.equals("")) {
                        tasks[count] = line;
                        count++;
                    }
                }
                fr.close();
            }
        } catch (Exception e) {}

        while (true) {
            System.out.print("\n1. View all tasks\n2. Add a task\n3. Remove a task\n4. Exit\nEnter your choice: ");
            int ch = sc.nextInt();

            if (ch == 1) {
                if (count == 0) System.out.println("No tasks");
                else for (int i = 0; i < count; i++)
                    System.out.println((i + 1) + "-" + tasks[i]);
            }
            if (ch == 2) {
                System.out.print("Task: ");
                tasks[count] = sc.nextLine();
                count++;
                try {
                    FileWriter w = new FileWriter("tasks.txt");
                    for (int i = 0; i < count; i++)
                        w.write(tasks[i] + "\n");
                    w.close();
                } catch (Exception e) {}
            }
            if (ch == 3) {
                System.out.print("Number: ");
                int n = Integer.parseInt(sc.nextLine());
                for (int i = n - 1; i < count - 1; i++) tasks[i] = tasks[i + 1];
                count--;
                try {
                    FileWriter w = new FileWriter("tasks.txt");
                    for (int i = 0; i < count; i++) w.write(tasks[i] + "\n");
                    w.close();
                } catch (Exception e) {}
            }
            if (ch == 4) break;
        }
    }
}
