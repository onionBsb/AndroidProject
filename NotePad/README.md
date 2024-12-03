# NotePad
### 基本要求

#### 时间戳

完成效果：

![](D:\Android\project\NotePad\img\image-20241126132035932.png)

如何实现：

首先布局文件修改，通过线性布局设置两个textview控件

![image-20241126162444201](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126162444201.png)

更新日记的时候存入对应的时间

![image-20241126132435166](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126132435166.png)

然后再notelist里面调用，添加对应属性列

![image-20241126132503514](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126132503514.png)

![image-20241126132553682](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126132553682.png)



#### 搜索功能

首先再menu文件下添加搜索的按钮

![image-20241126132754197](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126132754197.png)

对应效果

![image-20241126132818035](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126132818035.png)



添加对于这个搜索的点击事件，点击搜索跳到搜索页面

![image-20241126132924577](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126132924577.png)

![image-20241126133012047](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126133012047.png)

搜索对应的标题或者内容

结果

![image-20241126133102683](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126133102683.png)

代码实现：

首先获取搜索的关键词

![image-20241126133208888](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126133208888.png)

根据搜索关键词查询

![image-20241126133242787](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126133242787.png)





### 附加功能

#### 排序

通过menu设置四个排序（默认、时间升序，标题降序，标题升序）

实现：

![image-20241126155823709](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126155823709.png)

菜单对应点击，通过getNoteList函数传入sort排序规则，

![image-20241126155913869](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126155913869.png)

这里设置排序规则从而产生效果

效果图：

时间默认：

![image-20241126160024075](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126160024075.png)

时间升序：

![image-20241126160053501](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126160053501.png)

标题降序：

![image-20241126160128546](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126160128546.png)

标题升序：

![image-20241126160150431](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126160150431.png)



#### 字体大小

通过menu设置三种字体大小



![image-20241126160631260](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126160631260.png)

自定义updateFontSize函数修改每个list对应的标题和时间戳的大小

![image-20241126160728885](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126160728885.png)

对应效果图：

默认：

![image-20241126160755989](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126160755989.png)

大：

![image-20241126160820512](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126160820512.png)

小：

![image-20241126160839108](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126160839108.png)



#### 主题切换

通过menu设置两种主题（默认的黑色，以及白色）

![image-20241126161021787](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126161021787.png)

通过saveThemePreference函数保存对应的主题

![image-20241126161424614](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126161424614.png)

然后使用setTheme来设置

效果展示：

默认黑色：

![image-20241126161522662](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126161522662.png)



白色：

![image-20241126161547786](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126161547786.png)



#### 重置

通过menu设置重置按钮来实现对于搜索关键词的清空，以及对于字体重置为默认

![image-20241126161724874](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126161724874.png)

#### 细节优化

原本的note笔记当我们没有对它设置标题的时候或者是空字符串的时候会显示空，导致不美观，所以我通过判断这个标题，如果是上述情况则标题显示为无标题。

代码实现：

![image-20241126162035321](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126162035321.png)

效果：

原先的：

![image-20241126162159359](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126162159359.png)

修改后：

![image-20241126162254032](C:\Users\29424\AppData\Roaming\Typora\typora-user-images\image-20241126162254032.png)
