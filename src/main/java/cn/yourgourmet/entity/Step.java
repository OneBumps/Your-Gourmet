package cn.yourgourmet.entity;

import org.apache.ibatis.type.Alias;

/**
 * 用户实体类 步骤表
 */
@Alias("Step")
public class Step implements java.io.Serializable {
    private static final long serialVersionUID = -5282171077986990660L;
    private Integer recipeId;
    private Integer stepNumber;
    private String stepImage;
    private String stepDescription;

    public Step() {
    }

    /**
     * @param recipeId          菜谱Id
     * @param stepNumber            步骤Id
     * @param stepImage 步骤图片位置
     * @param stepDescription   步骤描述
     */
    public Step(Integer recipeId, Integer stepNumber, String stepImage, String stepDescription) {
        this.recipeId = recipeId;
        this.stepNumber = stepNumber;
        this.stepImage = stepImage;
        this.stepDescription = stepDescription;
    }

    /**
     * @return 菜谱Id
     */
    public Integer getRecipeId() {
        return recipeId;
    }

    /**
     * @param recipeId 菜谱Id
     */
    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    /**
     * @return 步骤Id
     */
    public Integer getStepNumber() {
        return stepNumber;
    }

    /**
     * @param stepNumber 步骤Id
     */
    public void setStepNumber(Integer stepNumber) {
        this.stepNumber = stepNumber;
    }

    /**
     * @return 步骤图片位置
     */
    public String getStepImage() {
        return stepImage;
    }

    /**
     * @param stepImage 步骤图片位置
     */
    public void setStepImage(String stepImage) {
        this.stepImage = stepImage;
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

    @Override
    public String toString() {
        return "Step{" +
                "recipeId=" + recipeId +
                ", stepId=" + stepNumber +
                ", stepImageLocation='" + stepImage + '\'' +
                ", stepDescription='" + stepDescription + '\'' +
                '}';
    }
}

