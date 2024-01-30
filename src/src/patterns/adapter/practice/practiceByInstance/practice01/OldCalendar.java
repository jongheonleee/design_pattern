package patterns.adapter.practice.practiceByInstance.practice01;

public class OldCalendar {
    void splitDotForDate(int year, int month, int day) {
        System.out.println(year + "." + month + "." + day);
    }

    void splitSlashForDate(int year, int month, int day) {
        System.out.println(year + "/" + month + "/" + day);
    }

    void splitDashForDate(int year, int month, int day) {
        System.out.println(year + "-" + month + "-" + day);
    }
}
