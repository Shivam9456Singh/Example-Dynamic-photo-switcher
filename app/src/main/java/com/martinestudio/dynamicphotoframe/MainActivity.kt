package com.martinestudio.dynamicphotoframe

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.jar.Attributes.Name

class MainActivity : AppCompatActivity() {
    // making name array with the address of the image as 0,1,2,3,4 with proper name for each image
lateinit var image:ImageView
    var currentImage =0

    var nameImage = arrayOf("IIT Indore","IIT Hyderabad","IIT Kanpur", "IIT Delhi","IIT Bombay")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prev = findViewById<ImageView>(R.id.Imgprev)
        val next = findViewById<ImageView>(R.id.Imgnext)
        val imageText = findViewById<TextView>(R.id.imgLabel)

        prev.setOnClickListener{
          val idCurrentImageString = "pic$currentImage"

            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",this.packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (5 + currentImage-1)%5

            val idImageToShowString = "pic$currentImage"
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",this.packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f
            imageText.text = nameImage[currentImage]

        }

        next.setOnClickListener{
            val idCurrentImageString = "pic$currentImage"
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",this.packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = ( 5 + currentImage+1)%5

            val idImageToShowString = "pic$currentImage"
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",this.packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f
            imageText.text = nameImage[currentImage]

        }

    }
}