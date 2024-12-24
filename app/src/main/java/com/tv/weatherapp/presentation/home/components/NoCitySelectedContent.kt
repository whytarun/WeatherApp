package com.tv.weatherapp.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tv.weatherapp.R
import com.tv.weatherapp.presentation.ui.theme.WeatherAppTheme

@Composable
fun NoCitySelectedContent() {

     Column(
         modifier = Modifier
             .fillMaxSize()
             .padding(16.dp),
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center
     ) {

         Text(
             text = "No City Selected",
             textAlign = TextAlign.Center,
             style = MaterialTheme.typography.headlineMedium,
             fontWeight = FontWeight.Bold,
             color = colorResource(id = R.color.city_name_text)
         )

         Text(
             text = "Please Search For A City",
             textAlign = TextAlign.Center,
             fontWeight = FontWeight.SemiBold,
             style = MaterialTheme.typography.bodyMedium,
             modifier = Modifier.padding(top=4.dp),
             color = Color.Black
         )
     }
}

@Preview(showBackground = true)
@Composable
fun NoCitySelectedContentPreview(){
    WeatherAppTheme {
        NoCitySelectedContent()
    }
}