package main;

public enum ErrorData {
    FORMAT_ERROR("Не верный формат даты. Формат должен быть DD.MM"),
    DATE_ERROR("Неверная дата"),
    MONTH_ERROR("Неверный месяц");
    private String value;

    ErrorData(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
}
