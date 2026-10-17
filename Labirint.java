import java.util.Scanner;

public class Labirint {
	static int[][] labirint = {
		{1, 0, 1, 1, 1},
		{1, 0, 0, 1, 1},
		{1, 0, 0, 0, 1},
		{1, 1, 1, 0, 1}
	};
	static char[][] gameStatus = {
		{'-', '*', '-', '-', '-'},
		{'-', '-', '-', '-', '-'},
		{'-', '-', '-', '-', '-'},
		{'-', '-', '-', '-', '-'},
		{'-', '-', '-', '-', '-'}
	};
	static int stepCount = 0;

	public static void main(String[] args) {
		showStatus();
	}


	public static void showStatus() {
		for (int i = 0; i < gameStatus.length; ++i) {
			for (int j = 0; j < gameStatus[i].length; ++j) {
				System.out.print(gameStatus[i][j]);
			}
			System.out.println();
		}
	}

	public static String inputDirection() {
		while (true) {
			System.out.println("ВВедите направление :");
			Scanner sc = new Scanenr(System.in);
			String direction = sc.nextLine();

			if (direction.equals("u") || direction.equals("d") || direction.equals("l") || direction.equals("r") ||
			direction.equals("u") || direction.equals("d") || direction.equals("l") || direction.equals("r")) {
				stepCount += 1;
				return direction;
			} else {
				System.out.print("Вы ввели неправильную букву(допустимы U, D, L, R)!");
				stepCount += 1;
			}
		}
		return null;
	}
	// опеределение струкртуры данных
	// отрисовка текущего состояния
	// ввод направления
	// пересчет позиции и состояния
}