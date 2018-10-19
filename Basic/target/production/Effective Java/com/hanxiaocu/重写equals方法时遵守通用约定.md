对于类型为非float或double的基本类型，使用= =运算符进行比较；

对于对象引用属性，递归地调用equals方法；

对于float 基本类型的属性，使用静态Float.compare(float, float)方法；  
对于double 基本类型的属性，使用Double.compare(double, double)方法。

由于存在Float.NaN，-0.0f和类似的double类型的值，所以需要对float和double属性进行特殊的处理.

Float.equals和Double.equals方法对float和double基本类型的属性进行比较，这会导致每次比较时发生自动装箱,
所以不建议使用。