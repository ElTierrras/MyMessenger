package co.edu.unipiloto.mymessenger

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var chatHistory: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val receivedChat = intent.getStringExtra("CHAT_HISTORY") ?: ""
        val chatHistoryView = findViewById<TextView>(R.id.chatHistory)

        if (receivedChat.isNotEmpty()) {
            chatHistory = receivedChat
            chatHistoryView.text = chatHistory
        }
    }

    fun sendMessage(view: View) {
        val messageInput = findViewById<EditText>(R.id.messageInput)
        val message = messageInput.text.toString()

        if (message.isNotEmpty()) {
            chatHistory += "Propietario: $message\n"
            val intent = Intent(this, ReceiveMessageActivity::class.java).apply {
                putExtra("CHAT_HISTORY", chatHistory)
            }
            startActivity(intent)
        }
    }
}
