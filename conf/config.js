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
						domainPackage: "com.siwei.domain",
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
};