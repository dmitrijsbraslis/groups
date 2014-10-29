package testapp.domain;

public enum GroupCategories {
    DEFAULT(1, "Другое"), AUTO(2, "Авто и мото"), CHILDS(3, "Дети"), DESIGN(4, "Дизайн"), ANIMALS(5, "Животные"), GAMES(6, "Игры"), MOVIES(7, "Кино"), BOOKS(8, "Книги");

    private int category;
    private String text;

    GroupCategories(int category, String text) {
        this.category = category;
        this.text = text;
    }

    public int getCategory() {
        return this.category;
    }

    public String getText() {
        return this.text;
    }
}