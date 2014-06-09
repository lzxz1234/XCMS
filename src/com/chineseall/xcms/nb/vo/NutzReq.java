package com.chineseall.xcms.nb.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.nutz.castor.Castors;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;

import com.chineseall.xcms.core.vo.DisField;
import com.chineseall.xcms.core.vo.Req;

public class NutzReq extends Req {

    public NutzReq(String symbolName, Class<?> entityClass) {
        super(symbolName, entityClass);
    }

    @Override
    public List<DisField> getDetailFields() {
        
        List<DisField> result = new ArrayList<DisField>();
        for(Field field : this.getEntityClass().getDeclaredFields())
            if(field.getAnnotation(Id.class) != null || field.getAnnotation(Column.class) != null)
                result.add(new FieldInvokeDisField(field.getName(), field));
        return result;
    }

    @Override
    public List<DisField> getSummaryFields() {

        List<DisField> result = new ArrayList<DisField>();
        for(Field field : this.getEntityClass().getDeclaredFields())
            if(field.getAnnotation(Id.class) != null || field.getAnnotation(Column.class) != null)
                result.add(new FieldInvokeDisField(field.getName(), field));
        return result;
    }
    
    public List<DisField> getIdFields() {
        
        List<DisField> result = new ArrayList<DisField>(1);
        for(Field field : this.getEntityClass().getDeclaredFields())
            if((field.getAnnotation(Id.class)) != null) { //TODO 还有@Pk也能指定主键
                result.add(new FieldInvokeDisField("", field));
            }
        return result;
    }
    
    private static class FieldInvokeDisField extends DisField {

        private final Field field;
        public FieldInvokeDisField(String disName, Field field) {
            this.setSymbolName(field.getName());
            this.setDisName(disName);
            this.field = field;
            if(!field.isAccessible()) field.setAccessible(true);
        }
        @Override
        public Object getValue(Object obj) {
            
            try {
                //手动转成String是为了进行Date等类型的格式化
                return Castors.me().castTo(field.get(obj), String.class);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                return null;
            }
        }
    }
}
