# NotePad
### 基本要求

#### 时间戳

完成效果：

![](./img/image-20241126132035932.png)

如何实现：

首先布局文件修改，通过线性布局设置两个textview控件

![](./img/image-20241126162444201.png)

更新日记的时候存入对应的时间

![image-20241126132435166](./img/image-20241126132435166.png)

然后再notelist里面调用，添加对应属性列

![image-20241126132503514](./img/image-20241126132503514.png)

![image-20241126132553682](./img/image-20241126132553682.png)



#### 搜索功能

首先再menu文件下添加搜索的按钮

![image-20241126132754197](./img/image-20241126132754197.png)

对应效果

![image-20241126132818035](./img/image-20241126132818035.png)



添加对于这个搜索的点击事件，点击搜索跳到搜索页面

![image-20241126132924577](./img/image-20241126132924577.png)

这是搜索页面布局文件的代码

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="horizontal"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="5dp"
    android:paddingTop="10dp"
    android:paddingRight="5dp"
    android:background="#ddd"
    android:weightSum="1">


    <LinearLayout
        android:id="@+id/search_ctn"
        android:layout_width="1dp"
        android:layout_weight="0.85"
        android:layout_height="50dp"
        android:background="@drawable/border_radius"
        android:weightSum="1">

        <ImageView
            android:id="@+id/search_logo"
            android:src="@drawable/search"
            android:layout_width="40dp"
            android:layout_height="40dp"
            android:layout_gravity="center_vertical"
            />

        <EditText
            android:id="@+id/note_search"
            android:layout_width="match_parent"
            android:layout_height="40dp"
            android:textSize="20dp"
            android:hint="请输入"
            android:textColor="#333"
            android:focusable="true"
            android:singleLine="true"
            android:background="@android:color/transparent"
            android:gravity="center_vertical"
            android:layout_gravity="center_vertical"/>
<!--android:background="@android:color/transparent"可以去掉下划线-->


    </LinearLayout>


    <TextView
        android:id="@+id/note_cancel"
        android:layout_width="1dp"
        android:layout_weight="0.15"
        android:layout_height="50dp"
        android:text="取消"
        android:textSize="20dp"
        android:textColor="#0000ff"
        android:gravity="center"/>





</LinearLayout>
```

最后搜索页面的效果

![image-20241126133012047](./img/image-20241126133012047.png)

![image-20241204213607034](./img/image-20241204213607034.png)

这边写搜索rk然后点击搜索按钮，就会跳回list页面

结果(显示两条是因为我Cjb标题的内容下包含了rk)

![image-20241126133102683](./img/image-20241126133102683.png)

![image-20241204213802349](./img/image-20241204213802349.png)

代码实现：

首先获取搜索的关键词

![image-20241126133208888](./img/image-20241126133208888.png)

根据搜索关键词查询

![image-20241126133242787](./img/image-20241126133242787.png)





### 附加功能

#### 排序

通过menu设置四个排序（默认、时间升序，标题降序，标题升序）

实现：

![image-20241126155823709](./img/image-20241126155823709.png)

菜单对应点击，通过getNoteList函数传入sort排序规则，

![image-20241126155913869](./img/image-20241126155913869.png)

这里设置排序规则从而产生效果

效果图：

时间默认：

![image-20241126160024075](./img/image-20241126160024075.png)

时间升序：

![image-20241126160053501](./img/image-20241126160053501.png)

标题降序：

![image-20241126160128546](./img/image-20241126160128546.png)

标题升序：

![image-20241126160150431](./img/image-20241126160150431.png)



#### 字体大小

通过menu设置三种字体大小



![image-20241126160631260](./img/image-20241126160631260.png)

自定义updateFontSize函数修改每个list对应的标题和时间戳的大小

![image-20241126160728885](./img/image-20241126160728885.png)

对应效果图：

默认：

![image-20241126160755989](./img/image-20241126160755989.png)

大：

![image-20241126160820512](./img/image-20241126160820512.png)

小：

![image-20241126160839108](./img/image-20241126160839108.png)



#### 主题切换

通过menu设置两种主题（默认的黑色，以及白色）

![image-20241126161021787](./img/image-20241126161021787.png)

通过saveThemePreference函数保存对应的主题

![image-20241126161424614](./img/image-20241126161424614.png)

然后使用setTheme来设置

效果展示：

默认黑色：

![image-20241126161522662](./img/image-20241126161522662.png)



白色：

![image-20241126161547786](./img/image-20241126161547786.png)



#### 重置

通过menu设置重置按钮来实现对于搜索关键词的清空，以及对于字体重置为默认

![image-20241126161724874](./img/image-20241126161724874.png)

#### 细节优化

原本的note笔记当我们没有对它设置标题的时候或者是空字符串的时候会显示空，导致不美观，所以我通过判断这个标题，如果是上述情况则标题显示为无标题。

代码实现：

![image-20241126162035321](./img/image-20241126162035321.png)

效果：

原先的：

![image-20241126162159359](./img/image-20241126162159359.png)

修改后：

![image-20241126162254032](./img/image-20241126162254032.png)
