package com.deepakjetpackcompose.artestapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.deepakjetpackcompose.artestapp.ui.navigation.NavigationHelper
import kotlin.random.Random

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AlphabetScreen(navController: NavController, modifier: Modifier = Modifier) {
    val uppercaseAlphabetList = listOf(
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
        "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
        "U", "V", "W", "X", "Y", "Z"
    )
    Column (modifier=modifier){
        Box(modifier = Modifier.height(60.dp)) {
            Text(
                "Alphabets", fontSize = 26.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(Modifier.height(10.dp))
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(state = rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            uppercaseAlphabetList.forEach { alphabet ->
                AlphabetItem(
                    alphabet = alphabet,
                    onClick = { navController.navigate(NavigationHelper.ARSCREEN(model = alphabet)) })
            }

        }
    }


}

@Composable
fun AlphabetItem(alphabet: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    val color = remember(alphabet) { generateRandomColor() }
    Box(
        modifier = Modifier
            .padding(16.dp)

            .size(60.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color)
            .clickable(onClick = onClick)
    ) {
        Text(
            text = alphabet,
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }


}

fun generateRandomColor(): Color {
    val random = Random(System.currentTimeMillis())
    val red = random.nextInt(150, 256)
    val green = random.nextInt(150, 256)
    val blue = random.nextInt(150, 256)

    val color = Color(red, green, blue)
    return color
}