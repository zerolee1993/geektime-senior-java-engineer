一、书本配置
======

#### 1. 书本标题：title

```json
"title" : "This Gitbook"
```

#### 2. 作者：author

```json
"author" : "Monky"
```

#### 3. 简单描述：description

```json
"description" : "记录Gitbook插件配置和使用方法"
```

#### 4. 语言：language

Gitbook使用的语言, 版本2.6.4中可选的语言如下：
en, ar, bn, cs, de, en, es, fa, fi, fr, he, it, ja, ko, no, pl, pt, ro, ru, sv, uk, vi, zh-hans, zh-tw
例如，配置使用简体中文   

```json
"language" : "zh-hans"
```

#### 5. 左侧导航栏添加链接信息：links

```json
"links" : {
	"sidebar" : {
		"Home" : "https://www.baidu.com"
	}
}
```

#### 6. 自定义页面样式

*   默认情况下各 generator 对应的 css 文件

```json
"styles": {
	"website": "styles/website.css",
	"ebook": "styles/ebook.css",
	"pdf": "styles/pdf.css",
	"mobi": "styles/mobi.css",
	"epub": "styles/epub.css"
}
```

*   例如使 `<h1> <h2>`标签有下边框， 可以在 website.css 中设置

```json
h1 , h2{
	border-bottom: 1px solid #EFEAEA;
}
```

二、插件配置
======

#### 1. 配置使用的插件

其中"-search"中的 - 符号代表去除插件

```json
"plugins": [
	"-search", "-share"
	"back-to-top-button",
	"expandable-chapters-small",
	"insert-logo"
]
```

*   Gitbook 默认自带有 5 个插件：
    *   highlight： 代码高亮
    *   search： 导航栏查询功能（不支持中文）
    *   sharing：右上角分享功能
    *   font-settings：字体设置（页面顶部的 "A" 符号）
    *   livereload：为 GitBook 实时重新加载（不建议）

#### 2. 插件属性配置 pluginsConfig

*   配置插件的属性，例如配置 **tbfed-pagefooter(页脚插件)** 的属性：

```json
"plugins": [
	"tbfed-pagefooter"
],
"pluginsConfig": {
	"tbfed-pagefooter": {
		"copyright":"Copyright © xxxx.com 2020",
		"modify_label": "该文件修订时间：",
		"modify_format": "YYYY-MM-DD HH:mm:ss"
	}
}
```

三、常用插件
======

*   用法：在 book.json 中添加 **"plugins"** 和 **"pluginConfig"** 字段。然后执行 **gitbook install**，或者使用 **NPM 安装 npm install gitbook-plugin-插件名**，也可以从源码 GitHub 地址中下载，放到 **node_modules 文件夹**里。

#### 1. 回到顶部：**back-to-top-button**

```json
"plugins": [
	"back-to-top-button"
]
```

#### 2. 导航目录折叠

*   插件 1：**chapter-fold**

```json
"plugins": [
	"chapter-fold"
]
```

*   插件 2：**expandable-chapters**

```json
"plugins": [
	"expandable-chapters"
]
```

建议：和 **chapter-fold 插件一起用**：

```json
"plugins": [
	"expandable-chapters",
	"chapter-fold",
]
```

#### 3. 侧边栏 (侧边目录) 宽度可调节：**splitter**

```json
"plugins": [
  "splitter"
]
```

#### 4. 查看图片

*   新标签页打开图片，查看原图：**popup**

```json
"plugins": [
  "popup"
]
```

*   以弹窗形式查看图片，查看原图：**lightbox**

```json
"plugins": [
  "lightbox"
]
```

#### 5. 页面内导航目录

*   在页面顶部显示目录：**page-treeview**

```
    "plugins": [
        "page-treeview"
    ]


```

*   页面内生成悬浮导航目录：**anchor-navigation-ex**

```
    "plugins": [ 
        "anchor-navigation-ex"
    ],
    "pluginsConfig": {
        "anchor-navigation-ex": {
            "showLevel": false,     // 标题是否显示标题层级序号
            "showGoTop": false      // 是否显示返回顶部按钮
        },
    }   


```

*   页面右上角生成黑色的按钮，鼠标移入后会显示黑色的目录：**page-toc-button**  
    _建议_：该插件与 “**back-to-top-button**(回到顶部)” 一起使用，可实现快速定位。

```
    "plugins": [ 
        "page-toc-button"
    ],

    "pluginsConfig": {
        "page-toc-button": {
            "maxTocDepth": 2,  // 标题的最大深度（2 = h1 + h2 + h3）。不支持值> 2。
            "minTocSize": 2    // 显示toc按钮的最小toc条目数。
           }
    }


```

*   页面右上角悬浮导航以及回到顶部按钮：**ancre-navigation**

```
    "plugins": [
        "ancre-navigation"
    ]


```

#### 6. 修改网站图标，浏览器标签栏上的小图标和保存后书签的图标

*   注意：  
    1、图标的格式一定要是. ico 的，直接修改图片的后缀为. ico 是无效的。  
    2、图标的分辨率要是 32x32 的。
*   插件 1：**favicon**

```
    "plugins": [
        "favicon"
    ],

    "pluginsConfig": {
        "favicon": {
            "shortcut": "file/favicon.ico",
            "bookmark": "file/favicon.ico",
        }
    }


```

*   插件 2：**custom-favicon**

```
    "plugins": [
        "custom-favicon"
    ],
    
    "pluginsConfig" : {
        "favicon": "file/favicon.ico"
    }


```

#### 7. 页面添加页脚，包含版本信息和文档最后修订时间：**tbfed-pagefooter**

```
    "plugins": [
       "tbfed-pagefooter"
    ],

    "pluginsConfig": {
        "tbfed-pagefooter": {
            "copyright":"Copyright © xxxx.com 2020",
            "modify_label": "该文件修订时间：",
            "modify_format": "YYYY-MM-DD HH:mm:ss"
        }
    }


```

#### 8. 隐藏元素，元素可以通过检查页，查找对应的 class 获取：**hide-element**

```json
    "plugins": [
        "hide-element"
    ],

    "pluginsConfig": {
        "hide-element": {
            "elements": [".gitbook-link", ".copyright"]
        }
    }
```

#### 9. 在左侧栏上方插入公司 / 团队 logo：**insert-logo**

```json
"plugins": [
	"hide-element"
],
"pluginsConfig": {
	"insert-logo": {
		"url": "file/logo.png",
		"style": "background: none; max-height: 30px; min-height: 30px"
	}
}
```

#### 10. 高级搜索（支持中文）：**search-pro**，需要将默认的 search 和 lunr 插件去掉

```json
"plugins": [
	"-lunr", 
  "-search", 
  "search-pro"
]
```

#### 11. 阅读量计数：**pageview-count**

```json
"plugins": [
	"pageview-count"
]
```
