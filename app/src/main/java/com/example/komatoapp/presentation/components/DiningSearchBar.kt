package com.example.komatoapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.komatoapp.R

@Composable
fun DiningSearchBar(modifier: Modifier = Modifier) {
    var query by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp)
            .shadow(2.dp, shape = RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .border(1.dp, Color.Gray, RoundedCornerShape(16.dp))
            .clickable {
                // navigate to SearchBarScreen
            },
        verticalAlignment = Alignment.CenterVertically){

        Spacer(modifier = Modifier.width(16.dp))

        Icon(
            Icons.Default.Search,
            tint = Color.Gray,
            contentDescription = "Search Icon",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))

        BasicTextField(
            value = query,
            onValueChange = {query = it},
            textStyle = TextStyle(
                fontSize = 15.sp,
                color = Color.Gray
            ),
            enabled = false,
            singleLine = true,
            modifier = Modifier
                .weight(1f)
                .padding(12.dp),
            decorationBox = {innerTextField ->

                if (query.isEmpty()){
                    Text(
                        text = "Search Restaurant",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                }
                innerTextField()
            }

        )
        Spacer(modifier =Modifier.width(8.dp))

        Icon(
            painter = painterResource(R.drawable.mic),
            contentDescription = "Voice Search",
            tint = Color.Gray,
            modifier = Modifier.size(24.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun DinginPreview() {
    DiningSearchBar()

}