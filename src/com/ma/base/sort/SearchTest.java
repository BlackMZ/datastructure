package com.ma.base.sort;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author: John.ma
 * @Description:
 * @Date: 2019/8/6 17:33
 */
public class SearchTest {

    public static void main(String[] args) {
        int[] a = {2, 12, 23, 26, 34, 56, 89, 98, 128, 145, 225, 275, 290, 356, 458, 587};
        int i = halfSearch(a, 458);
        System.out.println(i);

        getDayOfWeekWithinDateInterval("2019-08-13", "2019-08-25",0).forEach(s -> System.out.println(s));
        System.out.println("----------------------");
        getDayOfWeekWithinDateInterval("2019-08-13", "2019-08-25",1).forEach(s -> System.out.println(s));
        System.out.println("----------------------");
        getDayOfWeekWithinDateInterval("2019-08-13", "2019-08-25",2).forEach(s -> System.out.println(s));
        System.out.println("----------------------");
        getDayOfWeekWithinDateInterval("2019-08-13", "2019-08-25",3).forEach(s -> System.out.println(s));
        System.out.println("----------------------");
        getDayOfWeekWithinDateInterval("2019-08-13", "2019-08-25",4).forEach(s -> System.out.println(s));
        System.out.println("----------------------");
        getDayOfWeekWithinDateInterval("2019-08-13", "2019-08-25",5).forEach(s -> System.out.println(s));
        System.out.println("----------------------");
        getDayOfWeekWithinDateInterval("2019-08-13", "2019-08-25",6).forEach(s -> System.out.println(s));
    }

    public static int halfSearch(int[] a, int key) {
        int low = 0;
        int high = a.length;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] > key) {
                high = mid - 1;
            }
            if (a[mid] < key) {
                low = mid + 1;
            }
            if (a[mid] == key) {
                return  a[mid];
            }
        }
        return -1;
    }

    /**
     * 获取某段时间内的周一（二等等）的日期
     * @param dataBegin 开始日期
     * @param dataEnd 结束日期
     * @param weekDays 获取周几，1－6代表周一到周六。0代表周日
     * @return 返回日期List
     */
    public static List<String> getDayOfWeekWithinDateInterval(String dataBegin, String dataEnd, int weekDays) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> dateResult = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        String[] dateInterval = {dataBegin, dataEnd};
        Date[] dates = new Date[dateInterval.length];
        for (int i = 0; i < dateInterval.length; i++) {
            String[] ymd = dateInterval[i].split("[^\\d]+");
            cal.set(Integer.parseInt(ymd[0]), Integer.parseInt(ymd[1]) - 1, Integer.parseInt(ymd[2]));
            dates[i] = cal.getTime();
        }
        for (Date date = dates[0]; date.compareTo(dates[1]) <= 0; cal.add(Calendar.DATE, 1) , date = cal.getTime()) {
            cal.setTime(date);
            if (cal.get(Calendar.DAY_OF_WEEK) - 1 == weekDays) {
                String format = sdf.format(date);
                dateResult.add(format);
            }
        }
        return dateResult;
    }
}
