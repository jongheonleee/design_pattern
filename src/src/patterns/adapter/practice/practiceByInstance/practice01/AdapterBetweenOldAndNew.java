package patterns.adapter.practice.practiceByInstance.practice01;

import patterns.adapter.practice.practiceByInstance.practice01.OldCalendar;
import patterns.adapter.practice.practiceByInstance.practice01.NewCalendar;
public class AdapterBetweenOldAndNew implements NewCalendar {
    private OldCalendar oc = new OldCalendar();

    @Override
    public void printDateDot(int year, int month, int day) {
        oc.splitDotForDate(year, month, day);
    }

    @Override
    public void printDateSlash(int year, int month, int day) {
        oc.splitSlashForDate(year, month, day);
    }

    @Override
    public void printDateDash(int year, int month, int day) {
        oc.splitDashForDate(year, month, day);
    }
}
