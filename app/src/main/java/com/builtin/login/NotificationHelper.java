package com.builtin.login;
/*creator Brian Barnabas Langay
 email brianlangay0@gmail.com*/
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class NotificationHelper {

    public static void showCustomNotification(Context context, String title, String message, int durationMillis) {
        // Create a custom layout for the dialog
        View dialogView = LayoutInflater.from(context).inflate(R.layout.custom_notification_dialog, null);

        // Customize the layout components
        ImageView notificationIcon = dialogView.findViewById(R.id.notificationIcon);
        notificationIcon.setImageResource(R.drawable.bird_icon);

        TextView notificationTitle = dialogView.findViewById(R.id.notificationTitle);
        notificationTitle.setText(title);

        TextView notificationText = dialogView.findViewById(R.id.notificationText);
        notificationText.setText(message);

        // Create and show the AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setView(dialogView)
                .setCancelable(true);
        AlertDialog alertDialog = builder.create();

        // Set the background drawable with rounded corners
        Drawable drawable = context.getResources().getDrawable(R.drawable.rounded_corners);
        alertDialog.getWindow().setBackgroundDrawable(drawable);

        // Set window parameters to position the dialog at the top
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(alertDialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = Gravity.TOP; // Position at the top
        alertDialog.getWindow().setAttributes(layoutParams);

        alertDialog.show();

        // Set a delay for the notification dismissal
        /*Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(alertDialog::dismiss, durationMillis);*/

        // Set a delay for the notification dismissal
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {
            // Check if the activity is not finishing before dismissing the dialog
            if (!((Activity) context).isFinishing() && alertDialog.isShowing()) {
                alertDialog.dismiss();
            }
        }, durationMillis);
    }
}
