// Generated by view binder compiler. Do not edit!
package com.example.androidseminar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.androidseminar.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySignUpBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText idEditText;

  @NonNull
  public final TextView idTextview;

  @NonNull
  public final EditText nameEditText;

  @NonNull
  public final TextView nameTextview;

  @NonNull
  public final EditText passwordEditText;

  @NonNull
  public final TextView passwordTextview;

  @NonNull
  public final Button signinCompleteButton;

  @NonNull
  public final TextView subTitleTextview;

  @NonNull
  public final TextView titleTextview;

  private ActivitySignUpBinding(@NonNull ConstraintLayout rootView, @NonNull EditText idEditText,
      @NonNull TextView idTextview, @NonNull EditText nameEditText, @NonNull TextView nameTextview,
      @NonNull EditText passwordEditText, @NonNull TextView passwordTextview,
      @NonNull Button signinCompleteButton, @NonNull TextView subTitleTextview,
      @NonNull TextView titleTextview) {
    this.rootView = rootView;
    this.idEditText = idEditText;
    this.idTextview = idTextview;
    this.nameEditText = nameEditText;
    this.nameTextview = nameTextview;
    this.passwordEditText = passwordEditText;
    this.passwordTextview = passwordTextview;
    this.signinCompleteButton = signinCompleteButton;
    this.subTitleTextview = subTitleTextview;
    this.titleTextview = titleTextview;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySignUpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_sign_up, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySignUpBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.id_edit_text;
      EditText idEditText = rootView.findViewById(id);
      if (idEditText == null) {
        break missingId;
      }

      id = R.id.id_textview;
      TextView idTextview = rootView.findViewById(id);
      if (idTextview == null) {
        break missingId;
      }

      id = R.id.name_edit_text;
      EditText nameEditText = rootView.findViewById(id);
      if (nameEditText == null) {
        break missingId;
      }

      id = R.id.name_textview;
      TextView nameTextview = rootView.findViewById(id);
      if (nameTextview == null) {
        break missingId;
      }

      id = R.id.password_edit_text;
      EditText passwordEditText = rootView.findViewById(id);
      if (passwordEditText == null) {
        break missingId;
      }

      id = R.id.password_textview;
      TextView passwordTextview = rootView.findViewById(id);
      if (passwordTextview == null) {
        break missingId;
      }

      id = R.id.signin_complete_button;
      Button signinCompleteButton = rootView.findViewById(id);
      if (signinCompleteButton == null) {
        break missingId;
      }

      id = R.id.sub_title_textview;
      TextView subTitleTextview = rootView.findViewById(id);
      if (subTitleTextview == null) {
        break missingId;
      }

      id = R.id.title_textview;
      TextView titleTextview = rootView.findViewById(id);
      if (titleTextview == null) {
        break missingId;
      }

      return new ActivitySignUpBinding((ConstraintLayout) rootView, idEditText, idTextview,
          nameEditText, nameTextview, passwordEditText, passwordTextview, signinCompleteButton,
          subTitleTextview, titleTextview);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}