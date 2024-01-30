package patterns.adapter.practice.practiceByClass.practice01;

public class AdapterBetweenOldAndNew extends OldCalendar implements NewCalendar{

    @Override
    public void printDateDot(int year, int month, int day) {
        splitDotForDate(year, month, day);
    }

    @Override
    public void printDateSlash(int year, int month, int day) {
        splitSlashForDate(year, month, day);
    }

    @Override
    public void printDateDash(int year, int month, int day) {
        splitDashForDate(year, month, day);
    }
}
