package model;

public class Interaction {
    String shortDesc;
    String interaction;
    boolean condition;
    String conditionComment;
    boolean isInteractedWith = false;

    public Interaction(String shortDesc, String interaction, boolean condition, String conditionComment) {
        this.shortDesc = shortDesc;
        this.interaction = interaction;
        this.condition = condition;
        this.conditionComment = conditionComment;

    }

    public void changeInteracted(boolean i) {
        isInteractedWith = i;
    }

    // getters
    public String getShortDesc() {
        return shortDesc;
    }

    public String getInteraction() {
        System.out.println(interaction);
        return interaction;
    }

    public boolean getCondition() {
        return condition;
    }

    public String getConditionComment() {
        return conditionComment;
    }

    public boolean getIsInteractedWith() {
        return isInteractedWith;
    }
}
