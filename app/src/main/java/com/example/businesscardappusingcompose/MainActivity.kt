package com.example.businesscardappusingcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscardappusingcompose.ui.theme.BusinessCardAppUsingComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppUsingComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun Introduction() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Logo",
    )
    Text(
        text = "John Doe",
        style = MaterialTheme.typography.displaySmall,
        fontWeight = FontWeight.Light,
    )
    Text(
        text = "App Developer",
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.SemiBold,
    )
}

@Composable
fun ContactRow(
    icon: ImageVector,
    description: String,
    detail: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp),
    ) {
        Box {
            Icon(
                imageVector = icon,
                contentDescription = description,
            )
        }
        Spacer(
            modifier = Modifier.padding(4.dp),
        )
        Text(
            text = detail,
            modifier = Modifier.width(150.dp),
        )
    }
}

@Composable
fun ContactDetails() {
    ContactRow(
        icon = Icons.Default.Phone,
        description = "Contact Number",
        detail = "+91 1234567890",
    )
    ContactRow(
        icon = Icons.Default.Email,
        description = "Email Address",
        detail = "email@gmail.com",
    )
    ContactRow(
        icon = Icons.Default.AccountCircle,
        description = "Social Media Handle",
        detail = "@username",
    )
}

@Composable
fun BusinessCardScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.hsl(240f, 0.75f, 0.75f))
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(2f)
                .fillMaxSize(),
        ) {
            Introduction()
        }
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
        ) {
            ContactDetails()
        }
    }
}

@Preview
@Composable
fun BusinessCardScreenPreview() {
    BusinessCardAppUsingComposeTheme {
        BusinessCardScreen()
    }
}