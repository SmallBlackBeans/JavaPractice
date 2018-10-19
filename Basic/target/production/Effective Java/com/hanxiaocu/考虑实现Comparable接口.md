```java
    System.out.println(new BigDecimal("1.2").equals(new BigDecimal("1.20")));  //输出false
    System.out.println(new BigDecimal("1.2").compareTo(new BigDecimal("1.20")) == 0); //输出true

    System.out.println(new BigDecimal(1.2).equals(new BigDecimal("1.20"))); //输出是false
    System.out.println(new BigDecimal(1.2).compareTo(new BigDecimal("1.20")) == 0); //输出是false

    System.out.println(new BigDecimal(1.2).equals(new BigDecimal(1.20))); //输出是true
    System.out.println(new BigDecimal(1.2).compareTo(new BigDecimal(1.20)) == 0);//输出是true
```
#### BigDecimal
  - equals 会比较 值和精度
  - compareTo 只是比较值
  
> 多使用包装类中的比较方法，而不是 >  <  - 这些操作符