package com.example.d5_baitap2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.d5_baitap2.ui.theme.D5_baitap2Theme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            D5_baitap2Theme {
                BusinessCard()
            }
        }
    }
}


@Composable
fun BusinessCard() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD7ECD5))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Phần thông tin chính
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = "Android Logo",
                modifier = Modifier.size(120.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Lê Hoàng Phúc",
                fontSize = 25.sp
            )

            Text(
                text = "Android Developer Extraordinaire",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF16823B)
            )
        }

        // Thông tin liên hệ
        Column(
            modifier = Modifier.padding(bottom = 32.dp)
        ) {

            ContactItem(
                icon = "☎",
                text = "+84 942767081"
            )

            ContactItem(
                icon = "♣",
                text = "@AndroidDev"
            )

            ContactItem(
                icon = "✉",
                text = "hcmute.edu.vn"
            )
        }
    }
}


@Composable
fun ContactItem(
    icon: String,
    text: String
) {

    Row(
        modifier = Modifier.padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = icon,
            fontSize = 20.sp,
            color = Color(0xFF16823B),
            modifier = Modifier.padding(end = 16.dp)
        )

        Text(
            text = text,
            fontSize = 14.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    D5_baitap2Theme {
        BusinessCard()
    }
}