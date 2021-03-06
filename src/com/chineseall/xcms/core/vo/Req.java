package com.chineseall.xcms.core.vo;

import java.util.List;
import java.util.Map;

public abstract class Req {
    
    private final String symbolName;
    private final Class<?> entityClass;
    
    public Req(String symbolName, Class<?> entityClass) {
        
        this.symbolName = symbolName;
        this.entityClass = entityClass;
    }

    /**
     * @return 标志名称，一般为不含路径的类名称
     */
    public String getSymbolName() {
        return symbolName;
    }

    /**
     * @return 获取后台实体类，为Domain或者Map
     */
    public Class<?> getEntityClass() {
        return entityClass;
    }
    
    /**
     * @return 查询实体类名称，为DomainName或者symbolName
     */
    public String getEntityClassName() {
        return Map.class.isAssignableFrom(entityClass) ? symbolName : entityClass.getName();
    }
    
    public List<DisField> getCreateFields() {
        return this.getDetailFields();
    }
    public List<DisField> getUpdateFields() {
        return this.getDetailFields();
    }
    public List<DisField> getQueryFields() {
        return this.getSummaryFields();
    }
    
    public abstract List<DisField> getIdFields();
    public abstract List<DisField> getDetailFields();
    public abstract List<DisField> getSummaryFields();
    
}
