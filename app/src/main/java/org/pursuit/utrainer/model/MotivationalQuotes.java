package org.pursuit.utrainer.model;

import java.util.List;

public class MotivationalQuotes {
    private String motivation;
    private String first;
    private String second;
    private String third;
    private String fourth;
    private String fifth;
    private String sixth;
    private String seventh;


    public String getMotivation() {
        return motivation;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    public String getThird() {
        return third;
    }

    public String getFourth() {
        return fourth;
    }

    public String getFifth() {
        return fifth;
    }

    public String getSixth() {
        return sixth;
    }

    public String getSeventh() {
        return seventh;
    }

    public MotivationalQuotes(String motivation, String first, String second, String third, String fourth, String fifth, String sixth, String seventh) {
        this.motivation = motivation;
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.seventh = seventh;
    }

    public class MotivationalResponse {

        private List<MotivationalQuotes> motivational;

        public List<MotivationalQuotes> getMotivational() {
            return motivational;
        }

        public MotivationalResponse(List<MotivationalQuotes> motivational) {
            this.motivational = motivational;
        }
    }
}
