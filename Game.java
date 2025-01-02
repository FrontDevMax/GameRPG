import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
	private final Scanner sc = new Scanner(System.in);
	private GameCharacter[] characters = new GameCharacter[3];	
	private Timer timer = new Timer();
	private boolean isAlive = true;

	public void showGame() {
		initializionCharacters();
		displayCharacters();
		chooseCharacter();
		startGame();
		// findWinner();
	}

	private void displayCharacters() {
		System.out.println("ПЕРСОНАЖИ\n");
		Description[] desc = Description.values();
		for(Description d : desc) {
			System.out.println(d.getInfo() + "\n");
		}

	}

	private void chooseCharacter() {
		int index = 0, userCharacter;
		do {
			System.out.print("Введите цифру, чтобы выбрать персонажа: ");
			userCharacter = sc.nextInt();
			//characters[index] = arrCharacters[userCharacter - 1];
			System.out.println(characters[0].getHealth());
			index++;
		} while(index == 2);
	}

	private void initializionCharacters() {
		characters[0] = new Warrior(100, 5, "Воин");
		characters[1] = new Wizard(110, 8, "Волшебник");
		characters[2] = new Archer(95, 11, "Лучник");
	}

	private void startGame() {
		System.out.println("Битва началась!\n");
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				if(isAlive) {
					if(characters[0].getHealth() <= 0 || characters[1].getHealth() <= 0) {
						System.out.println("кто то умер");
						isAlive = false;
					} else {
						String act1 = randomAction(characters[0]);
						String act2 = randomAction(characters[1]);
						minusHP(act1, act2);
						System.out.println(characters[0].getName() + "\nЗдоровье: " + characters[0].getHealth() + "\nИспользовал: " + act1 + "\n");
						System.out.println(characters[1].getName() + "\nЗдоровье: " + characters[1].getHealth() + "\nИспользовал: " + act2 + "\n");
					}
				}
			}
		}, 0, 2000);
	}

	private String randomAction(GameCharacter character) {
		String[] actions = {"защита", "атака"};
		return actions[(int) (Math.random() * actions.length)];
	}

	private void minusHP(String act1, String act2) {
		if(act1.equalsIgnoreCase("атака") && act2.equalsIgnoreCase("атака")) {
			int health1 = characters[0].getHealth() - characters[1].getDamage();
			characters[0].setHealth(health1);
			int health2 = characters[1].getHealth() - characters[0].getDamage();
			characters[1].setHealth(health2);
		} 
	}
}