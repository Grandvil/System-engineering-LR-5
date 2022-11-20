import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите число:");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        try (FileWriter writer = new FileWriter("output2.txt", false)) {
            String text = findPrimeNumbers(number).toString();
            writer.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List findPrimeNumbers(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        for (int i = 2; i * i < n; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i)
                    primes[j] = false;
            }
        }

        List primeNumbers = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (primes[i])
                primeNumbers.add(i);
        }
        return primeNumbers;
    }
}

