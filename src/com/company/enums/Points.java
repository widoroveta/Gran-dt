package com.company.enums;

public enum Points {

    GOAL_GOALKEEPER(12),GOAL_DEFENDER(9),GOAL_MIDFIELDER(6),GOAL_FORWARD(4),YELLOW_CARD(-2),RED_CARD(-4),MVP(4)
    ,GOALKEEPER_WITHOUT_GOAL(3);
    private int points;
    Points(int points)
    {
        this.points=points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
