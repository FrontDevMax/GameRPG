public abstract class GameCharacter {
	private int health;
	private int damage;
	private String name;

	public GameCharacter(int health, int damage, String name) {
		this.health = health;
		this.damage = damage;
		this.name = name;
	}

	public int getHealth() {
		return this.health;
	}

	public int setHealth(int health) {
		return this.health = health;
	}

	public int getDamage() {
		return this.damage;
	}

	public String getName() {
		return this.name;
	}
}