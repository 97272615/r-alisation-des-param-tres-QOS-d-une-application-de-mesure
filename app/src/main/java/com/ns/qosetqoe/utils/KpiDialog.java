package com.ns.qosetqoe.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.ns.qosetqoe.R;
import com.ns.qosetqoe.databinding.KpiDialogLayoutBinding;
import com.ns.qosetqoe.models.ItemClass;

public class KpiDialog extends Dialog {
    private ItemClass item;
    private KpiDialogLayoutBinding binding;

    public KpiDialog(Context context) {
        super(context);
    }

    public KpiDialog(Context context, ItemClass item) {
        super(context);
        this.item = item;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.kpi_dialog_layout, null, false);
        binding.setItem(item);
        binding.setDialog(this);
        setContentView(binding.getRoot());
    }

    public void onButtonClicked(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.btn_ok:
                dismiss();
                break;

            case R.id.btn_compare:
                compareData();
        }
    }

    private void compareData() {

    }
}
