# XCMS #

基于Nutz和Beetl的通用CMS，包含基本的单表增删改查。

## URL ##
- http://domain.com/ 列表页面
- http://domain.com/get/{domainSymbol}/{id} 详情页面
- http://domain.com/add-form/{domainSymbol} 新建记录表单页面
- http://domain.com/add/{domainSymbol} 执行添加记录操作，一般为表单提交用
- http://domain.com/mod-form/{domainSymbol}/{id} 修改记录表单页面
- http://domain.com/mod/{domainSymbol}/{id} 修改记录操作，一般为表单提交用
- http://domain.com/del/{domainSymbol}/{id} 删除记录
- http://domain.com/qry/{domainSymbol} 查询页面

> {domainSymbol} 为实体类在网页上的标志符<br>
> {id} 为数据记录在数据库中的主键

## 基本流程 ##
    用户			Module		Prcss		ClsMpr		DaoFcty		TplRepo		Render
     | 发起请求    |           |           |            |           |           |
	 |----------->|           |           |            |           |           |
     |            |  执行请求  |           |            |           |           |
     |            |---------->|           |            |           |           |
     |            |           |  查询实体  |            |           |           |
     |            |           |<--------->|            |           |           |
     |            |           |  获取实体类对应的DAO     |           |           |
     |            |           |<---------------------->|           |           |
     |            |           |           |            |           |           |
     |            |           |数据操作                 |           |           |
     |            |           |  获取返回网页模板【不存在时系统新建】   |           |
     |            |           |<---------------------------------->|           |
     |            |           |  模板渲染  |            |           |           |
     |            |           |<---------------------------------------------->|
     |            |  返回请求  |           |            |           |           |
     |            |<----------|           |            |           |           |
     |  返回请求   |           |           |            |           |           |
     |<---------- |           |           |            |           |           |
     |            |           |           |            |           |           |
## 系统定制 ##

### AbstractDao ###
数据库操作实体类，部分类的数据库操作需要有单表之外的操作时，新建该类的子类并在class2dao.properties中指定映射关系即可

### 系统样式 ###
系统初次获取请求时会在 TplRepository 中创建对应操作的基本模板，如对 book 的查询操作会触发在 Repository 中创建文件 com.siwei.domain.Book-QryResult.html，进行界面微调时直接修改此处模板即可，删除操作会在下次请求到达时重新生成。

在包 `com.chineseall.xcms.nb.tpl` 中包含 create.html, index.html, info.html, modify.html 和 query-result.html，此模板作用为当TplRepository中找不到对应模板时该模板生成，修改整个系统的界面时修改此处模板。

### 快捷更新 ###
**自定义SQL** 支持虚拟类型以实现自定义SQL快速更新少量字段，基本配置如下：

	class2Dao.properties:
	quick-set-workflow=com.chineseall.xcms.nb.dao.QuickSetDao
	custsql.properties:
	quick-set-workflow=update s_resource set status = ${status} where id = ${id}
	
配置完成浏览器直接访问：http://domain.com/mod/quick-set-workflow/26?id=26&status=1 即可。

### 模板语法 ###
模板基本语法参考 [Beetl](https://github.com/javamonkey/beetl2.0 "Beetl")。

查询模板特例：

    <input id='S_id' name='_EQ_id' type='text' value='${_EQ_id !}' placeholder="id">

name 属性前半部分可以指定后台具体查询操作

- \_GT_ GreateThan
- \_LT_ LittleThan
- \_EQ_ Equal
- \_LK_ Like 
- \_ASC_ 非查询，用于排序，此时value随便，排序列为[ASC]后紧跟部分
- \_DSC_ 非查询，用于排序，此时value随便，排序列为[DSC]后紧跟部分