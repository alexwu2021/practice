package com.docmatter.ims.setting;

public class MeasuredOperation {

    private int id;
    private ActionTargetSetting actionTargetSetting;
    private ActionSetting actionSetting;

    public MeasuredOperation(int id){ this.id = id;}

    public MeasuredOperation(ActionTargetSetting actionTargetSetting,
            ActionSetting actionSetting){
        this.actionTargetSetting = actionTargetSetting;
        this.actionSetting = actionSetting;
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public ActionSetting getActionSetting(){
        return this.actionSetting;
    }
    public void setActionSetting(ActionSetting actionSetting){
        this.actionSetting = actionSetting;
    }

    public String getRepr() {
        return this.actionTargetSetting.getName() + "_" +this.actionSetting.getName();
    }
}
