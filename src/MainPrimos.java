import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface NumeroPrimoLambda {
	public Runnable primo(Integer i);
}

public class MainPrimos {

	public static void main(String[] args) {
		int num1, num2, num3;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Bienvenido al Sistema de Adivinación de Números Primos de la empresa Pando");
			System.out.println(
					"\nA continuación, introduce 3 números por pantalla para saber si se tratan de números primos o no: ");
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			num3 = sc.nextInt();
		}
		System.out.println("Números introducidos, procediendo a averiguar si son primos...");

		NumeroPrimoLambda numeroPrimo = num -> {
			boolean esPrimo = true;
			int cont = 2;
			while (cont != num && esPrimo) {
				if (num % cont == 0) {
					esPrimo = false;
				}
				cont++;
			}
			if (esPrimo) {
				System.out.println(num + " es un número primo !!");
			} else {
				System.out.println(num + " no es un número primo :(");
			}
			return null;
		};

		Thread t1 = new Thread(numeroPrimo.primo(num1));
		Thread t2 = new Thread(numeroPrimo.primo(num2));
		Thread t3 = new Thread(numeroPrimo.primo(num3));

		t1.start();
		t2.start();
		t3.start();
	}
}
