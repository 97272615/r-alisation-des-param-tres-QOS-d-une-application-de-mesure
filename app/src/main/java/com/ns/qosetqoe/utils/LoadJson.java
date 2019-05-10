package com.ns.qosetqoe.utils;

import android.content.res.Resources;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ns.qosetqoe.R;
import com.ns.qosetqoe.models.ItemClass;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import static com.ns.qosetqoe.utils.UtilsClass.getRawResource;

public class LoadJson extends AsyncTask<Void, Void, List<ItemClass>> {
    private Resources res;
    private OnLoadJson mListener;

    public interface OnLoadJson {
        void onLoadCompleted(List<ItemClass> items);
    }

    public LoadJson(Resources res, OnLoadJson listener) {
        this.res = res;
        this.mListener = listener;
    }

    @Override
    protected List<ItemClass> doInBackground(Void... voids) {
        try {
            String json = getRawResource(res, R.raw.json_db);
            Gson gson = new Gson();
            Type listType = new TypeToken<List<ItemClass>>(){}.getType();
            return gson.fromJson(json, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<ItemClass> itemClasses) {
        mListener.onLoadCompleted(itemClasses);
    }
}
