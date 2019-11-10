package com.kryptonapp.lazydo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db: FirebaseFirestore  = FirebaseFirestore.getInstance()
        val document: DocumentReference = db.collection("users-test").document("adnaan1703")
        val user: HashMap<String, Any> = hashMapOf(
            "name" to "Adnaan Ahmed",
            "age" to 26,
            "mobile" to "+919903207591"
        )
        val user2 = User("Zoheb Ahmed", 31, "+919339435993")

        db.collection("users-test")
            .document("zoheb2701")
            .set(user2)
            .addOnSuccessListener { Toast.makeText(this, "Written successfully", Toast.LENGTH_LONG).show() }
            .addOnFailureListener { Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show() }

//
//        document.set(user)
//            .addOnSuccessListener { Toast.makeText(this, "Written successfully", Toast.LENGTH_LONG).show() }
//            .addOnFailureListener { Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show() }

    }

    data class User(val name: String, val age: Int, val mobile: String)
}
