package main;

public enum MenuChoice {
    ACTION_MAIN_MENU("Что вы хотите сделать? " + System.lineSeparator() +
            "  1. Ввод цели по количеству шагов в день." + System.lineSeparator() +
            "  2. Ввод пройденного количества шагов за день." + System.lineSeparator() +
            "  3. Вывод статистики за определённый месяц." + System.lineSeparator() +
            "  4. Выход."),
    DATA_GET_DATE("Введите учетную дату в формате dd.MM"),
    DATA_GET_STEP("Введите количество шагов:"),
    STEPS_FACT_GET("Введите количество фактически пройденых шагов:"),
    STEPS_GOAL_GET("Введите цель по количеству шагов в день:");

    private String value;

    MenuChoice(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
