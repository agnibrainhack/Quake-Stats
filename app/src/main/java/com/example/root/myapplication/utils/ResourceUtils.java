package com.example.root.myapplication.utils;

import android.content.Context;

import com.example.root.myapplication.ApplicationClass;

public class ResourceUtils {
    //Singleton implementation
    private static ResourceUtils Instance = null;
    private final Context mContext;

    /**
     *
     * @return Resource Utilities instance
     */
    public static ResourceUtils instance() {
        ResourceUtils localInstance = Instance;
        if (localInstance == null) {
            synchronized (ResourceUtils.class) {
                localInstance = Instance;
                if (localInstance == null) {
                    Instance = localInstance = new ResourceUtils();
                }
            }
        }
        return localInstance;
    }

    /**
     * Initialize with context
     */
    private ResourceUtils() {
        mContext = ApplicationClass.getInstance().getApplicationContext();
    }

    /**
     *
     * @param stringResourceId Resource id
     * @return Return resource string
     */
    public String getString(int stringResourceId) {
        return mContext.getResources().getString(stringResourceId);
    }
}
