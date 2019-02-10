package task.project.tele.assignment.Utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

import task.project.tele.assignment.R;

public class Utils {
    static Dialog dialog;

    public static void loadingDialog(Context context,Boolean state){
        if (!state) {
            if (dialog!=null)
                dialog.dismiss();
        }

        else {
            dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.progress_dialog);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            if (state)
                dialog.show();
        }
    }
}
