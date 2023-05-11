import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChatLockActivity extends Activity {
    
    private EditText pinEditText;
    private Button unlockButton;
    private String correctPin = "1234"; // replace with your own PIN
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // set the activity to full screen and prevent screenshot
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE);
        
        setContentView(R.layout.activity_chat_lock);
        
        pinEditText = (EditText) findViewById(R.id.pin_edittext);
        unlockButton = (Button) findViewById(R.id.unlock_button);
        
        unlockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pin = pinEditText.getText().toString();
                if (pin.equals(correctPin)) {
                    // unlock the chat
                    Intent intent = new Intent(ChatLockActivity.this, ChatActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // display an error message
                    Toast.makeText(ChatLockActivity.this, "Incorrect PIN", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
