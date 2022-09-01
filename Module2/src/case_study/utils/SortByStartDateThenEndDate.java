package case_study.utils;

import case_study.model.Booking;

import java.util.Comparator;

public class SortByStartDateThenEndDate implements Comparator<Booking> {

    @Override
    public int compare(Booking o1, Booking o2) {
        int comparison;
        comparison = o1.getStartDay().compareTo(o2.getStartDay());
        if (comparison == 0) {
            comparison = o1.getEndDay().compareTo(o2.getEndDay());
        }
        return comparison;
    }
}
