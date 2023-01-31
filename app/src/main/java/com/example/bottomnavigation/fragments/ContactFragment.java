package com.example.bottomnavigation.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.activity.LoginActivity;
import com.example.bottomnavigation.adapters.ContactGridViewAdapter;


public class ContactFragment extends Fragment {

    String[] names = {"Gym Profile", "Setting", "How to use", "Plan & subscription", "Contact us", "Rate us", "Share this App", "Log out", "Report bugs"};
    int[] icons = {R.drawable.manage_accounts, R.drawable.settings_icon, R.drawable.youtube, R.drawable.subscriptions, R.drawable.contact_support, R.drawable.star_rate_icon, R.drawable.share_icon, R.drawable.logout_icon, R.drawable.bug_icon};
    GridView gridView;

    public ContactFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        gridView = view.findViewById(R.id.gridView);
        ContactGridViewAdapter adapter = new ContactGridViewAdapter(getContext(), names, icons);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Toast.makeText(getContext(), names[i], Toast.LENGTH_SHORT).show();
                if (names[i].equalsIgnoreCase("Share this App")) {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "https://developer.android.com/training/sharing/send/");
                    sendIntent.setType("plain/text");
                    sendIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    Intent shareIntent = Intent.createChooser(sendIntent, null);
                    startActivity(shareIntent);
                } else if (names[i].equalsIgnoreCase("Report bugs")) {
                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{"Rajawant143@gmail.com"});
                    email.putExtra(Intent.EXTRA_SUBJECT, "Report New Bug");
                    email.setType("message/rfc822");
                    startActivity(Intent.createChooser(email, "Choose an Email client :"));
                } else if (names[i].equalsIgnoreCase("Contact us")) {
                    try {
                        String phoneNumberWithCountryCode = "+919984802878";
                        String message = "Hallo";
                        Intent whatsappIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("https://api.whatsapp.com/send?phone=%s&text=%s", phoneNumberWithCountryCode, message)));
                        startActivity(whatsappIntent);
                    } catch (Exception e) {
                        Toast.makeText(getContext(), "whatsapp is not installed", Toast.LENGTH_SHORT).show();
                    }

                } else if (names[i].equalsIgnoreCase("Log out")) {
                    // Create the object of AlertDialog Builder class
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    // Set the message show for the Alert time
                    builder.setMessage("Do you want to log out ?");
                    // Set Alert Title
                    builder.setTitle("Log out Alert!");
                    // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                    builder.setCancelable(false);
                    // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
                    builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                        // When the user click yes button then app will do action
                        Intent intent = new Intent(getContext(), LoginActivity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), "You have logged out..", Toast.LENGTH_LONG).show();
                    });

                    // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
                    builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                        // If user click no then dialog box is canceled.
                        dialog.cancel();
                    });
                    // Create the Alert dialog
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else if (names[i].equalsIgnoreCase("How to use")) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=4DkNCgUXbig&list=RDS980-z1qx3g&index=27&ab_channel=NAVRecords")));
                } else if (names[i].equalsIgnoreCase("Rate us")) {
                    Intent playstoreIntent = new Intent(android.content.Intent.ACTION_VIEW);
                    playstoreIntent.setData(Uri.parse("https://play.google.com/store/apps/details?id=my packagename "));
                    startActivity(playstoreIntent);
                }
            }
        });
        return view;
    }
}