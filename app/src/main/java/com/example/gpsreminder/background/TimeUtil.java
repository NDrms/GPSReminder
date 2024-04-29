package com.example.gpsreminder.background;

public class TimeUtil {
    public static long millisecondsUntilTime(int hours, int minutes) {
        long currentTimeMillis = System.currentTimeMillis();

        // Получаем текущее время в миллисекундах
        long currentHours = (currentTimeMillis / (1000 * 60 * 60)) % 24;
        long currentMinutes = (currentTimeMillis / (1000 * 60)) % 60;

        // Вычисляем количество миллисекунд до заданного времени
        long hoursDifference = (hours - currentHours) * 60 * 60 * 1000;
        long minutesDifference = (minutes - currentMinutes) * 60 * 1000;

        // Обрабатываем случай, когда указанное время уже прошло
        if (hoursDifference < 0 || (hoursDifference == 0 && minutesDifference < 0)) {
            // Добавляем 24 часа, чтобы получить время на следующий день
            hoursDifference += 24 * 60 * 60 * 1000;
        }

        return hoursDifference + minutesDifference;
    }

    public static void main(String[] args) {
        // Пример использования
        int targetHours = 10;
        int targetMinutes = 30;

        long millisecondsUntilTargetTime = millisecondsUntilTime(targetHours, targetMinutes);
        System.out.println("Milliseconds until " + targetHours + ":" + targetMinutes + ": " + millisecondsUntilTargetTime);
    }
}
