package io.github.taimoor.workoutTrainer.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RequestBody {

    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("prompt")
    @Expose
    private String prompt;
    @SerializedName("max_tokens")
    @Expose
    private Integer maxTokens;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Integer getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
    }
}
