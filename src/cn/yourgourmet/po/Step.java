package cn.yourgourmet.po;

/**
 * 用户实体类 步骤表
 */
public class Step implements java.io.Serializable {
    private static final long serialVersionUID = -5282171077986990660L;
    private int recipeId;
    private int stepId;
    private String stepImageLocation;
    private String stepDescription;

    public Step() {
    }

    /**
     * @param recipeId          菜谱Id
     * @param stepId            步骤Id
     * @param stepImageLocation 步骤图片位置
     * @param stepDescription   步骤描述
     */
    public Step(int recipeId, int stepId, String stepImageLocation, String stepDescription) {
        this.recipeId = recipeId;
        this.stepId = stepId;
        this.stepImageLocation = stepImageLocation;
        this.stepDescription = stepDescription;
    }

    /**
     * @return 菜谱Id
     */
    public int getRecipeId() {
        return recipeId;
    }

    /**
     * @param recipeId 菜谱Id
     */
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    /**
     * @return 步骤Id
     */
    public int getStepId() {
        return stepId;
    }

    /**
     * @param stepId 步骤Id
     */
    public void setStepId(int stepId) {
        this.stepId = stepId;
    }

    /**
     * @return 步骤图片位置
     */
    public String getStepImageLocation() {
        return stepImageLocation;
    }

    /**
     * @param stepImageLocation 步骤图片位置
     */
    public void setStepImageLocation(String stepImageLocation) {
        this.stepImageLocation = stepImageLocation;
    }

    /**
     * @return 步骤描述
     */
    public String getStepDescription() {
        return stepDescription;
    }

    /**
     * @param stepDescription 步骤描述
     */
    public void setStepDescription(String stepDescription) {
        this.stepDescription = stepDescription;
    }
}

