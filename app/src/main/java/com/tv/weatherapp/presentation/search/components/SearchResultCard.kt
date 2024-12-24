package com.tv.weatherapp.presentation.search.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tv.weatherapp.R
import com.tv.weatherapp.domain.model.WeatherData
import com.tv.weatherapp.presentation.Dimens.MediumPadding1


@Composable
fun SearchResultCard(
    weatherData: WeatherData,
    onClick :() -> Unit
) {

  Card(
      modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 8.dp)
          .clickable(onClick = onClick),
      elevation = CardDefaults.cardElevation(
          defaultElevation = 8.dp
      ),
      shape = RoundedCornerShape(16.dp),
      colors = CardDefaults.cardColors(
          containerColor = colorResource(id = R.color.input_background)
      )
  ) {

        Row ( modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = weatherData.cityName,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = "${weatherData.temperature}",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "°",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontSize = 20.sp
                        ),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.offset(y = (-4).dp)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                painter = painterResource(id = R.drawable.ic_cloudy),
                contentDescription = null,
                modifier = Modifier.size(100.dp),
                tint = Color.Unspecified
            )
        }
  }
}