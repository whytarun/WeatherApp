package com.tv.weatherapp.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tv.weatherapp.R
import com.tv.weatherapp.presentation.Dimens.iconSize
import com.tv.weatherapp.presentation.ui.theme.WeatherAppTheme



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier =Modifier,
    text :String,
    readOnly :Boolean,
    onClick : (() -> Unit)? = null,
    onValueChange : (String) -> Unit,
    onSearch : () -> Unit
) {

    val interactionSource = remember {
        MutableInteractionSource()
    }
    val isClicked = interactionSource.collectIsPressedAsState().value

    LaunchedEffect(key1 = isClicked){
        if(isClicked){
            onClick?.invoke()
        }
    }
    Box(modifier = modifier) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .searchBar(),
            value =text,
            onValueChange = onValueChange,
            readOnly = readOnly,
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription =null,
                    modifier = Modifier.size(iconSize),
                    tint = colorResource(id = R.color.silver)
                )
            },
            placeholder = {
                Text(
                    text = "Search Location",
                    style = MaterialTheme.typography.bodySmall,
                    color = colorResource(id = R.color.silver),
                    fontSize = 18.sp
                )
            },
            shape = RoundedCornerShape(12.dp),
            colors =  TextFieldDefaults.outlinedTextFieldColors(
                containerColor = colorResource(id = R.color.input_background),
                cursorColor = if (isSystemInDarkTheme()) Color.White else Color.Gray,
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearch()
                }
            ),
            textStyle = MaterialTheme.typography.bodySmall,
            interactionSource = interactionSource

        )
    }
}
fun Modifier.searchBar(): Modifier = composed {
    if (!isSystemInDarkTheme()) {
        border(
            width = 1.dp,
            color = Color.LightGray,
            shape = RoundedCornerShape(20.dp)
        )
    } else {
        this
    }
}


@Preview(showBackground = true)
@Composable
fun SearchScreenPreview(){
     WeatherAppTheme {
         SearchBar(text = "", onValueChange = {}, readOnly = false, onSearch = {})
     }
}