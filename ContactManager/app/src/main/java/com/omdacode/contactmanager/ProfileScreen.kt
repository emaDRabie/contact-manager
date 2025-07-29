package com.omdacode.contactmanager


import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    var bio by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileImage()
        Spacer(modifier = Modifier.height(16.dp))
        UserNameText()
        Spacer(modifier = Modifier.height(16.dp))
        BioTextField(bio = bio, onBioChange = { bio = it })
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SaveButton()
            ShareButton(bio = bio)
        }
    }
}

@Composable
fun ProfileImage() {
    Image(
        painter = painterResource(id = R.drawable.person),
        contentDescription = "Profile picture",
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
    )
}

@Composable
fun UserNameText() {
    Text(
        text = "Emad Rabie",
        fontSize = 24.sp,
        color = MaterialTheme.colorScheme.primary,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun BioTextField(bio: String, onBioChange: (String) -> Unit) {
    BasicTextField(
        value = bio,
        onValueChange = onBioChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        decorationBox = { innerTextField ->
            if (bio.isEmpty()) {
                Text(
                    text = "Enter bio...",
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                )
            }
            innerTextField()
        }
    )
}

@Composable
fun SaveButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .padding(8.dp)
            .width(120.dp)

    ) {
        Text(
            text = "Save",
            fontSize = 16.sp
        )
    }
}

@Composable
fun ShareButton(bio: String) {
    val context = LocalContext.current
    Button(
        onClick = {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, bio.ifEmpty { "Check out my profile :)" })
            }
            context.startActivity(Intent.createChooser(shareIntent, "Share via"))
        },
        modifier = Modifier
            .padding(8.dp)
            .width(120.dp)
    ) {
        Text(
            text = "Share",
            fontSize = 16.sp
        )
    }
}