package com.chineseall.xcms.core.vo;

public abstract class DisField {
    private String symbolName;
    private String disName;
    
    public String getSymbolName() {
        return symbolName;
    }

    public void setSymbolName(String symbolName) {
        this.symbolName = symbolName;
    }

    public String getDisName() {
        return disName;
    }

    public void setDisName(String disName) {
        this.disName = disName;
    }

    public abstract Object getValue(Object obj);
}
