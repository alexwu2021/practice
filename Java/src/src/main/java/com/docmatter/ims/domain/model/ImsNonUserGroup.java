package com.docmatter.ims.domain.model;

import com.docmatter.ims.util.MathUtil;

public class ImsNonUserGroup {
    private long id;
    public long getId(){
        return MathUtil.encodeForEntity(this.ctxTypeId, this.ctxId);
    }

    private int ctxTypeId;
    public int getCtxTypeId(){
        return this.ctxTypeId;
    }
    public void setCtxTypeId(int val){
        this.ctxTypeId = val;
    }

    private int ctxId;
    public int getCtxId(){
        return this.ctxId;
    }
    public void setCtxId(int val){
        this.ctxId = val;
    }

    private boolean isProductGroup;
    public boolean getProductGroup(){
        return this.isProductGroup;
    }
    public void setProductGroup(boolean isProductGroup){
        this.isProductGroup = isProductGroup;
    }


}
