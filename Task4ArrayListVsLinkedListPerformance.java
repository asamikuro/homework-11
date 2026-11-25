
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Task4ArrayListVsLinkedListPerformance {

    public static void main(String[] args) {
        System.out.println("================ БЕНЧМАРК ТА РОБОТА ЗІ СПИСКАМИ ================");

        int n = 20000;

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.add(0, i);
        }
        double arrayStartTime = (System.nanoTime() - start) / 1000000.0;

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList.add(0, i);
        }
        double linkedStartTime = (System.nanoTime() - start) / 1000000.0;

        System.out.println("1. БЕНЧМАРК ВСТАВКИ У ПОЧАТОК СПИСКУ (на " + n + " елементів):");
        System.out.printf("ArrayList: %.2f мс | LinkedList: %.2f мс%n",
                arrayStartTime, linkedStartTime);

        System.out.println(linkedStartTime < arrayStartTime
                ? " (Висновок: LinkedList виграє при вставках на початку)."
                : " (Висновок: ArrayList виявився швидшим).");

        arrayList.clear();
        linkedList.clear();

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.add(arrayList.size() / 2, i);
        }
        double arrayMiddleTime = (System.nanoTime() - start) / 1000000.0;

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList.add(linkedList.size() / 2, i);
        }
        double linkedMiddleTime = (System.nanoTime() - start) / 1000000.0;

        System.out.println("\nВставка в середину:");
        System.out.printf("ArrayList: %.2f мс | LinkedList: %.2f мс%n",
                arrayMiddleTime, linkedMiddleTime);

        System.out.println();
        System.out.println("2. СОРТУВАННЯ СПИСКУ:");
        List<Integer> numbers = new ArrayList<>(
                List.of(45, 12, 89, 3, 22, 67));

        System.out.println("До сортування: " + numbers);
        Collections.sort(numbers);
        System.out.println("Після сортування: " + numbers);

        System.out.println();
        System.out.println("3. РОБОТА З subList():");
        System.out.println(" Оригінальний список: " + numbers);

        List<Integer> sub = numbers.subList(1, 4);

        System.out.println("subList: " + sub);

        sub.set(0, 999);

        System.out.println("Оригінальний список після зміни: " + numbers);
        System.out.println("subList після зміни: " + sub);
    }
}
