public enum Description {
	WARRIOR("1.Воин\n" +
			"Здоровье: 100\n" +
			"Урон: 5\n" + 
			"Защита: 4"),
	WIZARD("2.Волшебник\n" +
			"Здоровье: 110\n" +
			"Урон: 8\n" + 
			"Защита: 2"),
	ARCHER("3.Лучник\n" +
			"Здоровье: 95\n" +
			"Урон: 11\n" + 
			"Защита: 3");

	private String info;

	Description(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}
}