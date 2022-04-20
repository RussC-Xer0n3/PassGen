package com.local.russellclarke.passgen;
/**
 * Created on Sunday 19 nov 2017 by russellclarke **MODDED**
 * Custom Spinner selector with Checkboxes for selecting which symbol characters to use
 * in the password string.
 * Modified from: https://stackoverflow.com/questions/24523715/multi-selection-spinner-in-android-without-alertdialog
 * and http://androiddhina.blogspot.co.uk/2016/02/android-multi-selection-spinner.html
 * User: Ironman - https://stackoverflow.com/users/6343685/ironman 17 july 2016
 * user: Dhina Cool - https://plus.google.com/104247977237483477667
 */
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SuppressLint("AppCompatCustomView")
public class MultiSelectionSpinner extends Spinner implements
            DialogInterface.OnMultiChoiceClickListener
    {
        String[] selected_items = null;
        boolean[] mSelection = null;

        ArrayAdapter<String> simple_adapter;

        public MultiSelectionSpinner(Context context)
        {
            super(context);

            simple_adapter = new ArrayAdapter<>(context,
                    android.R.layout.simple_spinner_item);
            super.setAdapter(simple_adapter);
        }

        public MultiSelectionSpinner(Context context, AttributeSet attrs) {
            super(context, attrs);

            simple_adapter = new ArrayAdapter<>(context,
                    android.R.layout.simple_spinner_item);
            super.setAdapter(simple_adapter);
        }

        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
            if (mSelection != null && which < mSelection.length) {
                mSelection[which] = isChecked;

                simple_adapter.clear();
                simple_adapter.add(buildSelectedItemString());
            } else {
                throw new IllegalArgumentException(
                        "Argument 'which' is out of bounds.");
            }
        }

        @Override
        public boolean performClick() {
            final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMultiChoiceItems(selected_items, mSelection, this);
                    /** RussiA MOD */
            builder.setNeutralButton("Select All", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1)
                {
                    if(selected_items == null) {
                        Jenny.setSym("");
                    }else{
                        for (int i = 0; i < selected_items.length; ++i) {
                            mSelection[i] = true;
                        }
                        Jenny.setSym(getSelectedItemsAsString());
                    }
                }
            });

            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1)
                {
                    /** RussiA MOD */
                    if(selected_items == null) {
                        Jenny.setSym("");
                    }else{
                        Jenny.setSym(getSelectedItemsAsString());
                    }
                }
            });
                    /** RussiA MOD */
            builder.setNegativeButton("Clear", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1)
                {
                    for (int i = 0; i < mSelection.length; i++) {
                        mSelection[i] = false;
                    }
                    Jenny.setSym("");
                    simple_adapter.clear();
                    simple_adapter.add(buildSelectedItemString());
                }
            });

            builder.show();
            return true;
        }

        @Override
        public void setAdapter(SpinnerAdapter adapter) {
            throw new RuntimeException(
                    "setAdapter is not supported by MultiSelectSpinner.");
        }
/** NEVER USED
        public void setItems(String[] items) {
            selected_items = items;
            mSelection = new boolean[selected_items.length];
            simple_adapter.clear();
            simple_adapter.add(selected_items[0]);
            Arrays.fill(mSelection, false);
        }
*/
        public void setItems(List<String> items) {
            selected_items = items.toArray(new String[items.size()]);
            mSelection = new boolean[selected_items.length];
            simple_adapter.clear();
            simple_adapter.add(selected_items[0]);
            Arrays.fill(mSelection, false);
        }
/** NEVER USED
        public void setSelection(String[] selection) {
            for (String cell : selection) {
                for (int j = 0; j < selected_items.length; ++j) {
                    if (selected_items[j].equals(cell)) {
                        mSelection[j] = true;
                    }
                }
            }
        }

        public void setSelection(List<String> selection) {
            for (int i = 0; i < mSelection.length; i++) {
                mSelection[i] = false;
            }
            for (String sel : selection) {
                for (int j = 0; j < selected_items.length; ++j) {
                    if (selected_items[j].equals(sel)) {
                        mSelection[j] = true;
                    }
                }
            }
            simple_adapter.clear();
            simple_adapter.add(buildSelectedItemString());
        }
*/
        public void setSelection(int index) {
            for (int i = 0; i < mSelection.length; i++) {
                mSelection[i] = false;
            }
            if (index >= 0 && index < mSelection.length) {
                mSelection[index] = true;
            } else {
                throw new IllegalArgumentException("Index " + index
                        + " is out of bounds.");
            }
            simple_adapter.clear();
            simple_adapter.add(buildSelectedItemString());
        }
/** NEVER USED
        public void setSelection(int[] selectedIndicies) {
            for (int i = 0; i < mSelection.length; i++) {
                mSelection[i] = false;
            }
            for (int index : selectedIndicies) {
                if (index >= 0 && index < mSelection.length) {
                    mSelection[index] = true;
                } else {
                    throw new IllegalArgumentException("Index " + index
                            + " is out of bounds.");
                }
            }
            simple_adapter.clear();
            simple_adapter.add(buildSelectedItemString());
        }

        public List<String> getSelectedStrings() {
            List<String> selection = new LinkedList<String>();
            for (int i = 0; i < selected_items.length; ++i) {
                if (mSelection[i]) {
                    selection.add(selected_items[i]);
                }
            }
            return selection;
        }

        public List<Integer> getSelectedIndicies() {
            List<Integer> selection = new LinkedList<Integer>();
            for (int i = 0; i < selected_items.length; ++i) {
                if (mSelection[i]) {
                    selection.add(i);
                }
            }
            return selection;
        }
*/
        private String buildSelectedItemString() {
            StringBuilder sb = new StringBuilder();
            boolean foundOne = false;

            for (int i = 0; i < selected_items.length; ++i) {
                if (mSelection[i]) {
                    if (foundOne) {
                        sb.append(""); //RussiA Mod - No whitespace string characters./
                    }
                    foundOne = true;

                    sb.append(selected_items[i]);
                }
            }
            return sb.toString();
        }

        public String getSelectedItemsAsString() {
            StringBuilder sb = new StringBuilder();
            boolean foundOne = false;

            for (int i = 0; i < selected_items.length; ++i) {
                if (mSelection[i]) {
                    if (foundOne) {
                        sb.append("");
                    }
                    foundOne = true;
                    sb.append(selected_items[i]);
                }
            }
            return sb.toString();
        }
/** NEVER USED
        public void setClear(){
            for (int i = 0; i < mSelection.length; i++) {
                if (!mSelection[i]){
                    break;
                }else if(mSelection[i]){
                    for (int j = 0; j < mSelection.length; j++) {
                        mSelection[j] = false;
                    }
                    break;
                }else{
                    mSelection[i] = false;
                    break;
                    }
                }
            }
 */
        }
