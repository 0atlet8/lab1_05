import java.util.Scanner;

public class Labirint {
	//схема лабиринта
	static int[][] labirint = {
		{1, 0, 1, 1, 1},
		{1, 0, 0, 1, 1},
		{1, 0, 0, 0, 1},
		{1, 1, 1, 0, 1}
	};

	//состояние игрока
	static char[][] gameStatus = {
		{'-', '*', '-', '-', '-'},
		{'-', '-', '-', '-', '-'},
		{'-', '-', '-', '-', '-'},
		{'-', '-', '-', '-', '-'},
		{'-', '-', '-', '-', '-'}
	};
	static int rowPosition = 0;
	static int columnPosition = 1;
	static int rowExit = 4;
	static int columnExit = 3;
	static int stepCount = 0;

	public static void main(String[] args) {
		while(true) {
			showStatus();//                       отрисовали
			String direction = inputDirection();//спросили направление
			char wall = '\u2588';
			//обработка команды
			switch(direction) {
				case "u"://switch выполняет операции последовательно и постоянно будет пытаться выполнить следующий if, поэтому нужно его успокоить break'ом
				case "U": 
					if (rowPosition > 0) {
						if (labirint[rowPosition-1][columnPosition] == 0) {
							gameStatus[rowPosition][columnPosition] = '#';
							--rowPosition;
							gameStatus[rowPosition][columnPosition] = '*';
						} else {
							gameStatus[rowPosition - 1][columnPosition] = wall;
						}
					}
					break;
				case "d":
				case "D": 
					if (rowPosition < labirint.length - 1) { 
						if (labirint[rowPosition+1][columnPosition] == 0) {
							gameStatus[rowPosition][columnPosition] = '#';
							++rowPosition;
							gameStatus[rowPosition][columnPosition] = '*';
						} else {
							gameStatus[rowPosition + 1][columnPosition] = wall;
						}
					}
					break;
				case "r":
				case "R": 
					if (columnPosition < labirint[0].length - 1){ 
						if (labirint[rowPosition][columnPosition + 1] == 0) {
							gameStatus[rowPosition][columnPosition] = '#';
							++columnPosition;
							gameStatus[rowPosition][columnPosition] = '*';
						} else {
							gameStatus[rowPosition][columnPosition + 1] = wall;
						}
					}
					break;
				case "l":
				case "L": 
					if (columnPosition < 0) {
						if (labirint[rowPosition][columnPosition - 1] == 0) {
							gameStatus[rowPosition][columnPosition] = '#';
							--columnPosition;
							gameStatus[rowPosition][columnPosition] = '*';
						} else {
							gameStatus[rowPosition][columnPosition - 1] = wall;

						}
					}
			}

			//проверка победы
			if (rowExit == rowPosition && columnExit == columnPosition) {
				System.out.println("Победа за" + stepCount + "шагов");
				showStatus();

				break;
			}
		}
	}

	//отображение текущей позиции
	public static void showStatus() {
		for (int i = 0; i < gameStatus.length; ++i) {
			for (int j = 0; j < gameStatus[i].length; ++j) {
				System.out.print(gameStatus[i][j]);
			}
			System.out.println();
		}
	}

	//ввод направления
	public static String inputDirection() {
		while (true) {
			System.out.println("ВВедите направление :");
			Scanner sc = new Scanner(System.in);
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
	}

	// опеределение струкртуры данных
	// отрисовка текущего состояния
	// ввод направления
	// пересчет позиции и состояния
}