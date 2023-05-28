package io.github.taimoor.workoutTrainer.data;

import java.util.HashMap;
import java.util.Map;

public class Workout {

    public String name;
    public long startTime;
    public long endTime;

    public Workout(String name, long startTime, long endTime){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Map<String, Object> toMap(){
        Map<String, Object> workout = new HashMap<>();
        workout.put("name", name);
        workout.put("startTime", startTime);
        workout.put("endTime", endTime);
        return workout;
    }

}
