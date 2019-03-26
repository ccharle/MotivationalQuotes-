package org.pursuit.utrainer.model;

import java.util.List;

public class MotivationalQuotes {
    private String motivation;
    private String first;
    private String second;
    private String third;

    public MotivationalQuotes(String motivation, String first, String second, String third) {
        this.motivation = motivation;
        this.first = first;
        this.second = second;
        this.third = third;
    }



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




    public class MotivationalQuotesResponse {

        private List<MotivationalQuotes> motivationalQuotes;

        public MotivationalQuotesResponse(List<MotivationalQuotes> motivationalQuotes) {
            this.motivationalQuotes = motivationalQuotes;
        }

        public List<MotivationalQuotes> getMotivationalQuotes() {
            return motivationalQuotes;
        }
    }

}
