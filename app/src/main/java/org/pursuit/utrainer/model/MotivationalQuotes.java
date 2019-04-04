package org.pursuit.utrainer.model;

import java.util.List;

public class MotivationalQuotes {
    private String motivation;
    private String first;
    private String second;
    private String third;

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

    public MotivationalQuotes(String motivation, String first, String second, String third) {
        this.motivation = motivation;
        this.first = first;
        this.second = second;
        this.third = third;
    }


    public class MotivationalResponse{

        private List <MotivationalQuotes> motivational;

        public List<MotivationalQuotes> getMotivational() {
            return motivational;
        }

        public MotivationalResponse(List<MotivationalQuotes> motivational) {
            this.motivational = motivational;
        }
    }
}
