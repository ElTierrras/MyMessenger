package co.edu.unipiloto.mymessenger

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReceiveMessageActivity : AppCompatActivity() {
    private var chatHistory: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive_message)

        val receivedMessage = findViewById<TextView>(R.id.receivedMessage)
        chatHistory = intent.getStringExtra("CHAT_HISTORY") ?: ""

        if (chatHistory.isNotEmpty()) {
            receivedMessage.text = chatHistory
        }
    }

    fun sendReply(view: View) {
        val messageInput = findViewById<EditText>(R.id.messageInput)
        val message = messageInput.text.toString()

        if (message.isNotEmpty()) {
            chatHistory += "Cuidador: $message\n"
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("CHAT_HISTORY", chatHistory)
            }
            startActivity(intent)
        }
    }
}
