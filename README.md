#**Retr0ChangeColorButton**

##**功能**
点击后由内到外切换颜色的按钮，颜色可自定义。再次点击后颜色由内到外还原。

##**版本**
- v1.0 (demo)

##**用法**

```
Retr0ChangeColorButton mButton ;
mButton = new Retr0ChangeColorButton(this);
//设置颜色与半径
mButton.setColor(Color.BLACK,Color.BLUE,70);
//如果是二进制颜色代码，可用Color.parseColor()方法转换
```
##**To do list**
- 解决刷新次数的bug
- 添加圆角矩形
- 优化插入过程

##**注意**
- 使用时暂时需要协调按钮大小和半径

##**Log**
#### v1.0
- 基本功能实现
- 支持圆形 