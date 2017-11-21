package com.aladingtech.app.yueju.common.exception;

import android.content.Context;
import android.widget.Toast;

public class ExceptionHandler {
    /**  
     * 根据不同的Exception给用户具体的提示
     */  
    public static void printException( MyException.NetException e) {
        int errCode = 0;  
        // errCode 具体化  
        if (e instanceof MyException.NetException) {
            errCode = 1;  
        }
        // 根据不同的errcode给用户做提示  
        print(errCode);
    }  
  
    private static void print( int errCode) {
        String content = "";  
        switch (errCode) {  
        case 1:  
            content = "程序出现了HMAException";  
            break;  
        case 2:  
            content = "程序出现了HMBException";  
            break;  
        case 3:  
            content = "程序出现了HMCException";  
            break;  
        case 4:  
            content = "程序出现了HMDException";  
            break;  
  
        default:  
            break;  
        }  
//        Toast.makeText(context, content, 0).show();

    }  
}  