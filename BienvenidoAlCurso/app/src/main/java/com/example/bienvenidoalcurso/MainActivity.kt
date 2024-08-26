package com.example.bienvenidoalcurso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bienvenidoalcurso.R
import com.example.bienvenidoalcurso.ui.theme.BienvenidoAlCursoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BienvenidoAlCursoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardScreen()
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD0E8D7)),
        color = Color(0xFFD0E8D7)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            // Imagen del logo
            Image(
                painter = painterResource(id = R.drawable.images), // Asume que la imagen está en drawable
                contentDescription = "Android Logo",
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre de la persona
            Text(
                text = "Robbiejude Murillo ",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Descripción del puesto
            Text(
                text = "Estudiante de Tecsup",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF388E3C)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Información de contacto
            ContactInfo(Icons.Filled.Phone, "+11 (123) 444 555 666")
            Spacer(modifier = Modifier.height(8.dp))
            ContactInfo(Icons.Filled.Share, "@AndroidDev")
            Spacer(modifier = Modifier.height(8.dp))
            ContactInfo(Icons.Filled.Email, "jen.doe@android.com")
        }
    }
}

@Composable
fun ContactInfo(icon: androidx.compose.ui.graphics.vector.ImageVector, info: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(4.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color(0xFF388E3C)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = info,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BienvenidoAlCursoTheme {
        BusinessCardScreen()
    }
}

