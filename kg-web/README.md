# web-ui


## 功能 ##
- [x] xxxx
- [x] 其他，待定


## 目录结构介绍 ##

	|-- build                            // webpack配置文件
	|-- config                                         // 项目打包路径
	|-- src                                     // 源码目录
	|   |-- components                          // 组件
	|       |-- common                          // 公共组件
	|           |-- bus.js           	        // Event Bus
	|           |-- Header.vue                  // 公共头部
	|           |-- Home.vue           	        // 公共路由入口
	|           |-- Sidebar.vue                 // 公共左边栏
	|           |-- Tags.vue           	        // 页面切换标签组件
	|       |-- page                   	        // 主要路由页面
	|           |-- 403.vue
	|           |-- 404.vue
	|           |-- Login.vue          	        // 登录
	|           |-- home                        // 首页
	|               |-- xxxx.vue                // xxxx
	|               |-- xxxx.vue                // xxxxx
	|           |-- xxxxxx                      // xxxxx
	|               |-- xxxxxxxxxx.vue          // xxxxxx
    |   待定-----------------------------------------------------------------------------------
	|           |-- xxxxxxx                     // xxxxx
	|               |-- xxxxxxxxxxxxxxx.vue     // xxxxx
    |   待定-----------------------------------------------------------------------------------
    |           |-- xxxxxxxxx                   // xxxxxx
	|               |-- xxxxxxxxxxxxxxxx.vue    // xxxx
    |   待定-----------------------------------------------------------------------------------
	|           |-- system                      // 系统管理
    |               |-- UserHelp.vue            // 用户帮助
	|               |-- SystemInfo.vue          // 系统信息
	|               |-- PasswordModify.vue      // 密码修改
	|               |-- Exit.vue                // 退出系统
	|           |-- user                        // 用户管理
	|               |-- UserModify.vue          // 用户编辑
	|               |-- UserRight.vue           // 用户权限
	|   |-- App.vue                             // 页面入口文件
	|   |-- main.js                             // 程序入口文件，加载各种公共组件
	|-- .babelrc                                // ES6语法编译配置
	|-- .editorconfig                           // 代码编写规格
	|-- .gitignore                              // 忽略的文件
	|-- index.html                              // 入口html文件
	|-- package.json                            // 项目及工具的依赖配置文件
	|-- README.md                               // 说明


知识搜索模块

知识图谱管理 KG-manage
   - 三元组上传
   - 三元组统计
   - 三元组修改

表示学习内部运用
   - 实体链接
   - 三元组分类

表示学习外部运用 OutApplication
   - 知识问答 question and answer





## 安装步骤 ##

**安装前先安装nodejs和npm**

	cd web-ui   // 进入系统目录
	npm install         // 安装项目依赖，等待安装完成之后

## 本地开发 ##

	// 开启服务器，浏览器访问 http://localhost:8099
	npm run dev

## 构建生产 ##

	// 执行构建命令，生成的dist文件夹放在服务器下即可访问
	npm run build
