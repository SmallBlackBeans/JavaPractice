### IDEA 配置
https://www.imooc.com/video/16218

### 遇到的问题
**1. Mac 上 Class JavaLaunchHelper is implemented in both ... One of the two will be used. Which one is undefined.报错**

> 自己为了Android的一个工具，降低了jdk的版本，1.8.0.144 ，而这个问题在1.8.0.152解决了，打脸
https://blog.csdn.net/lizhaowei213/article/details/68951671

**2. 因为.gitignore 不会忽略已经跟踪的文件，所以要先删除**

删除.idea 文件跟踪 git rm --cached -r .idea

git add .gitignore

git commit -m ".gitignore提交删除.idea"

git push origin master

顺序：  
```html
git rm --cached *.iml
git add .gitignore
git commit -m "gitignore提交删除iml"
git push origin master
```

**3. idea 不能new package**

对src目录右键，make directory as ->sources root

**4. Intellij idea 出现错误 error:java: 无效的源发行版: 9解决方法**

说明Project language lever 版本是9 和项目的jdk不符合
降低Project language lever 为 8

**5. idea output path is not 指定**

project settting out 设置 

/Users/hanchenghai/Desktop/Practice/JavaPractice/Basic/out

module settting 选择继承 或 module settting 中 手动指定output路径

**5. idea module git没有同步显示问题**
最外层项目使用了maven,同步一下就好了。