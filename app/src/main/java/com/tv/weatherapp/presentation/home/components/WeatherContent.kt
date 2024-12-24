package com.tv.weatherapp.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tv.weatherapp.R
import com.tv.weatherapp.domain.model.WeatherData
import com.tv.weatherapp.presentation.Dimens.WeatherIconSize


@Composable
fun WeatherContent(
    weatherData: WeatherData
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AsyncImage(
            modifier = Modifier
                .size(WeatherIconSize)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(weatherData.fullWeatherIcon).build(),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = weatherData.cityName,
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = (-1).sp
                )
            )
            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                painter = painterResource(id = R.drawable.ic_arrowforward),
                contentDescription = null,
                modifier = Modifier
                    .padding(top=8.dp)
                    .padding(6.dp)
                    .size(24.dp),
                tint = Color.Black

            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.padding(vertical = 24.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "${weatherData.temperature}",
                style = MaterialTheme.typography.displayLarge.copy(
                    fontSize = 66.sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = (-2).sp
                )
            )
            Text(
                text = "°",
                style = MaterialTheme.typography.displayLarge.copy(
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.offset(y = (-8).dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.input_background)

            ),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 1.dp
            )
        ) {
            Row(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                WeatherStats(label = "Humidity", value = "${weatherData.humidity}%")
                WeatherStats(label = "UV Index", value = "${weatherData.uvIndex}")
                WeatherStats(label = "Feels Like", value = "${weatherData.feelsLike} ° ")
            }
        }

    }
}