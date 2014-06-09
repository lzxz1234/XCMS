package com.chineseall.xcms.nb;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.nutz.lang.Lang;
import org.nutz.lang.Strings;

import com.chineseall.xcms.core.ClassMapper;
import com.chineseall.xcms.core.Http404Exception;
import com.chineseall.xcms.core.Processor;
import com.chineseall.xcms.core.dao.DaoFactory;
import com.chineseall.xcms.core.render.Render;
import com.chineseall.xcms.core.tpl.TplRepository;
import com.chineseall.xcms.core.utils.Ctx;
import com.chineseall.xcms.core.utils.Ctx.Trs;
import com.chineseall.xcms.core.vo.Req;
import com.chineseall.xcms.nb.vo.NutzReq;

public class NutzProcessor implements Processor {
    
    private ClassMapper classMapper;
    private DaoFactory daoFactory;
    private TplRepository tplRepository;
    private Render render;

    @Override
    public String renderIndex() throws Exception {
        
        Map<String, Object> resultContext = new HashMap<String, Object>();
        resultContext.put("symbolList", classMapper.getAllClassSymbols());
        Ctx.translate(new Trs2Map(resultContext));
        return render.reader(tplRepository.getIndexView(classMapper.getAllClassSymbols()), resultContext);
    }
    
    @Override
    public String renderObjInfo(String domainSymbol, long params)
            throws Exception {
        
        Req req = getReq(domainSymbol);
        Object queryObject = daoFactory.getDao(req).get(params);
        if(queryObject == null) throw new Http404Exception();
        
        Map<String, Object> resultContext = new HashMap<String, Object>();
        resultContext.put("domainSymbol", domainSymbol);
        resultContext.put("fieldList", req.getDetailFields());
        resultContext.put("obj", queryObject);
        Ctx.translate(new Trs2Map(resultContext));
        return render.reader(tplRepository.getObjInfoView(req), resultContext);
    }

    @Override
    public String renderAddForm(String domainSymbol) throws Exception {
        
        Req req = getReq(domainSymbol);
        Map<String, Object> resultContext = new HashMap<String, Object>();
        resultContext.put("fieldList", req.getDetailFields());
        resultContext.put("domainSymbol", domainSymbol);
        Ctx.translate(new Trs2Map(resultContext));
        return render.reader(tplRepository.getAddFormView(req), resultContext);
    }

    @Override
    public String doAddAction(String domainSymbol, Map<String, Object> params)
            throws Exception {
        
        Req req = getReq(domainSymbol);
        Object entity = Lang.map2Object(params, req.getEntityClass());
        daoFactory.getDao(req).add(entity);
        Map<String, Object> resultContext = new HashMap<String, Object>();
        Ctx.translate(new Trs2Map(resultContext));
        return render.reader(tplRepository.getAddResultView(req), resultContext);
    }

    @Override
    public String doDelAction(String domainSymbol, long id) throws Exception {
        
        Req req = getReq(domainSymbol);
        daoFactory.getDao(req).del(id);
        Map<String, Object> resultContext = new HashMap<String, Object>();
        Ctx.translate(new Trs2Map(resultContext));
        return render.reader(tplRepository.getDelResultView(req), resultContext);
    }

    @Override
    public String renderModifyForm(String domainSymbol, long params) throws Exception {
 
        if(Strings.isEmpty(domainSymbol)) return "";
        
        Req req = new NutzReq(domainSymbol, classMapper.findClass(domainSymbol));
        Object queryObject = daoFactory.getDao(req).get(params);
        if(queryObject == null) throw new Http404Exception();
        
        Map<String, Object> resultContext = new HashMap<String, Object>();
        resultContext.put("fieldList", req.getDetailFields());
        resultContext.put("domainSymbol", domainSymbol);
        resultContext.put("obj", queryObject);
        resultContext.put("id", params);
        Ctx.translate(new Trs2Map(resultContext));
        return render.reader(tplRepository.getModifyFormView(req), resultContext);
    }

    @Override
    @SuppressWarnings("unchecked")
    public String doModifyAction(String domainSymbol, long id, Map<String, Object> params)
            throws Exception {
        
        Req req = new NutzReq(domainSymbol, classMapper.findClass(domainSymbol));
        Object modifyObject = daoFactory.getDao(req).get(id);
        if(modifyObject == null) throw new Http404Exception();
        
        if(modifyObject instanceof Map)
            ((Map<String, Object>)modifyObject).putAll(params);
        else
            Lang.map2Object(params, modifyObject);
        
        daoFactory.getDao(req).mod(modifyObject);
        
        Map<String, Object> resultContext = new HashMap<String, Object>();
        Ctx.translate(new Trs2Map(resultContext));
        return render.reader(tplRepository.getModifyResultView(req), resultContext);
    }

    @Override
    public String doQueryAction(String domainSymbol, Map<String, String> params)
            throws Exception {
        
        Req req = new NutzReq(domainSymbol, classMapper.findClass(domainSymbol));
        Map<String, Object> resultContext = new HashMap<String, Object>(params);
        resultContext.put("domainSymbol", domainSymbol);
        resultContext.put("idList", req.getIdFields());
        resultContext.put("fieldList", req.getSummaryFields());
        resultContext.put("resultList", daoFactory.getDao(req).qry(params));
        
        resultContext.put("pageSize", Integer.parseInt(params.get("pageSize")));
        resultContext.put("pageNo", Integer.parseInt(params.get("pageNo")));
        resultContext.put("totalCount", daoFactory.getDao(req).cnt(params));
        resultContext.put("queryString", parseIntoQueryString(params));
        
        Ctx.translate(new Trs2Map(resultContext));
        return render.reader(tplRepository.getQueryResultView(req), resultContext);
    }

    private String parseIntoQueryString(Map<String, String> params) {
        
        StringBuilder queryString = new StringBuilder();
        Entry<String, String> entry = null;
        Iterator<Entry<String, String>> it = params.entrySet().iterator();
        while(it.hasNext()) {
            entry = it.next();
            if("pageSize".equals(entry.getKey()) || "pageNo".equals(entry.getKey())) continue;
            queryString.append("&");
            queryString.append(entry.getKey());
            queryString.append("=");
            queryString.append(entry.getValue());
        }
        return queryString.toString();
    }
    
    private Req getReq(String domainSymbol) {
        
        Class<?> entityClass = classMapper.findClass(domainSymbol);
        if(entityClass == null) throw new Http404Exception();
        return new NutzReq(domainSymbol, entityClass);
    }
    
    private static class Trs2Map implements Trs {

        private final Map<String, Object> map;
        public Trs2Map(Map<String, Object> map) {
            this.map = map;
        }
        @Override
        public void trs(String key, Object value) {
            this.map.put(key, value);
        }
        
    }
    
    public void setClassMapper(ClassMapper classMapper) {
        this.classMapper = classMapper;
    }
    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    public void setTplFactory(TplRepository tplRepository) {
        this.tplRepository = tplRepository;
    }
    public void setRender(Render render) {
        this.render = render;
    }
    
}

