package com.example.trivialapp_base.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.trivialapp_base.viewmodel.GameViewModel
import com.example.trivialapp_base.ui.theme.*

@Composable
fun MenuScreen(navController: NavController, viewModel: GameViewModel) {

    val difficulties = listOf("Easy", "Medium", "Hard")
    var actualDifficulty: String by remember { mutableStateOf("Easy") }
    var expanded: Boolean by remember { mutableStateOf(false) }
    viewModel.setDificultad(actualDifficulty)

    Column (horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight()
            .background(SHINee)
    ) {

        Text("The mega succulent and not at all complicated trivia game",
            fontFamily = FontFamily.Serif,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(20.dp)
        )
        Text("By Yoon and Hector",
            modifier = Modifier.padding(20.dp))
        Image(
            painter = painterResource(id = com.example.trivialapp_base.R.drawable.payaso),
            contentDescription = "Example",
            modifier = Modifier
                .padding(20.dp)
                .clip(RoundedCornerShape(100f))
        )
        Column {
            OutlinedTextField(
                value = actualDifficulty,
                onValueChange = { actualDifficulty = it },
                enabled = false,
                readOnly = true,
                modifier = Modifier
                    .clickable { expanded = true }
                    .width(300.dp)
                    .background(DarkSHINee)
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(5.dp, DarkSHINee, RoundedCornerShape(4.dp))
                    .background(LightSHINee)
            ) {
                difficulties.forEach { difficult ->
                    DropdownMenuItem(
                        text = { Text(text = difficult) },
                        onClick = {
                            expanded = false
                            actualDifficulty = difficult
                            viewModel.setDificultad(difficult)
                        })
                }
            }
        }
            Button(onClick = {
                    navController.navigate("GameScreen")
                    viewModel.iniciarJuego()
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightSHINee,
                    contentColor = Color.Black
                ),
                modifier = Modifier.padding(20.dp)
            )
            {
                Text("Start")
            }

    }
}

@Composable
fun Spacer (){
    HorizontalDivider(
        modifier = Modifier
            .padding(0.dp, 10.dp),
        thickness = 3.dp,
        color = SHINee
    )
}
