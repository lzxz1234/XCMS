var ioc={
		nutzProcessor: {
			type: "com.chineseall.xcms.nb.NutzProcessor",
			fields: {
				classMapper: {
					type: "com.chineseall.xcms.core.ClassMapper",
					events: {
						create: "init",
					},
					fields: {
						domainPackage: "com.chn.xietong.web.domain",
					}
				},
				daoFactory: {
					type: "com.chineseall.xcms.core.dao.DaoFactory",
					fields: {
						defaultDaoClass: "com.chineseall.xcms.nb.dao.NutzDao",
					}
				},
				tplRepository: {
					type: "com.chineseall.xcms.core.tpl.FileSystemTplRepository",
					events: {
						create: "init",
					},
					fields:{
						rootPath: "${web-content}/templates",
						initializer: {
							type: "com.chineseall.xcms.nb.tpl.ViewInitializer",
						},
					},
				},
				render: {
					type: "com.chineseall.xcms.nb.render.BeetlRender",
				}
			}
		},
		tmpFilePool : {
		    type : 'org.nutz.filepool.NutFilePool',
		    args : [ {java: 'com.chineseall.xcms.core.utils.WebUtils.getWebInfPath("/temp")'}, 
		             1000 ]
		},
		uploadFileContext : {
		    type : 'org.nutz.mvc.upload.UploadingContext',
		    singleton : false,
		    args : [ { refer : 'tmpFilePool' } ],
		    fields : {
		        ignoreNull : true,
		        // 单个文件最大尺寸(大约的值，单位为字节，即 1048576 为 1M)
		        maxFileSize : 1048576,
		        nameFilter : '^(.+[.])(gif|jpg|png)$' 
		    } 
		},
		myUpload : {
		    type : 'org.nutz.mvc.upload.UploadAdaptor',
		    singleton : false,
		    args : [ { refer : 'uploadFileContext' } ] 
		}
};