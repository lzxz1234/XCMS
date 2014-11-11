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
- http://domain.com/upload/ 文件上传 

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
数据库操作实体类，部分类的数据库操作需要有单表之外的操作时，新建该类的子类即可并用 `Dao` 注解对应的标志即可

### 系统样式 ###
系统初次获取请求时会在 TplRepository 中创建对应操作的基本模板，如对 book 的查询操作会触发在 Repository 中创建文件 com.siwei.domain.Book/QryResult.html，进行界面微调时直接修改此处模板即可，删除操作会在下次请求到达时重新生成。

在包 `com.chineseall.xcms.nb.tpl` 中包含 create.html, index.html, info.html, modify.html 和 query-result.html，此模板作用为当TplRepository中找不到对应模板时该模板生成，修改整个系统的界面时修改此处模板。

### 快捷更新 ###
**自定义SQL** 支持虚拟类型以实现自定义SQL快速更新少量字段，基本配置如下：

	custsql.properties:
	quick-set-workflow=update s_resource set status = ${status} where id = ${id}
	
配置完成浏览器直接访问：http://domain.com/mod/quick-set-workflow/26?id=26&status=1 即可。

### 文件上传 ###
文件上传基本流程为，表单中的 `file` 类型字段会被 js 接管，选择文件后直接在后台上传，完成后在输入框后显示完成标志，同时在表单中添加 `[name]InSession` 隐藏字段，值为文件传到服务器后保存在 `session` 中的基本信息键，后续处理时可以从 `session` 中获取。

发往地址 `/upload/` 的文件会被临时保存到 webroot 下的 temp 文件夹下，然后把  `org.nutz.mvc.upload.TempFile` 类型的文件对象放到 session 中，同时把 key 以 json 的形式返回到客户端。

附例：[AutoSolveFileDao](https://gist.github.com/lzxz1234/f6253ae3a0f79ed33061 "AutoSolveFileDao")

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