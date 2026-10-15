package com.karamparampara.traat;

import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private boolean isMessageScreen = false;
    private boolean isCallScreen = false;
    private boolean isPaymentScreen = false;
    private boolean isAssistantScreen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        showHomeScreen();
    }

    private void showHomeScreen() {
        isMessageScreen = false;
        isCallScreen = false;
        isPaymentScreen = false;
        isAssistantScreen = false;

        setContentView(R.layout.activity_main);
        applySystemBarInsets();

        Button messageButton = findViewById(R.id.btnMessageSafety);
        if (messageButton != null) {
            messageButton.setOnClickListener(v -> openMessageSafety());
        }

        Button callButton = findViewById(R.id.btnCallSafety);
        if (callButton != null) {
            callButton.setOnClickListener(v -> openCallSafety());
        }

        Button paymentButton = findViewById(R.id.btnPaymentSafety);
        if (paymentButton != null) {
            paymentButton.setOnClickListener(v -> openPaymentSafety());
        }

        Button assistantButton = findViewById(R.id.btnAssistant);
        if (assistantButton != null) {
            assistantButton.setOnClickListener(v -> openAssistant());
        }
    }


    private void applySystemBarInsets() {
        android.view.ViewGroup content =
                findViewById(android.R.id.content);

        if (content != null && content.getChildCount() > 0) {
            View root = content.getChildAt(0);

            ViewCompat.setOnApplyWindowInsetsListener(
                    root, (v, insets) -> {

                        Insets bars = insets.getInsets(
                                WindowInsetsCompat.Type.systemBars());

                        v.setPadding(
                                bars.left,
                                bars.top,
                                bars.right,
                                bars.bottom
                        );

                        return insets;
                    }
            );

            ViewCompat.requestApplyInsets(root);
        }
    }

    private void openMessageSafety() {
        setContentView(R.layout.activity_message_safety);
        applySystemBarInsets();

        isMessageScreen = true;
        isCallScreen = false;
        isPaymentScreen = false;
        isAssistantScreen = false;

        EditText messageInput = findViewById(R.id.etSafetyMessage);
        Button scanButton = findViewById(R.id.btnScanMessage);
        TextView result = findViewById(R.id.tvSafetyResult);

        scanButton.setOnClickListener(v -> {
            String message = messageInput.getText().toString().trim();

            if (message.isEmpty()) {
                Toast.makeText(this, "Please paste a message first.",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            String lower = message.toLowerCase(Locale.ROOT);
            StringBuilder warnings = new StringBuilder();

            if (containsAny(lower,
                    "otp", "pin", "password", "cvv")) {
                warnings.append(
                        "• Sensitive information warning: Never share " +
                                "your OTP, PIN, password, or CVV.\n\n");
            }

            if (containsAny(lower,
                    "urgent", "immediately", "act now",
                    "account blocked", "account suspended",
                    "expire today", "verify now")) {
                warnings.append(
                        "• Urgency warning: Scammers may pressure " +
                                "you to act without checking.\n\n");
            }

            if (containsAny(lower,
                    "click here", "claim reward", "you have won",
                    "prize money", "free gift", "kyc update")) {
                warnings.append(
                        "• Possible scam wording: Verify any " +
                                "reward or KYC request independently.\n\n");
            }

            if (lower.contains("http://")
                    || lower.contains("https://")
                    || lower.contains("www.")) {
                warnings.append(
                        "• Link detected: Check the domain carefully. " +
                                "Do not open unexpected links.\n\n");
            }

            if (warnings.length() == 0) {
                result.setTextColor(Color.rgb(191, 219, 254));
                result.setText(
                        "NO COMMON WARNING SIGNS DETECTED\n\n" +
                                "This does not guarantee the message is safe. " +
                                "Verify the sender independently.");
            } else {
                result.setTextColor(Color.rgb(253, 186, 116));
                result.setText(
                        "CAUTION — WARNING SIGNS FOUND\n\n" +
                                warnings +
                                "Do not click suspicious links or share " +
                                "sensitive information. Verify independently.");
            }
        });
    }

    private void openCallSafety() {
        setContentView(R.layout.activity_call_safety);
        applySystemBarInsets();

        isCallScreen = true;
        isMessageScreen = false;
        isPaymentScreen = false;
        isAssistantScreen = false;

        CheckBox identity = findViewById(R.id.checkCallerIdentity);
        CheckBox secrets = findViewById(R.id.checkNoSecrets);
        CheckBox remoteAccess = findViewById(R.id.checkNoRemoteAccess);
        Button checkButton = findViewById(R.id.btnCheckCallSafety);
        TextView result = findViewById(R.id.tvCallSafetyResult);

        checkButton.setOnClickListener(v -> {
            int checked = 0;

            if (identity.isChecked()) checked++;
            if (secrets.isChecked()) checked++;
            if (remoteAccess.isChecked()) checked++;

            if (checked == 3) {
                result.setTextColor(Color.rgb(147, 197, 253));
                result.setText(
                        "CHECKLIST COMPLETE\n\n" +
                                "Good work. These checks cannot prove a caller " +
                                "is genuine. Contact the organisation through " +
                                "an independently verified official number.");
            } else {
                result.setTextColor(Color.rgb(253, 186, 116));
                result.setText(
                        "PAUSE BEFORE YOU TRUST THE CALL\n\n" +
                                "You have completed " + checked + " of 3 checks. " +
                                "Review the unchecked items. Never share OTPs " +
                                "or PINs or grant unknown remote access.");
            }
        });
    }

    private void openPaymentSafety() {
        setContentView(R.layout.activity_payment_safety);
        applySystemBarInsets();

        isPaymentScreen = true;
        isMessageScreen = false;
        isCallScreen = false;
        isAssistantScreen = false;

        CheckBox payee = findViewById(R.id.checkPayee);
        CheckBox amount = findViewById(R.id.checkAmount);
        CheckBox intent = findViewById(R.id.checkPaymentIntent);
        CheckBox officialApp = findViewById(R.id.checkOfficialApp);

        Button checkButton = findViewById(R.id.btnCheckPaymentSafety);
        TextView result = findViewById(R.id.tvPaymentSafetyResult);

        checkButton.setOnClickListener(v -> {
            int checked = 0;

            if (payee.isChecked()) checked++;
            if (amount.isChecked()) checked++;
            if (intent.isChecked()) checked++;
            if (officialApp.isChecked()) checked++;

            if (checked == 4) {
                result.setTextColor(Color.rgb(147, 197, 253));
                result.setText(
                        "CHECKLIST COMPLETE\n\n" +
                                "Good job. Confirm the final details in your " +
                                "trusted payment app. Never rely only on a " +
                                "screenshot or a caller's claim. This checklist " +
                                "cannot guarantee a transaction is safe.");
            } else {
                result.setTextColor(Color.rgb(253, 186, 116));
                result.setText(
                        "PAUSE BEFORE YOU PAY\n\n" +
                                "You have completed " + checked + " of 4 checks. " +
                                "Review the remaining items before proceeding. " +
                                "If anything seems suspicious, cancel and verify " +
                                "through your bank or payment provider.");
            }
        });
    }

    private void openAssistant() {
        setContentView(R.layout.activity_assistant);
        applySystemBarInsets();

        isMessageScreen = false;
        isCallScreen = false;
        isPaymentScreen = false;
        isAssistantScreen = true;

        EditText questionInput =
                findViewById(R.id.etAssistantQuestion);
        Button askButton =
                findViewById(R.id.btnAskAssistant);
        TextView answer =
                findViewById(R.id.tvAssistantAnswer);

        askButton.setOnClickListener(v -> {
            String question = questionInput.getText()
                    .toString().trim().toLowerCase(Locale.ROOT);

            if (question.isEmpty()) {
                Toast.makeText(this,
                        "Please enter your question first.",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            String response = getAssistantResponse(question);
            answer.setText(response);
            answer.setTextColor(Color.rgb(191, 219, 254));
        });
    }

    private String getAssistantResponse(String question) {

        // OTP, PIN and confidential information
        if (containsAny(question, "otp", "one time password",
                "pin", "cvv", "password")) {
            return "PROTECT YOUR SECRET INFORMATION\n\n" +
                    "Never share an OTP, UPI PIN, CVV or password " +
                    "with callers or strangers, even if they claim " +
                    "to be bank employees.\n\n" +
                    "If someone pressures you, stop the conversation " +
                    "and contact your bank through its official channel.";
        }

        // Suspicious links and messages
        if (containsAny(question, "link", "sms", "message",
                "whatsapp", "kyc", "reward", "prize")) {
            return "CHECK BEFORE YOU CLICK\n\n" +
                    "Unexpected messages about blocked accounts, " +
                    "urgent KYC updates, prizes or rewards may be " +
                    "attempts to trick you.\n\n" +
                    "Do not open suspicious links or enter personal " +
                    "details. Open the official app or website " +
                    "independently to verify the claim.";
        }

        // UPI, QR codes and payment requests
        if (containsAny(question, "upi", "payment", "qr",
                "scan", "money", "refund", "collect request",
                "screenshot", "receive money")) {
            return "STAY SAFE WHILE MAKING PAYMENTS\n\n" +
                    "Check the recipient's identity, amount and " +
                    "purpose before approving a payment.\n\n" +
                    "Entering a UPI PIN generally authorises a " +
                    "payment; you do not need to enter your PIN " +
                    "just to receive money. Never approve an " +
                    "unexpected collect request.\n\n" +
                    "Verify successful payments in your own trusted " +
                    "payment app. A screenshot alone is not proof.";
        }

        // Suspicious calls and remote access
        if (containsAny(question, "call", "caller", "police",
                "arrest", "video call", "remote access",
                "screen sharing", "anydesk", "threat")) {
            return "PAUSE AND VERIFY THE CALLER\n\n" +
                    "Scammers may pretend to be bank officials, " +
                    "police or government representatives and " +
                    "use threats to make you panic.\n\n" +
                    "Do not share secrets, install remote-access " +
                    "apps at a caller's request or transfer money " +
                    "to prove your innocence.\n\n" +
                    "End the call and contact the organisation " +
                    "using an independently verified official number.";
        }

        // Lost money / fraud response
        if (containsAny(question, "fraud", "scammed",
                "lost money", "money stolen", "already paid",
                "cheated", "cybercrime")) {
            return "ACT QUICKLY IF FRAUD OCCURS\n\n" +
                    "1. Contact your bank or payment provider " +
                    "immediately and report the transaction.\n\n" +
                    "2. In India, call 1930 promptly to report " +
                    "financial cyber fraud.\n\n" +
                    "3. Submit a complaint at cybercrime.gov.in.\n\n" +
                    "4. Preserve transaction IDs, messages and " +
                    "other evidence. Never share your OTP or PIN " +
                    "with anyone claiming they can recover your money.";
        }

        // Account security
        if (containsAny(question, "hacked", "hack",
                "account stolen", "account security",
                "secure my account")) {
            return "SECURE YOUR ACCOUNT\n\n" +
                    "Change your password using the official " +
                    "app or website, enable two-factor authentication " +
                    "where available, and sign out unfamiliar sessions.\n\n" +
                    "Secure your linked email account too. If banking " +
                    "details may be compromised, contact your bank " +
                    "immediately.";
        }

        // General fallback
        return "LET'S KEEP YOU SAFE\n\n" +
                "I can currently help with questions about:\n\n" +
                "• OTPs, PINs and passwords\n" +
                "• Suspicious messages, links and KYC requests\n" +
                "• UPI payments, QR codes and refund scams\n" +
                "• Suspicious calls and remote-access apps\n" +
                "• Cyber fraud and account security\n\n" +
                "Try asking a more specific question. This assistant " +
                "uses predefined guidance and cannot verify a person, " +
                "message or transaction directly.";
    }

    private boolean containsAny(String text, String... keywords) {
        for (String keyword : keywords) {
            if (text.contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        if (isMessageScreen || isCallScreen ||
                isPaymentScreen || isAssistantScreen) {
            showHomeScreen();
        } else {
            super.onBackPressed();
        }
    }
}
