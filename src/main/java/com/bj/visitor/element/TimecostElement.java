package com.bj.visitor.element;

public class TimecostElement implements Comparable {
    private String clazz;
    private String method;
    private String timecost;

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getTimecost() {
        return timecost;
    }

    public void setTimecost(String timecost) {
        this.timecost = timecost;
    }
    @Override
    public int compareTo(Object o) {

        if (this.getTimecost().length() != ((TimecostElement) o).getTimecost().length()) {
            return ((TimecostElement) o).getTimecost().length() - timecost.length();
        } else {
            return ((TimecostElement) o).getTimecost().compareTo(timecost);
        }
    }

}
