package patterns.adapter.practice.practiceByClass.practice01;

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
