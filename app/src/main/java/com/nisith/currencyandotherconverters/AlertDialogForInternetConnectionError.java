package com.nisith.currencyandotherconverters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

public class AlertDialogForInternetConnectionError extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext())
                .setTitle("You are Offline")
                .setMessage("Please Check Your Internet Connection. Turn on Mobile Data or Wi-Fi. This App needs Internet Connection To Work.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setIcon(R.drawable.ic_tower);
        return dialogBuilder.create();
    }
}
