package com.hanxiaocu.Reflect;

import java.lang.reflect.Array;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/9/20
 */
public class ReflectNote {
    public static void main(String[] args) {
        int[] src = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] desc = new int[10];
        arrayCopy(src, 3, desc, 2, 5);
    }

    private static void arrayCopy(Object src, int srcPos, Object desc, int descPos, int length) {
        if (src == null || desc == null) {
            throw new NullPointerException("源数组或目标数组为空");
        }

        if (!(src.getClass().isArray()) || !(desc.getClass().isArray())) {
            throw new ArrayStoreException("源对象或目标对象 必须都是数组");
        }

        if (srcPos < 0 || descPos < 0 || length < 0
                || srcPos + length > Array.getLength(src)
                || descPos + length > Array.getLength(desc)) {
            throw new ArrayIndexOutOfBoundsException("数组越界");
        }

        if (src.getClass().getComponentType() != desc.getClass().getComponentType()) {
            throw new ArrayStoreException("源必须和目标元素类型必须相同");
        }

        for (int index = 0; index < srcPos + length; index++) {
            Object var = Array.get(src, index);
            Array.set(desc, descPos, var);
            descPos++;
        }
    }
}
