package com.example.shama.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class ExampleDialog extends AppCompatDialogFragment {
private EditText editTextUsername;
private EditText getEditTextSurname;
private ExampleDialogListener listener;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(view).setTitle("Details").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    String username = editTextUsername.getText().toString();
                    String surname = getEditTextSurname.getText().toString();
listener.applyTexts(username, surname);
            }
        });

        editTextUsername = view.findViewById(R.id.textview_username) ;
        getEditTextSurname = view.findViewById(R.id.textview_surname);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
            "must implement ExampleDialogListener");
        }
    }

    public interface ExampleDialogListener{
        void applyTexts(String username, String surname);
    }
}
