package com.aladingtech.app.yueju.common.kits;

import android.content.Context;
import android.content.SharedPreferences;

import com.aladingtech.app.yueju.common.MyBaseApplication;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import cn.droidlover.xdroidmvp.cache.SharedPref;
import cn.droidlover.xdroidmvp.kit.Codec;

/**
 * Created by hotBei on 2017/11/21,2017
 * Created on 13:16
 */

public class SharedPrefreKit {

    /**
     * 保存在手机里面的文件名
     */
    public static final String SP_NAME = "sharedpre_data";
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static SharedPrefreKit instance;

    private SharedPrefreKit(Context context) {
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static SharedPrefreKit getInstance() {
        if (instance == null) {
            synchronized (SharedPref.class) {
                if (instance == null) {
                    instance = new SharedPrefreKit(MyBaseApplication.getInstance());
                }
            }
        }
        return instance;
    }

    /**
     * 通过对象输出流和Base64编码来存储序列化对象
     */
    public void putObject(String key, Object object) {
        LogUtils.i("SharedPreferencesUtils putObject" + key + "1:::" + object);

        // 创建字节输出流
        LogUtils.i("SharedPreferencesUtils putObject" + key + "2:::" + sharedPreferences);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            // 创建对象输出流，并封装字节流
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            LogUtils.i("SharedPreferencesUtils putObject" + key + "3:::" + oos);
            // 将对象写入字节流
            oos.writeObject(object);
            LogUtils.i("SharedPreferencesUtils putObject" + key + "4::::");
            // 将字节流编码成base64的字符窜
            String oAuth_Base64 = new String(Codec.BASE64.encodeToString(baos.toByteArray()));
            LogUtils.i("haredPreferencesUtils putObject" + key + "5:::" + oAuth_Base64);
            editor.putString(key, oAuth_Base64);
            editor.commit();
            LogUtils.i("SharedPreferencesUtils 保存成功" + key + "::::" + oAuth_Base64);
        } catch (IOException e) {
            // TODO Auto-generated
            LogUtils.e("haredPreferencesUtils putObject error" + key + ":::" + e.getStackTrace() + ":::" + e.toString());
        }
    }

    public Object getObject(String key) {
        Object oAuth_1 = null;

        String productBase64 = sharedPreferences.getString(key, "");

        //读取字节
        byte[] base64 = Codec.BASE64.decode(productBase64.getBytes());

        //封装到字节流
        ByteArrayInputStream bais = new ByteArrayInputStream(base64);
        try {
            LogUtils.i("SharedPreferencesUtils getObject   try1");
            //再次封装
            ObjectInputStream bis = new ObjectInputStream(bais);
            LogUtils.i("SharedPreferencesUtils getObject   try2");
            try {
                //读取对象
                oAuth_1 = bis.readObject();
                LogUtils.i("SharedPreferencesUtils getObject   try3");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            LogUtils.i("SharedPreferencesUtils 读取成功" + key + "::::" + oAuth_1 + ":::" + base64 + "::::" + bis);
        } catch (StreamCorruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return oAuth_1;
    }

    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     *
     * @param context
     * @param key
     * @param object
     */
    public void put(Context context, String key, Object object) {
        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            editor.putString(key, object.toString());
        }

        SharedPreferencesCompat.apply();
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     *
     * @param context
     * @param key
     * @param defaultObject
     * @return
     */
    public Object get(Context context, String key, Object defaultObject) {

        if (defaultObject instanceof String) {
            return sharedPreferences.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sharedPreferences.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sharedPreferences.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sharedPreferences.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sharedPreferences.getLong(key, (Long) defaultObject);
        }

        return null;
    }

    public  boolean getBoolean(String key, boolean defValue) {

        return sharedPreferences.getBoolean(key, defValue);
    }

    public  void putBoolean(String key, boolean value) {

        editor.putBoolean(key, value);
        SharedPreferencesCompat.apply();
    }

    public  void putString( String key, String value) {

        editor.putString(key, value);
        SharedPreferencesCompat.apply();
    }

    public  String getString(String key, String defValue) {

        return sharedPreferences.getString(key, defValue);
    }

    public  void putInt( String key, int value) {
        editor.putInt(key, value);
        SharedPreferencesCompat.apply();
    }

    public  int getInt(String key, int defValue) {

        return sharedPreferences.getInt(key, defValue);
    }


    /**
     * 移除某个key值已经对应的值
     *
     * @param context
     * @param key
     */
    public void remove(Context context, String key) {
        editor.remove(key);
        SharedPreferencesCompat.apply();
    }

    /**
     * 清除所有数据
     *
     * @param context
     */
    public void clear(Context context) {
        editor.clear();
        SharedPreferencesCompat.apply();
    }

    /**
     * 查询某个key是否已经存在
     *
     * @param context
     * @param key
     * @return
     */
    public boolean contains(Context context, String key) {

        return sharedPreferences.contains(key);
    }

    /**
     * 返回所有的键值对
     *
     * @param context
     * @return
     */
    public Map<String, ?> getAll(Context context) {

        return sharedPreferences.getAll();
    }

    /**
     * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
     *
     * @author zhy
     */
    private static class SharedPreferencesCompat {
        private static final Method sApplyMethod = findApplyMethod();

        /**
         * 反射查找apply的方法
         *
         * @return
         */
        @SuppressWarnings({"unchecked", "rawtypes"})
        private static Method findApplyMethod() {
            try {
                Class clz = SharedPreferences.Editor.class;
                return clz.getMethod("apply");
            } catch (NoSuchMethodException e) {
            }

            return null;
        }

        /**
         * 如果找到则使用apply执行，否则使用commit
         */
        public static void apply() {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor);
                    return;
                }
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
            editor.commit();
        }
    }

}


