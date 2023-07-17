package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {
    private final String PATTERN = "^\\d{2}\\.\\d{2}$";
    public Map<MyDate, Integer> steps = new HashMap<>();
    public Integer goal;

    public void addGoal(Integer val) throws ProgramException {
        if (val <= 0) {
            throw new ProgramException("Целевое количество шагов должно быть целым положительным.");
        }
        this.goal = val;
    }

    public void addSteps(String val, Integer step) throws ProgramException {
        if (!val.matches(PATTERN)) {
            System.out.println(ErrorData.DATE_ERROR.getValue());
            throw new ProgramException(ErrorData.DATE_ERROR.getValue());
        }
        String[] tmp = val.split("\\.");
        steps.put(new MyDate(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])), step);
    }

    public void getStats() {
        Integer stepsDone = 0;

        HashSet<Integer> months = new HashSet(steps.keySet().stream().map(x -> x.month).distinct()
                .collect(Collectors.toList()));

        for (Integer month : months) {
            stepsDone = steps.keySet().stream()
                    .filter(x -> x.getMonth() == month)
                    .map(x -> this.steps.get(x)).mapToInt(x -> x).sum();
            System.out.println("За " + month + " месяц пройдено" + stepsDone + " шагов.");

            if (stepsDone >= this.goal)
                System.out.println("Цель по шагам достигнута");
            else
                System.out.println("Цель по шагам НЕ достигнута");
        }
    }
}
