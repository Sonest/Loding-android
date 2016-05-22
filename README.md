# Loding-android

#如何自定义控件
1.自定义属性的声明与获取<br>*
2.测量onMeasure<br>*
3.布局onLayout(ViewGroup)<br>
4.绘制onDraw<br>*
5.onTouchEvent<br>
6.onInterceptTouchEvent(ViewGroup)<br>
7.状态的恢复与保存(继承progressBar这个步骤省略，内部已经实现了)<br>
# 制作过程
1.分析所需要的自定义属性<br>
2.编写属性attrs.xml文件<br>
3.在构造方法中对自定义的值进行获取<br>
4.测量， 分析宽度高度需要支持的模式，控件内部的绘制时依赖于用户给它的一个宽度和高度的明确之，他的宽和高就不支持wrap_content之类的模式，所以onMesure与我们使用的场景是息息相关的（有三种测量模式）<br>
5.onDraw
![image](https://github.com/felix0080/Loding-android/blob/master/image/the.jpg)
